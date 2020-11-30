import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {mergeMap} from "rxjs/operators";
import {UserService} from "../../../services/user.service";
import {UserProfile} from "../../../models/user-profile";
import {AuthService} from "../../../services/auth.service";

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent implements OnInit {
  userProfile: UserProfile;

  constructor(private activatedRoute: ActivatedRoute, private userService: UserService, public authService: AuthService) {
  }

  ngOnInit(): void {
    this.activatedRoute.params.pipe(
      mergeMap(params => this.userService.getUserProfileById(params['id'])),
    ).subscribe(userProfile => {
      console.log(userProfile)
      this.userProfile = userProfile
    });
  }

}
