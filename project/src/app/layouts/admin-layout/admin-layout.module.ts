import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AdminLayoutRoutes } from './admin-layout.routing';
import { DashboardComponent } from '../../dashboard/dashboard.component';
import { UserProfileComponent } from '../../Users/user-profile/user-profile.component';
import {ProjectDetailComponent} from '../../projects/project-detail/project-detail.component';
import {ProjectListComponent} from '../../projects/project-list/project-list.component';
import {TaskDetailComponent} from '../../tasks/task-detail/task-detail.component';
import {SubtaskDetailComponent} from '../../subtasks/subtask-detail/subtask-detail.component';
import {SubtaskListComponent} from '../../subtasks/subtask-list/subtask-list.component';
import {TaskListComponent} from '../../tasks/task-list/task-list.component';
import { TableListComponent } from '../../table-list/table-list.component';
import { TypographyComponent } from '../../typography/typography.component';
import { IconsComponent } from '../../icons/icons.component';
import { MapsComponent } from '../../maps/maps.component';
import { NotificationsComponent } from '../../notifications/notifications.component';
import { UpgradeComponent } from '../../upgrade/upgrade.component'
import {UserListComponent} from '../../Users/user-list/user-list.component';


import {
  MatButtonModule,
  MatInputModule,
  MatRippleModule,
  MatFormFieldModule,
  MatTooltipModule,
  MatDatepickerModule,
  MatNativeDateModule,
  MatSelectModule
} from '@angular/material';
import {AuthService} from '../../services/auth.service';
import {AuthGuard} from '../../auth.guard';
import {NgxPaginationModule} from 'ngx-pagination';
import {Ng2SearchPipeModule} from 'ng2-search-filter';
import {CarouselModule} from "angular-bootstrap-md";

@NgModule({
    imports: [
        CommonModule,
        RouterModule.forChild(AdminLayoutRoutes),
        FormsModule,
        ReactiveFormsModule,
        MatButtonModule,
        MatRippleModule,
        MatFormFieldModule,
        MatInputModule,
        MatSelectModule,
        MatTooltipModule,
        MatDatepickerModule,
        MatNativeDateModule,
        NgxPaginationModule, Ng2SearchPipeModule, CarouselModule
    ],
  declarations: [
    DashboardComponent,
    UserProfileComponent,
    UserListComponent,
    ProjectDetailComponent,
    ProjectListComponent,
    TaskDetailComponent,
    SubtaskDetailComponent,
    SubtaskListComponent,
    TaskListComponent,
    TableListComponent,
    TypographyComponent,
    IconsComponent,
    MapsComponent,
    NotificationsComponent,
    UpgradeComponent,
  ],
  providers: [AuthService, AuthGuard, MatDatepickerModule ]
})

export class AdminLayoutModule {}
