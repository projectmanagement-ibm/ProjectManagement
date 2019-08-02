import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { RouterModule } from '@angular/router';
import { AppRoutingModule } from './app.routing';
import { ComponentsModule } from './components/components.module';
import { AppComponent } from './app.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { UserProfileComponent } from './Users/user-profile/user-profile.component';
import { TableListComponent } from './table-list/table-list.component';
import { TypographyComponent } from './typography/typography.component';
import { IconsComponent } from './icons/icons.component';
import { MapsComponent } from './maps/maps.component';
import { NotificationsComponent } from './notifications/notifications.component';
import { UpgradeComponent } from './upgrade/upgrade.component';
import { AgmCoreModule } from '@agm/core';
import { AdminLayoutComponent } from './layouts/admin-layout/admin-layout.component';
import { UserListComponent } from './Users/user-list/user-list.component';
import { UsersService } from './services/users.service';
import { ProjectDetailComponent } from './projects/project-detail/project-detail.component';
import { ProjectListComponent } from './projects/project-list/project-list.component';
import { TaskDetailComponent } from './tasks/task-detail/task-detail.component';
import { SubtaskDetailComponent } from './subtasks/subtask-detail/subtask-detail.component';
import { SubtaskListComponent } from './subtasks/subtask-list/subtask-list.component';
import { TaskListComponent } from './tasks/task-list/task-list.component';
import { ProjectService } from './services/project.service';
import { TaskService } from './services/task.service';
import { SubtaskService } from './services/subtask.service';
import {  MatDatepickerModule, MatNativeDateModule } from '@angular/material';
import { BsDatepickerModule } from 'ngx-bootstrap/datepicker';

@NgModule({
  imports: [
    BrowserAnimationsModule,
    FormsModule,
    ReactiveFormsModule,
    HttpModule,
   
    MatDatepickerModule,
    MatNativeDateModule,
    ComponentsModule,
    RouterModule,
    MatDatepickerModule,
    AppRoutingModule,
    AgmCoreModule.forRoot({
      apiKey: 'YOUR_GOOGLE_MAPS_API_KEY'
    }),
    BsDatepickerModule.forRoot()
  ],
  declarations: [
    AppComponent,
    AdminLayoutComponent,
  ],
  providers: [
    UsersService,
    ProjectService,
    TaskService,
    SubtaskService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
