import { Component, OnInit } from '@angular/core';
import { ProjectService } from '../../services/project.service';
import {Router} from '@angular/router';

import {Project} from '../../models/project.model';
import {error} from 'selenium-webdriver';
import {LoginService} from '../../services/login.service';
import {AuthService} from '../../services/auth.service';

@Component({
  selector: 'app-project-list',
  templateUrl: './project-list.component.html',
  styleUrls: ['./project-list.component.scss']
})

export class ProjectListComponent implements OnInit {

  projects: Project[];
  userProjects: Project[];
  role: String;
    filter: string;
    p: any;

  constructor(
      private projectService: ProjectService,
      private router: Router,
      private auth: AuthService
  ) { }

  ngOnInit() {
    this.role = this.auth.getRole();
    if (this.role === 'admin') {
    this.getProjects();
    } else {
        this.getProjectByUserId();
    }
  }

    getProjectByUserId() {
      this.projectService.getProjectByUserId()
          .subscribe(response => {
             this.userProjects = response.json();
              // tslint:disable-next-line:no-shadowed-variable
          }, error => {
              console.log('error', error);
          })
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

  onAddProject() {
    this.router.navigate( ['/add-project']);
  }


  onEdit(project) {
    console.log('project onedit', project);
    this.router.navigate( ['/update-project', project.id] );
  }


  onRemove(project) {
    console.log('project onremove', project);

    this.projectService.deleteProject(project.id)
        .subscribe( reponse => {
          console.log('response on delete', reponse);
          this.getProjects();
        })
  }
}



