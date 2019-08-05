import { Component, OnInit } from '@angular/core';
import {AuthService} from "../../services/auth.service";

declare const $: any;
declare interface RouteInfo {
    path: string;
    title: string;
    icon: string;
    class: string;
}
export const ROUTES: RouteInfo[] = [
    { path: '/dashboard', title: 'Dashboard',  icon: 'dashboard', class: '' },
    { path: '/user-list', title: 'Users', icon: 'person', class: ''},
    { path: '/project-list', title: 'Projects',  icon:'library_books', class: '' },
    { path: '/task-list', title: 'Tasks',  icon:'content_paste', class: '' },
    { path: '/subtask-list', title: 'Subtasks',  icon:'content_paste', class: '' },

    // { path: '/table-list', title: 'Table List',  icon:'content_paste', class: '' },
    // { path: '/typography', title: 'Typography',  icon:'library_books', class: '' },
    // { path: '/icons', title: 'Icons',  icon:'bubble_chart', class: '' },
    // { path: '/maps', title: 'Maps',  icon:'location_on', class: '' },
    // { path: '/notifications', title: 'Notifications',  icon:'notifications', class: '' },
    // { path: '/upgrade', title: 'Upgrade to PRO',  icon:'unarchive', class: 'active-pro' },
];

@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.css']
})
export class SidebarComponent implements OnInit {
  menuItems: any[];
  role: any;
  isAdmin: boolean;
  isManager: boolean;
  isTeamLeader: boolean;
  isDeveloper: boolean;

  constructor(
      private auth: AuthService
  ) {
  }

  ngOnInit() {

      console.log(' this.menuItems',  this.menuItems);
      this.menuItems = ROUTES.filter(menuItem => menuItem);

      this.role = this.auth.getRole();
      console.log('role at 46====', this.role);
      if ( this.role === 'admin') {
          this.isAdmin = true;
      } else if (this.role === 'manager') {
          this.isManager = true;
      } else if (this.role === 'team leader') {
          this.isTeamLeader = true;
      } else {
          this.isDeveloper = true;
      }
  }

  isMobileMenu() {
      if ($(window).width() > 991) {
          return false;
      }
      return true;
  };
}
