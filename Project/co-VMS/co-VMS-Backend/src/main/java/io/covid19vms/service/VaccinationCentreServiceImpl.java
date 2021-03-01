package io.covid19vms.service;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.covid19vms.dto.VaccinationCentreFeedbackDto;
import io.covid19vms.dto.VaccinationCentreRequestDto;
import io.covid19vms.entity.Appointment;
import io.covid19vms.entity.Beneficiary;
import io.covid19vms.entity.VaccinationCentre;
import io.covid19vms.entity.VaccinationInventory;
import io.covid19vms.repository.AppointmentRepository;
import io.covid19vms.repository.BeneficiaryRepository;
import io.covid19vms.repository.VaccinationCentreRepository;
import io.covid19vms.repository.VaccinationInventoryRepository;

@Service
@Transactional
public class VaccinationCentreServiceImpl implements VaccinationCentreService {

	@Autowired
	private VaccinationCentreRepository repository;

	@Autowired
	private VaccinationInventoryRepository vaccinationInventoryRepo;

	@Autowired
	private BeneficiaryRepository beneficiaryRepo;

	@Autowired
	private AppointmentRepository appointmentRepo;

	@Override
	public VaccinationCentre saveVaccinationCentre(VaccinationCentre vaccinationCentre) {
		return repository.save(vaccinationCentre);
	}

	@Override
	public VaccinationCentreRequestDto getDetailsByAadhar(Integer id, String adhaarNumber) {
		Beneficiary beneficiary = beneficiaryRepo.findByAdhaarNumber(adhaarNumber);
		if (beneficiary != null && beneficiary.getVaccinationCentre().getId().equals(id)) {
			VaccinationCentreRequestDto responseDto = new VaccinationCentreRequestDto();
			responseDto.setAadharNumber(beneficiary.getAdhaarNumber());
			responseDto.setAge(beneficiary.getAge());
			responseDto.setName(beneficiary.getName());

			if (beneficiary.getAppointments() != null) {
				responseDto.setAppointmentDate(beneficiary.getAppointments().getAppointmentDate().toString());
				responseDto.setStatus(beneficiary.getAppointments().isActive());
			}
			return responseDto;
		}
		return null;
	}

	@Override
	public Integer updateCapacity(Integer id, Integer capacity) {
		Optional<VaccinationCentre> returnedVaccinationCentre = repository.findById(id);

		if (returnedVaccinationCentre.get().getInventory() == null) {
			VaccinationInventory newInventory = new VaccinationInventory();

			newInventory.setCentreCapacity(capacity);
			returnedVaccinationCentre.get().addInventory(newInventory);

			vaccinationInventoryRepo.save(newInventory);

			return newInventory.getCentreCapacity();
		} else {
			VaccinationInventory returnedInventory = returnedVaccinationCentre.get().getInventory();
			returnedInventory.setCentreCapacity(capacity);
			vaccinationInventoryRepo.save(returnedInventory);

			return returnedInventory.getCentreCapacity();
		}
	}

	@Override
	public Integer updateStock(Integer id, Integer stock) {
		Optional<VaccinationCentre> returnedVaccinationCentre = repository.findById(id);
		if (returnedVaccinationCentre.get().getInventory() == null) {
			VaccinationInventory newInventory = new VaccinationInventory();
			newInventory.setCentreCapacity(stock);
			returnedVaccinationCentre.get().addInventory(newInventory);
			vaccinationInventoryRepo.save(newInventory);
			return newInventory.getCentreInventory();
		} else {

			VaccinationInventory returnedInventory = returnedVaccinationCentre.get().getInventory();
			returnedInventory.setCentreInventory(stock);
			vaccinationInventoryRepo.save(returnedInventory);
			return returnedInventory.getCentreInventory();
		}
	}

	@Override
	public VaccinationInventory getCapacityAndStock(Integer id) {
		Optional<VaccinationCentre> vaccinationCentre = repository.findById(id);
		return vaccinationCentre.get().getInventory();
	}

	@Override
	public Integer getBeneficiaryReports(Integer id) {
		return beneficiaryRepo.getVaccinatedCountPerCentre(id);
	}

	@Override
	public List<VaccinationCentreFeedbackDto> getBeneficairyFeedbackList(Integer id) {
		Optional<VaccinationCentre> returnedVaccinationCentre = repository.findById(id);
		List<Beneficiary> listOfBeneficiary = beneficiaryRepo.findByVaccinationCentre(returnedVaccinationCentre.get());
		List<VaccinationCentreFeedbackDto> listOfFeedback = new ArrayList<>();

		for (Beneficiary b : listOfBeneficiary) {
			if (b.isVaccinated() && b.getFeedback() != null) {
				Period p = Period.between(LocalDate.now(), b.getAppointments().getAppointmentDate());
				int days = p.getDays();
				listOfFeedback.add(new VaccinationCentreFeedbackDto(b.getAdhaarNumber(), b.getName(), days,
						b.getFeedback().getAdverseEffect()));
			}
		}
		return listOfFeedback;
	}

	@Override
	public Beneficiary updateStatus(String adhaarNumber) {
		Beneficiary returnedBeneficiary = beneficiaryRepo.findByAdhaarNumber(adhaarNumber);
		VaccinationInventory inventory = vaccinationInventoryRepo.findByCentre(returnedBeneficiary.getVaccinationCentre());
		inventory.setCentreInventory(inventory.getCentreInventory() - 1);
		vaccinationInventoryRepo.save(inventory);

		returnedBeneficiary.setVaccinated(true);
		Appointment updatedAppointment = returnedBeneficiary.getAppointments();
		updatedAppointment.setActive(false);
		appointmentRepo.save(updatedAppointment);

		return beneficiaryRepo.save(returnedBeneficiary);
	}

	@Override
	public VaccinationCentre saveBeneficiary(Beneficiary beneficiary, int id) {
		Optional<VaccinationCentre> vc = repository.findById(id);
		vc.get().addBeneficiary(beneficiary);
		return repository.save(vc.get());
	}
}
