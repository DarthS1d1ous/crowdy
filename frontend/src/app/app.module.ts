import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {HttpClientModule} from '@angular/common/http';
import {MaterialModule} from "./material/material.module";
import {HeaderComponent} from './components/header/header.component';
import {RouteModule} from "./route/route.module";
import {ProjectModule} from "./components/project/project.module";
import {LoginComponent} from './components/login/login.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {RegisterComponent} from './components/register/register.component';
import {CommonModule} from "@angular/common";
import {UserModule} from "./components/user/user.module";
import {BackProcessComponent} from './components/back-process/back-process.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    LoginComponent,
    RegisterComponent,
    BackProcessComponent
  ],
  imports: [
    HttpClientModule, ProjectModule, MaterialModule, RouteModule, ReactiveFormsModule, FormsModule, CommonModule, UserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
