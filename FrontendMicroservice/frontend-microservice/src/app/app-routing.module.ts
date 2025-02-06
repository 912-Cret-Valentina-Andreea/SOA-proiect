import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {RegisterComponent} from "./auth/register/register.component";
import {LoginComponent} from "./auth/login/login.component";
import {BookListComponent} from "./book/book-list/book-list.component";
import {NotificationListComponent} from "./book/notification-list/notification-list.component";
import {StatisticsListComponent} from "./book/statistics-list/statistics-list.component";

const routes: Routes = [
  { path: 'register', component: RegisterComponent },
  { path: 'login', component: LoginComponent },
  { path: 'books', component: BookListComponent },
  { path: 'notifications', component: NotificationListComponent },
  { path: 'statistics', component: StatisticsListComponent },
  { path: '', redirectTo: '/login', pathMatch: 'full' },
  { path: '**', redirectTo: '/login' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
