import { Component, OnInit } from '@angular/core';
import {BookService, Statistics} from "../../../../api-client/generated-sources/library-api";

@Component({
  selector: 'app-statistics-list',
  templateUrl: './statistics-list.component.html',
  styleUrls: ['./statistics-list.component.scss']
})
export class StatisticsListComponent implements OnInit {
  statistics: Statistics[] = [];

  constructor(private statisticsService: BookService) {}

  ngOnInit(): void {
    this.loadStatistics();
  }

  loadStatistics(): void {
    this.statisticsService.getAllStatistics().subscribe(
      (statistics) => (this.statistics = statistics),
      (error) => console.error('Error fetching statistics', error)
    );
  }
}
