import {NgModule} from "@angular/core";
import {CommonModule} from "@angular/common";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {SharedModule} from "../shared/shared.module";
import {SwiperModule} from "swiper/angular";
import {UserComponent} from "./user.component";
import {UserRoutingModule} from "./user-routing.module";
import {UserProfileComponent} from "./user-profile/user-profile.component";

@NgModule({
  declarations: [
    UserComponent,
    UserProfileComponent
  ],
  imports: [
    CommonModule,
    UserRoutingModule,
    ReactiveFormsModule,
    SharedModule,
    FormsModule,
    SwiperModule
  ],
  exports: []
})
export class UserModule {

}
