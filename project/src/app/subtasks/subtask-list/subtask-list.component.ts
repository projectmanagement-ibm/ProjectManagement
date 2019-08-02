import { Subtask } from './../../models/subtask.model';
import { SubtaskService } from './../../services/subtask.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-subtask-list',
  templateUrl: './subtask-list.component.html',
  styleUrls: ['./subtask-list.component.scss']
})
export class SubtaskListComponent implements OnInit {

  subtasks: Subtask[];
  constructor(
    private subtaskService: SubtaskService
    ,
    private router: Router,
  ) { }

  ngOnInit() {
    this.getSubtask();
  }


  getSubtask() {
    this.subtaskService.getSubtask()
      .subscribe(response => {
        this.subtasks = response.json();
        console.log('users', response);
      }, error => {
        console.log('error', error);
      })
  }

  onAddSubtask() {
    this.router.navigate(['/add-subtask']);
  }

  onEdit(subtask) {
    console.log('user onedit', subtask);
    this.router.navigate(['/edit-subtask', subtask.id]);
  }

  onRemove(subtask) {
    console.log('user onremove', subtask);

    this.subtaskService.deleteSubtask(subtask.id)
      .subscribe(response => {
        console.log('response on delete', response);
        this.getSubtask();
      })
  }
}

