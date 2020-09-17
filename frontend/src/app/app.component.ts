import {Component, OnInit} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  helloMessage: string;

  constructor(private http: HttpClient) {
  }

  ngOnInit(): void {
    // this.http.get<string>('http://localhost:8081/hello', {
    //   headers: new HttpHeaders()
    //     .append('Authorization', 'Basic ' + btoa('plusqred:plusqred'))
    // })
    //   .subscribe(value => this.helloMessage = JSON.stringify(value));

    this.http.get<string>('http://localhost:8081/hello')
      .subscribe(value => this.helloMessage = JSON.stringify(value));
  }
}
