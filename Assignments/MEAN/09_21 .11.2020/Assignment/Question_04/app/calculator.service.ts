import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CalculatorService {

  getSubtractedValue(firstNum: number, secNum: number) {
    return firstNum - secNum;
  }

  getMultipliedValue(firstNum: number, secNum: number) {
    return firstNum * secNum;
  }

  getDividedValue(firstNum: number, secNum: number) {
    return firstNum / secNum;
  }

  getSquaredValue(num: number) {
    return Math.pow(num, 2);
  }

  getFactorial(num: number) {
    var res = 1;
    for (var itr = 2; itr <= num; itr++)
      res *= itr;
    return res;
  }

  getSumValue(numString: string) {
    var numberString: string[] = numString.split(",");
    var sum = 0;

    for (var i = 0; i < numberString.length; i++) {
      sum += parseInt(numberString[i]);
    }
    return sum;
  }
}
