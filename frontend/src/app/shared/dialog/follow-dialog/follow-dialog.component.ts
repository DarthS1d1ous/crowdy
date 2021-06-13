import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialog} from "@angular/material/dialog";
import {User} from "../../../model/user.model";
import {LoginDialogComponent} from "../login-dialog/login-dialog.component";
import {UserProfile} from "../../../model/dto/user-profile";
import * as UserActions from "../../../user/store/user.actions";
import {Store} from "@ngrx/store";
import * as fromApp from "../../../store/app.reducer";

@Component({
  selector: 'app-follow-dialog',
  templateUrl: './follow-dialog.component.html',
  styleUrls: ['./follow-dialog.component.css']
})
export class FollowDialogComponent implements OnInit {
  FOLLOWING = 'followings';
  FOLLOWERS = 'followers';

  currentUser!: User;
  currentUserProfile!: UserProfile;

  constructor(@Inject(MAT_DIALOG_DATA) public data: {
                visitUserProfile: UserProfile,
                type: string
              },
              public dialog: MatDialog,
              private store: Store<fromApp.AppState>) {
  }

  ngOnInit(): void {
    this.currentUser = JSON.parse(localStorage.getItem('userData')!);
    this.store.select('user').subscribe(value => {
      this.currentUserProfile = value.currentUser;
    })
  }

  onFollowButton(user: User) {
    if (this.currentUser) {
      this.store.dispatch(new UserActions.FollowUser({
        followerUserId: this.currentUser.id,
        followingUserId: user.id
      }))
      //TODO govno cod
      this.store.dispatch(new UserActions.UpdateProfileAfterFollow({
        followedUser: user,
        follow: true,
        visitIsCurrent: this.currentUser.id === this.data.visitUserProfile.id
      }))
    } else {
      this.dialog.open(LoginDialogComponent);
    }
  }

  onUnfollowButton(user: User) {
    this.store.dispatch(new UserActions.UnfollowUser({
      followerId: this.currentUser.id,
      followingId: user.id
    }));
    //TODO govno cod
    this.store.dispatch(new UserActions.UpdateProfileAfterFollow({
      followedUser: user,
      follow: false,
      visitIsCurrent: this.currentUser.id === this.data.visitUserProfile.id
    }))
  }

  isFollowerForCurrentUser(user: User): boolean {
    // console.log(!!this.data.currentUserProfile.following.find(value => value.id === user.id));
    return this.currentUser ?
      !!this.currentUserProfile.following.find(value => value.id === user.id)
      : false;
  }

  isNotCurrentUser(user: User): boolean {
    return this.currentUser ? this.currentUser.id != user.id : true;
  }

}
