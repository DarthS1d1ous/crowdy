import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {HttpClientModule} from '@angular/common/http';
import {MaterialModule} from "./material/material.module";
import {HeaderComponent} from './components/header/header.component';
import {RouteModule} from "./route/route.module";
import {ProjectModule} from "./components/project/project.module";
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent
  ],
  imports: [
    HttpClientModule, ProjectModule, MaterialModule, RouteModule, NgbModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
