import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-currencies',
  templateUrl: './currencies.component.html',
  styleUrls: ['./currencies.component.css'],
})
export class CurrenciesComponent implements OnInit {
  value: number = 0;

  constructor() {}

  ngOnInit(): void {
    this.value = 1568.26;
  }
}
