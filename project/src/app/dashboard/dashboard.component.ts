import { Component, OnInit } from '@angular/core';
import * as Chartist from 'chartist';
import {Project} from '../models/project.model';
import {ProjectService} from "../services/project.service";

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {
   projects: Project[];
  constructor(
      private projectService: ProjectService
  ) { }
  ngOnInit() {
      this.getProjects();
  }

    getProjects() {
        this.projectService.getProjects()
            .subscribe(response => {
                this.projects = response.json();
                console.log('projects', response);
                // tslint:disable-next-line:no-shadowed-variable
            }, error => {
                console.log('error', error);
            })
    }


}
