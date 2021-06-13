import {Component, OnInit, ViewEncapsulation} from '@angular/core';

@Component({
  selector: 'app-project-create',
  templateUrl: './project-create.component.html',
  styleUrls: ['./project-create.component.css'],
  encapsulation: ViewEncapsulation.None
})
export class ProjectCreateComponent implements OnInit {

  url = '';

  projectDescription = '123';


  constructor() {
  }

  ngOnInit(): void {

  }

  // hidePreview() { console.log(e.getContent()); }

  onSelectFile(event: any): void {
    if (event.target.files && event.target.files[0]) {
      var reader = new FileReader();

      reader.readAsDataURL(event.target.files[0]); // read file as data url

      reader.onload = (event) => { // called once readAsDataURL is completed
        // @ts-ignore
        this.url = event.target.result;
      }
    }
  }

}
