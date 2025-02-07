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

import { LoginRequest } from '../model/models';
import { LoginResponse } from '../model/models';
import { RegisterRequest } from '../model/models';
import { RegisterResponse } from '../model/models';


import { Configuration }                                     from '../configuration';



export interface UserServiceInterface {
    defaultHeaders: HttpHeaders;
    configuration: Configuration;

    /**
     * 
     * 
     * @param loginRequest 
     */
    login(loginRequest?: LoginRequest, extraHttpRequestParams?: any): Observable<LoginResponse>;

    /**
     * 
     * 
     * @param registerRequest 
     */
    register(registerRequest?: RegisterRequest, extraHttpRequestParams?: any): Observable<RegisterResponse>;

}
