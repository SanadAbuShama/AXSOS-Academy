import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-datetime',
  templateUrl: './datetime.component.html',
  styleUrls: ['./datetime.component.css'],
})
export class DatetimeComponent implements OnInit {
  date: Date | undefined;

  constructor() {}

  ngOnInit(): void {
    this.date = new Date();
  }
}
