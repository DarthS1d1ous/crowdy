import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {map, switchMap, tap} from "rxjs/operators";
import {ActivatedRoute, Params} from "@angular/router";
import * as ProjectsActions from "../store/project.actions";
import {Store} from "@ngrx/store";
import * as fromApp from "../../store/app.reducer";
import {ProjectDetails} from "../../model/dto/project-details";

@Component({
  selector: 'app-project-payment',
  templateUrl: './project-payment.component.html',
  styleUrls: ['./project-payment.component.css']
})
export class ProjectPaymentComponent implements OnInit {
  paymentForm!: FormGroup;
  projectDetails!: ProjectDetails;
  submitPerformed!: boolean;

  constructor(private store: Store<fromApp.AppState>,
              private route: ActivatedRoute) {
  }

  ngOnInit(): void {
    this.paymentForm = new FormGroup({
      firstname: new FormControl('', Validators.required),
      lastname: new FormControl('', Validators.required),
      username: new FormControl('', Validators.required),
      email: new FormControl('', Validators.required),
      address: new FormControl('', Validators.required),
      address2: new FormControl('', Validators.required),
      country: new FormControl('', Validators.required),
      city: new FormControl('', Validators.required),
      zip: new FormControl('', Validators.required),
      saveInfo: new FormControl('', Validators.required),
      save: new FormControl('', Validators.required),
      paymentMethod: new FormControl('', Validators.required),
      ccName: new FormControl('', Validators.required),
      ccNumber: new FormControl('', Validators.required),
      ccExpiration: new FormControl('', Validators.required),
      ccCvv: new FormControl('', Validators.required),
      amount: new FormControl('', Validators.required)
    });

    this.route.params.pipe(
      map((params: Params) => {
        return params['id'];
      }),
      tap(id => {
        this.store.dispatch(new ProjectsActions.FetchProjectDetail(id))
        this.store.dispatch(new ProjectsActions.FetchProjectComments(id))
      }),
      switchMap(() => this.store.select('project')),
    ).subscribe(projectState => {
      this.projectDetails = projectState.projectDetails;
      console.log(this.projectDetails)
    });
  }

  onSubmitPaymentForm() {
    this.submitPerformed = true;
    console.log(this.paymentForm.controls)
  }
}
