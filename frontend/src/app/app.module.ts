import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {HttpClientModule} from '@angular/common/http';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {CommonModule} from "@angular/common";
import {HeaderComponent} from './header/header.component';
import {FooterComponent} from './footer/footer.component';
import {SharedComponent} from './shared/shared.component';
import {ProjectsComponent} from './projects/projects.component';
import {UserComponent} from './user/user.component';
import {BrowserModule} from "@angular/platform-browser";
import {AppRoutingModule} from "./app-routing.module";
import {AuthModule} from "./auth/auth.module";

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    SharedComponent,
    ProjectsComponent,
    UserComponent,
  ],
  imports: [
    HttpClientModule,
    AppRoutingModule,
    BrowserModule.withServerTransition({appId: 'serverApp'}),
    ReactiveFormsModule,
    AuthModule,
    FormsModule,
    CommonModule],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
