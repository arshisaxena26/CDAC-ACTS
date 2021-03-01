package io.covid19vms.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Table(name = "district_office")
public class DistrictOffice extends User {

    @Column(name = "office_name", length = 50)
    private String officeName;

    @Column(name = "district_inventory")
    private int districtInventory;

    @OneToOne(targetEntity = District.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "district_id")
    private District district;
    
    @Column(name="is_approved")
    private Boolean isApproved=false;
    
    @JsonIgnoreProperties("districtOffice")
    @OneToMany(mappedBy = "districtOffice")
    private List<VaccinationCentre> centres = new ArrayList<>();

    public DistrictOffice() {
    }

    public String getOfficeName() {
        return officeName;
    }

    public void setOfficeName(String officeName) {
        this.officeName = officeName;
    }

    public int getDistrictInventory() {
        return districtInventory;
    }

    public void setDistrictInventory(int districtInventory) {
        this.districtInventory = districtInventory;
    }

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

    public List<VaccinationCentre> getCentres() {
        return centres;
    }

    public void setCentres(List<VaccinationCentre> centres) {
        this.centres = centres;
    }

    public void addVaccinationCentre(VaccinationCentre centre) {
        centres.add(centre);
        centre.setDistrictOffice(this);
    }

	public Boolean getIsApproved() {
		return isApproved;
	}

	public void setIsApproved(Boolean isApproved) {
		this.isApproved = isApproved;
	}
}
