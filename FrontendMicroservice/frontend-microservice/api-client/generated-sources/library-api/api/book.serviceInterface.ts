/**
 * Shop API
 * No description provided (generated by Openapi Generator https://github.com/openapitools/openapi-generator)
 *
 * The version of the OpenAPI document: 1.0.0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
import { HttpHeaders }                                       from '@angular/common/http';

import { Observable }                                        from 'rxjs';

import { Book } from '../model/models';
import { Notification } from '../model/models';
import { Statistics } from '../model/models';


import { Configuration }                                     from '../configuration';



export interface BookServiceInterface {
    defaultHeaders: HttpHeaders;
    configuration: Configuration;

    /**
     * 
     * 
     * @param name 
     */
    borrowBook(name: string, extraHttpRequestParams?: any): Observable<{}>;

    /**
     * 
     * 
     */
    getAllBooks(extraHttpRequestParams?: any): Observable<Array<Book>>;

    /**
     * 
     * 
     */
    getAllNotifications(extraHttpRequestParams?: any): Observable<Array<Notification>>;

    /**
     * 
     * 
     */
    getAllStatistics(extraHttpRequestParams?: any): Observable<Array<Statistics>>;

    /**
     * 
     * 
     * @param name 
     */
    returnBook(name: string, extraHttpRequestParams?: any): Observable<{}>;

}
