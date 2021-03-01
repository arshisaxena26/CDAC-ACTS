import { Component, Input, OnDestroy, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { appointmentDTO } from 'src/models/appointmentDTO.model';
import { BeneficiaryService } from '../../services/beneficiary.service';

@Component({
  selector: 'app-beneficiary-appointments',
  templateUrl: './beneficiary-appointments.component.html',
  styleUrls: ['./beneficiary-appointments.component.scss']
})
export class BeneficiaryAppointmentsComponent implements OnInit , OnDestroy{

  appointment= {} as appointmentDTO;
  subscription: Subscription | undefined;

  constructor(private beneficiaryService: BeneficiaryService) { }
  

  ngOnInit(): void {
    this.subscription = this.beneficiaryService.getAppointment().subscribe(
      (res:any) => {
        this.appointment = res;
      }
    );
  }

  ngOnDestroy(): void {
    if (this.subscription) {
      this.subscription.unsubscribe();
    }
  }

}
