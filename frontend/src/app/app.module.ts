import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {HttpClientModule} from '@angular/common/http';
import {MaterialModule} from "./material/material.module";
import {HeaderComponent} from './components/header/header.component';
import {SecurityModule} from "./security/security.module";
import {ProjectModule} from "./project/project.module";
import {RouteModule} from "./route/route.module";

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent
  ],
  imports: [
    HttpClientModule, ProjectModule, MaterialModule, SecurityModule, RouteModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
