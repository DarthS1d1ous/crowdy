import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {MatSliderModule} from "@angular/material/slider";
import {MatGridListModule} from "@angular/material/grid-list";
import {MatButtonModule} from "@angular/material/button";
import {MatIconModule} from "@angular/material/icon";
import {MatToolbarModule} from "@angular/material/toolbar";
import {MatMenuModule} from "@angular/material/menu";
import {MatSidenavModule} from "@angular/material/sidenav";
import {MatCardModule} from "@angular/material/card";
import {MatTooltipModule} from '@angular/material/tooltip';
import {NgbPopoverModule} from "@ng-bootstrap/ng-bootstrap";

@NgModule({
  declarations: [],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    MatSliderModule,
    MatGridListModule,
    MatButtonModule,
    MatIconModule,
    MatToolbarModule,
    MatMenuModule,
    MatSidenavModule,
    MatCardModule,
    MatTooltipModule,
    NgbPopoverModule
  ],
  exports: [
    BrowserModule,
    BrowserAnimationsModule,
    MatSliderModule,
    MatGridListModule,
    MatButtonModule,
    MatIconModule,
    MatToolbarModule,
    MatMenuModule,
    MatSidenavModule,
    MatCardModule,
    MatTooltipModule,
    NgbPopoverModule
  ],
  providers: [],
  bootstrap: []
})
export class MaterialModule {
}
