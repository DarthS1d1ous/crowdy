import {Component, OnDestroy, OnInit} from '@angular/core';
import {Store} from "@ngrx/store";
import * as fromApp from "../../store/app.reducer";
import * as UserActions from "../store/user.actions";
import * as UserReducer from '../store/user.reducer';
import {ActivatedRoute, Params} from "@angular/router";
import {map, switchMap, tap} from "rxjs/operators";
import {UserProfile} from "../../model/dto/user-profile";
import {MatDialog} from "@angular/material/dialog";
import {FollowDialogComponent} from "../../shared/dialog/follow-dialog/follow-dialog.component";
import {User} from "../../model/user.model";
import {LoginDialogComponent} from "../../shared/dialog/login-dialog/login-dialog.component";


@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent implements OnInit, OnDestroy {
  FOLLOWING = 'followings';
  FOLLOWERS = 'followers';

  currentUser!: User;

  visitUserProfile!: UserProfile;
  currentUserProfile!: UserProfile;

  isVisitUserCurrentUser = false;

  constructor(private store: Store<fromApp.AppState>,
              private route: ActivatedRoute,
              private dialog: MatDialog) {
  }

  ngOnInit(): void {
    this.currentUser = JSON.parse(localStorage.getItem('userData')!)

    this.route.params.pipe(
      map((params: Params) => {
        return params['id'];
      }),
      tap(id => this.store.dispatch(new UserActions.FetchVisitUser(id))),
      switchMap(() => this.store.select('user')),
    ).subscribe((userState: UserReducer.State) => {
      this.visitUserProfile = userState.visitUser
      if (this.currentUser) {
        this.isVisitUserCurrentUser = this.currentUser.id === userState.visitUser?.id;
      }
    });

    this.store.dispatch(new UserActions.FetchCurrentUser(this.currentUser.id))

    this.store.select('user').subscribe(value => {
      console.log('***')
      console.log(value)
      this.currentUserProfile = value.currentUser;
    })
  }

  openFollowersDialog() {
    this.dialog.open(FollowDialogComponent, {
      closeOnNavigation: true,
      data: {
        visitUserProfile: this.visitUserProfile,
        type: this.FOLLOWERS
      }
    });
  }

  openFollowingDialog() {
    this.dialog.open(
      FollowDialogComponent, {
        closeOnNavigation: true,
        data: {
          visitUserProfile: this.visitUserProfile,
          type: this.FOLLOWING
        }
      });
  }

  isFollowerForCurrentUser(): boolean {
    return this.currentUser ?
      !!this.currentUserProfile?.following.find(value => value.id === this.visitUserProfile.id)
      : false;
  }

  onFollowButton() {
    if (this.currentUser) {
      this.store.dispatch(new UserActions.FollowUser({
        followerUserId: this.currentUser.id,
        followingUserId: this.visitUserProfile.id
      }))
      //TODO govno cod
      this.store.dispatch(new UserActions.UpdateProfileAfterFollow({
        followedUser: this.visitUserProfile,
        follow: true,
        visitIsCurrent: this.currentUser.id === this.visitUserProfile.id
      }))
      // console.log(this.isFollowerForCurrentUser(user));
    } else {
      this.dialog.open(LoginDialogComponent, {closeOnNavigation: true});
    }
  }

  onUnfollowButton() {
    this.store.dispatch(new UserActions.UnfollowUser({
      followerId: this.currentUser.id,
      followingId: this.visitUserProfile.id
    }));
    //TODO govno cod
    this.store.dispatch(new UserActions.UpdateProfileAfterFollow({
      followedUser: this.visitUserProfile,
      follow: false,
      visitIsCurrent: this.currentUser.id === this.visitUserProfile.id
    }))
  }

  ngOnDestroy(): void {
    this.dialog.closeAll();
  }
}


