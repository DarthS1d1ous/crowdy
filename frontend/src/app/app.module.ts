import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {HttpClientModule} from '@angular/common/http';
import {MaterialModule} from "./material/material.module";
import {HeaderComponent} from './header/header.component';
import {SecurityModule} from "./security/security.module";

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent
  ],
  imports: [
    HttpClientModule, MaterialModule, SecurityModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
