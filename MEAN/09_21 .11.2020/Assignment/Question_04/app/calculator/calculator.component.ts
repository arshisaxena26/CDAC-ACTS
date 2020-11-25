import { Component, OnInit } from '@angular/core';
import { CalculatorService } from '../calculator.service';

@Component({
  selector: 'app-calculator',
  templateUrl: './calculator.component.html',
  styleUrls: ['./calculator.component.css']
})
export class CalculatorComponent {
  firstNum: number = 0;
  secNum: number = 0;
  singleNum: number = 0;
  numString: string = "";
  sub: number = 0;
  mul: number = 0;
  div: number = 0;
  sq: number = 0;
  fact: number = 0;
  sumValue: number = 0;

  constructor(private calcservice: CalculatorService) { }

  subtract() {
    this.sub = this.calcservice.getSubtractedValue(this.firstNum, this.secNum);
  }

  multiply() {
    this.mul = this.calcservice.getMultipliedValue(this.firstNum, this.secNum);
  }

  divide() {
    if (this.firstNum != 0 && this.secNum != 0)
      this.div = this.calcservice.getDividedValue(this.firstNum, this.secNum);
  }

  square() {
    this.sq = this.calcservice.getSquaredValue(this.singleNum);
  }

  factorial() {
    if (this.singleNum != 0)
      this.fact = this.calcservice.getFactorial(this.singleNum);
  }

  sum() {
    if (this.numString != "")
      this.sumValue = this.calcservice.getSumValue(this.numString);
  }
}
