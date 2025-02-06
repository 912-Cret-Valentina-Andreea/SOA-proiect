export * from './book.service';
import { BookService } from './book.service';
export * from './book.serviceInterface';
export * from './user.service';
import { UserService } from './user.service';
export * from './user.serviceInterface';
export const APIS = [BookService, UserService];
