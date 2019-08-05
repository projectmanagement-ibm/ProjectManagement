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
import {ProjectDetailComponent} from '../../projects/project-detail/project-detail.component';
import {ProjectListComponent} from '../../projects/project-list/project-list.component';
import {TaskDetailComponent} from '../../tasks/task-detail/task-detail.component';
import {TaskListComponent} from '../../tasks/task-list/task-list.component';
import {SubtaskDetailComponent} from '../../subtasks/subtask-detail/subtask-detail.component';
import {SubtaskListComponent} from '../../subtasks/subtask-list/subtask-list.component';
import {LoginComponent} from '../../login/login.component';
import { AuthService } from '../../services/auth.service'
import { AuthGuard } from '../../auth.guard';

export const AdminLayoutRoutes: Routes = [
    // { path: 'login',                component: LoginComponent },
    { path: 'dashboard',            component: DashboardComponent , canActivate: [AuthGuard]},
    { path: 'user-profile',         component: UserProfileComponent, canActivate: [AuthGuard]},
    { path: 'user-list',            component: UserListComponent, canActivate: [AuthGuard] },
    { path: 'update-user/:id',      component: UserProfileComponent, canActivate: [AuthGuard] },
    { path: 'add-project',          component: ProjectDetailComponent, canActivate: [AuthGuard] },
    { path: 'project-list',         component: ProjectListComponent, canActivate: [AuthGuard] },
    { path: 'update-project/:id',   component: ProjectDetailComponent, canActivate: [AuthGuard] },
    { path: 'add-task/:projectId',  component: TaskDetailComponent, canActivate: [AuthGuard] },
    { path: 'task-list',            component: TaskListComponent, canActivate: [AuthGuard] },
    { path: 'projects/:id',         component: TaskListComponent, canActivate: [AuthGuard] },
    { path: 'update-task/:id',      component: TaskDetailComponent, canActivate: [AuthGuard] },
    { path: 'add-subtask',          component: SubtaskDetailComponent, canActivate: [AuthGuard] },
    { path: 'subtask-list',         component: SubtaskListComponent, canActivate: [AuthGuard] },
    { path: 'tasks/:id',            component: SubtaskListComponent, canActivate: [AuthGuard] },

    { path: 'edit-subtask/:id',     component: SubtaskDetailComponent, canActivate: [AuthGuard] }
    // { path: 'table-list',           component: TableListComponent },
    // { path: 'typography',           component: TypographyComponent },
    // { path: 'icons',                component: IconsComponent },
    // { path: 'maps',                 component: MapsComponent },
    // { path: 'notifications',        component: NotificationsComponent },
    // { path: 'upgrade',              component: UpgradeComponent },
];
