import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-back-process',
  templateUrl: './back-process.component.html',
  styleUrls: ['./back-process.component.css']
})
export class BackProcessComponent implements OnInit {
  backForm: FormGroup;
  submitPerformed: boolean;

  constructor() {
  }

  ngOnInit(): void {
    this.backForm = new FormGroup({
      firstname: new FormControl('', Validators.required),
      lastname: new FormControl('', Validators.required),
      username: new FormControl('', Validators.required),
      email: new FormControl('', Validators.required),
      address: new FormControl('', Validators.required),
      address2: new FormControl('', Validators.required),
      saveInfo: new FormControl('', Validators.required),
      country: new FormControl('', Validators.required),
      city: new FormControl('', Validators.required),
      zip: new FormControl('', Validators.required),
      save: new FormControl('', Validators.required),
      paymentMethod: new FormControl('', Validators.required),
      ccName: new FormControl('', Validators.required),
      ccNumber: new FormControl('', Validators.required),
      ccExpiration: new FormControl('', Validators.required),
      ccCvv: new FormControl('', Validators.required)
    });
  }

  onSubmit() {
    this.submitPerformed = true;
  }
}
