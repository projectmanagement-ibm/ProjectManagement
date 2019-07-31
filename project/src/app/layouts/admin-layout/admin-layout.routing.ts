import { Routes } from '@angular/router';

import { DashboardComponent } from '../../dashboard/dashboard.component';
import { UserProfileComponent } from '../../Users/user-profile/user-profile.component';
import { TableListComponent } from '../../table-list/table-list.component';
import { TypographyComponent } from '../../typography/typography.component';
import { IconsComponent } from '../../icons/icons.component';
import { MapsComponent } from '../../maps/maps.component';
import { NotificationsComponent } from '../../notifications/notifications.component';
import { UpgradeComponent } from '../../upgrade/upgrade.component';
import {UserListComponent} from '../../Users/user-list/user-list.component';
import {ProjectDetailComponent} from "../../projects/project-detail/project-detail.component";
import {ProjectListComponent} from "../../projects/project-list/project-list.component";
import {TaskDetailComponent} from "../../tasks/task-detail/task-detail.component";
import {TaskListComponent} from "../../tasks/task-list/task-list.component";
import {SubtaskDetailComponent} from "../../subtasks/subtask-detail/subtask-detail.component";
import {SubtaskListComponent} from "../../subtasks/subtask-list/subtask-list.component";

export const AdminLayoutRoutes: Routes = [
    // {
    //   path: '',
    //   children: [ {
    //     path: 'dashboard',
    //     component: DashboardComponent
    // }]}, {
    // path: '',
    // children: [ {
    //   path: 'userprofile',
    //   component: UserProfileComponent
    // }]
    // }, {
    //   path: '',
    //   children: [ {
    //     path: 'icons',
    //     component: IconsComponent
    //     }]
    // }, {
    //     path: '',
    //     children: [ {
    //         path: 'notifications',
    //         component: NotificationsComponent
    //     }]
    // }, {
    //     path: '',
    //     children: [ {
    //         path: 'maps',
    //         component: MapsComponent
    //     }]
    // }, {
    //     path: '',
    //     children: [ {
    //         path: 'typography',
    //         component: TypographyComponent
    //     }]
    // }, {
    //     path: '',
    //     children: [ {
    //         path: 'upgrade',
    //         component: UpgradeComponent
    //     }]
    // }
    { path: 'dashboard',            component: DashboardComponent },
    { path: 'user-profile',         component: UserProfileComponent },
    { path: 'user-list',            component: UserListComponent },
    { path: 'update-user/:id',      component: UserProfileComponent },
    { path: 'add-project',          component: ProjectDetailComponent },
    { path: 'project-list',         component: ProjectListComponent },
    { path: 'update-project/:id',   component: ProjectDetailComponent },
    { path: 'add-task',             component: TaskDetailComponent },
    { path: 'task-list',            component: TaskListComponent },
    { path: 'update-task/:id',      component: TaskDetailComponent },
    { path: 'add-subtask',          component: SubtaskDetailComponent },
    { path: 'subtask-list',         component: SubtaskListComponent },
    { path: 'edit-subtask/:id',     component: SubtaskDetailComponent },
    { path: 'table-list',           component: TableListComponent },
    { path: 'typography',           component: TypographyComponent },
    { path: 'icons',                component: IconsComponent },
    { path: 'maps',                 component: MapsComponent },
    { path: 'notifications',        component: NotificationsComponent },
    { path: 'upgrade',              component: UpgradeComponent },
];
