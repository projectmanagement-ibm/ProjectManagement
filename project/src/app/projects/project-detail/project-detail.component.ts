import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, FormControl, Validators, Form} from '@angular/forms';
import { Observable } from 'rxjs/Observable';
// @ts-ignore
import {ProjectService} from '../../services/project.service';
import {ActivatedRoute, Router, UrlSegment} from '@angular/router';
import {map} from 'rxjs/operators';
import {Project} from '../../models/project.model';
import { MatDatepickerModule } from '@angular/material';
import { MatDatepickerToggle } from '@angular/material';


@Component({
  selector: 'app-project-detail',
  templateUrl: './project-detail.component.html',
  styleUrls: ['./project-detail.component.scss']
})
export class ProjectDetailComponent implements OnInit {

  formGroup: FormGroup;
  post: any = '';

  id = 0;
  projectId: Number;
  project: Project;
  name: String;
  projectDescription: String;
  startDate: Date;
  endDate: Date;
  status: String;
  isUpdate = false;
  managers: any[];
  minDate = new Date(2017, 0, 1);
  maxDate = new Date(2020, 0, 1);
  minDate1 = new Date(2020, 0, 1);
  maxDate1 = new Date(2025, 0, 1);

  constructor(
      private formBuilder: FormBuilder,
      private projectsService: ProjectService,
      private router: Router,
      private activatedRoute: ActivatedRoute,

  ) {


    this.activatedRoute.url.subscribe((s: UrlSegment[]) => {
      if (s[1]) {
        console.log('url', s[1].path);
        // tslint:disable-next-line:radix
        this.id = parseInt(s[1].path);
        console.log('id=====', this.id);
        if (this.id > 0) {
          console.log('at line 422222');
          this.isUpdate = true;
          this.getProjectById();
        }
      }
    })

  }

  ngOnInit() {
    this.getAllManager();
    this.createForm();
  };


  createForm() {
    const name = /^[a-zA-Z]{3,30}$/;
    // tslint:disable-next-line:max-line-length

    this.formGroup = this.formBuilder.group({
      'name': [null, [
        Validators.required,
      ]],
      'projectDescription': [null,
        [Validators.required,
          Validators.minLength(3),
          Validators.maxLength(500)
        ]],
      'startDate': [null, [Validators.required,

      ]],
      'endDate': [null, [Validators.required,


      ]],
      'status': [null, [Validators.required,
        Validators.minLength(3),
        Validators.maxLength(50)
      ]],
      'userId': [
          null, [Validators.required]
      ]
    })
  }

  getAllManager() {
    this.projectsService.getAllManager()
        .subscribe(response => {
          this.managers = response.json();
        })
  }

  getProjectById() {
    this.projectsService.getProjectById(this.id)
        .subscribe(response => {
          this.project = response.json();
          if (this.project) {
            this.projectId = this.project.id,
                this.name = this.project.name;
            this.projectDescription = this.project.projectDescription;
            this.startDate = this.project.startDate;
            this.endDate = this.project.endDate;
            this.status = this.project.status;
            console.log('user at 32', this.project);
          }
        })
  }

  onSubmit(post) {
    this.post = post;
    console.log('post===', post);
    console.log('isupdate at 92', this.isUpdate);
    if (this.isUpdate) {
      this.updateProject(this.post);
    } else {
      this.createProject(this.post);
    }
  }


  createProject(project) {
    console.log('user at 111==', project);
    this.projectsService.createProject(project)
        .subscribe(response => {
          console.log('response', response);
          this.router.navigate(['/project-list']);
        }, error => {
          console.log('error', error);
        })
  }

  updateProject(project) {
    project['roleId'] = 2;
    console.log('update user at 123==', project);

    project['id'] = this.projectId;
    this.projectsService.editProject(project)
        .subscribe(response => {
          console.log('response', response);
          this.isUpdate = false;
          this.router.navigate(['/project-list']);
        }, error => {
          console.log('error', error);
        })
  }

  onClose() {
    this.router.navigate(['/project-list']);
  }
}
