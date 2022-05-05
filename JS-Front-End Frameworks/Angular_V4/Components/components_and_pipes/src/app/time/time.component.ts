import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-time',
  templateUrl: './time.component.html',
  styleUrls: ['./time.component.css'],
})
export class TimeComponent implements OnInit {
  date: Date | undefined;
  constructor() {}

  ngOnInit(): void {
    this.date = new Date();
  }
}
