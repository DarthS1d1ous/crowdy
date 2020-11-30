import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {User} from "../models/user";
import {Observable} from "rxjs";
import {defaultIfEmpty, filter, map, mergeMap} from "rxjs/operators";
import {AuthService} from "./auth.service";
import {UserProfile} from "../models/user-profile";


@Injectable({providedIn: 'root'})
export class UserService {
  constructor(private http: HttpClient, private authService: AuthService) {
  }

  isCurrentUserFollowing(user: User): Observable<boolean> {
    return this.getFollowers(user).pipe(
      mergeMap(value => value),
      filter(u => u.id !== this.authService.getCurrentUser().id),
      map(u => true),
      defaultIfEmpty(false)
    );
  }

  private getFollowers(user: User): Observable<User[]> {
    return this.http.get<User[]>('http://localhost:8081/users/' + user.id + '/followers');
  }

  getUserProfileById(id: string) {
    return this.http.get<UserProfile>('http://localhost:8081/users/profiles/' + id)
  }
}
