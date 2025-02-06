import { Component, OnInit } from '@angular/core';
import {BookService, Notification} from "../../../../api-client/generated-sources/library-api";

@Component({
  selector: 'app-notification-list',
  templateUrl: './notification-list.component.html',
  styleUrls: ['./notification-list.component.scss']
})
export class NotificationListComponent implements OnInit {
  notifications: Notification[] = [];

  constructor(private notificationsService: BookService) {}

  ngOnInit(): void {
    this.loadNotifications();
  }

  loadNotifications(): void {
    this.notificationsService.getAllNotifications().subscribe(
      (notifications) => (this.notifications = notifications),
      (error) => console.error('Error fetching notifications', error)
    );
  }

  public getStatus(notification: Notification): string{
    if(notification.status === true){
      return 'Book was borrowed';
    }
    else {
      return 'Book was returned';
    }
  }
}
