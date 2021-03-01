import { Component, OnInit } from '@angular/core';
import { CovidApiService } from 'src/app/services/covid-api.service';
import { CovidApiDTO } from 'src/models/covidApiDTO';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss'],
})
export class HomeComponent implements OnInit {

  public covidData = {} as CovidApiDTO;

  constructor(private covidApi: CovidApiService) {}

  ngOnInit(): void {
    this.covidApi.getCountryWiseDetails().subscribe((data) => {
      this.covidData = data;
    });
  }
}
