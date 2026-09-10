import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import {FormsModule} from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, FormsModule, CommonModule],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  decimalValue: number = 0;
  bits: boolean[] = [false, false, false, false, false, false, false, false];

  updateDecimalFromBits(): void {
    let sum = 0;
    for(let i = 0; i < 8; i++){
      if(this.bits[i]){
        sum += 1 << (7 - i);
      }
    }
    this.decimalValue = sum;
  }

  updateBitsFromDecimal(): void {
    let value = Number(this.decimalValue);
    if(value < 0){
      value = 0;
    }
    if(value > 255){
      value = 255;
    }

    this.decimalValue = value;

    for(let i = 0; i < 8; i++){
      const bitValue = 1 << (7 - i);
      this.bits[i] = (value & bitValue) !== 0;
    }
  }

  protected readonly title = signal('angular-project');
}
