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
import {
  AgmCoreModule
} from '@agm/core';
import { AdminLayoutComponent } from './layouts/admin-layout/admin-layout.component';
import {UsersService} from './services/users.service';
import {ProjectService} from './services/project.service';
import {TaskService} from './services/task.service';
import {SubtaskService} from './services/subtask.service';
import {LoginService} from './services/login.service';

import {LoginComponent} from './login/login.component';

import {
  MatButtonModule,
  MatInputModule,
  MatRippleModule,
  MatFormFieldModule,
  MatTooltipModule,
  MatSelectModule, MatNativeDateModule, MatDatepickerModule
} from '@angular/material';

import {AngularFireModule} from '@angular/fire';
import {environment} from '../environments/environment';
import {AngularFirestoreModule} from '@angular/fire/firestore';

import {AuthService} from './services/auth.service';
import {AuthGuard} from './auth.guard';
import { TestComponent } from './test/test.component';
import { MatCarouselModule } from '@ngmodule/material-carousel';


@NgModule({
  imports: [
    MatCarouselModule,
    MatButtonModule,
    MatRippleModule,
    MatFormFieldModule,
    MatInputModule,
    MatDatepickerModule,
    MatNativeDateModule,
    MatSelectModule,
    MatTooltipModule,
    BrowserAnimationsModule,
    FormsModule,
    ReactiveFormsModule,
    HttpModule,
    ComponentsModule,
    RouterModule,
    AppRoutingModule,

    AngularFireModule.initializeApp(environment.firebaseConfig),
    AngularFirestoreModule,
    AgmCoreModule.forRoot({
      apiKey: 'YOUR_GOOGLE_MAPS_API_KEY'
    }),


  ],
  declarations: [
    AppComponent,
    AdminLayoutComponent,
    LoginComponent,
    TestComponent,

  ],
  providers: [
      UsersService,
      ProjectService,
      TaskService,
      SubtaskService,
      LoginService,
    AuthService, AuthGuard
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
