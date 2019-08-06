import { Component, OnInit } from '@angular/core';
import * as Chartist from 'chartist';
import {Project} from '../models/project.model';
import { MatCarousel, MatCarouselComponent } from '@ngmodule/material-carousel';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {


    constructor(
    ) {
    }

    ngOnInit() {
    }
}



