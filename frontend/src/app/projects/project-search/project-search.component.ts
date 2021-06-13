import {Component, OnDestroy, OnInit} from '@angular/core';
import {Store} from "@ngrx/store";
import * as fromApp from "../../store/app.reducer";
import {Category} from "../../model/category";
import {Subscription} from "rxjs";
import {Project} from "../../model/project.model";
import * as ProjectsActions from "../store/project.actions";
import {FormBuilder, FormGroup} from "@angular/forms";

@Component({
  selector: 'app-project-search',
  templateUrl: './project-search.component.html',
  styleUrls: ['./project-search.component.css']
})
export class ProjectSearchComponent implements OnInit, OnDestroy {
  raisedPercentValues: string[] = ['1', '1', '1', '1', '2', '1', '1', '1', '1', '2'];
  goalValues: string[] = ['1', '1', '1', '1', '2', '1', '1', '1', '1', '2'];
  sortValues: string[] = ['1', '1', '1', '1', '2', '1', '1', '1', '1', '2'];

  searchText = '';
  value = 'Clear me';

  categoryList: string[] = ['Design', 'Games', 'Technology', 'Comics', 'Fashion', 'Music', 'Apps'];

  searchForm: FormGroup;

  allCategories!: Category[];
  storeSubscription!: Subscription;

  searchedOptions!: Subscription;

  constructor(private store: Store<fromApp.AppState>,
              private fb: FormBuilder) {
    this.searchForm = this.fb.group({
      searchText: [''],
      categories: [null],
      raisedPercent: [null],
      sortBy: [null],
      goal: [null],
      isLikedProjects: [false]
    })
  }

  ngOnInit(): void {
    this.store.dispatch(new ProjectsActions.FetchAllCategories());
    this.storeSubscription = this.store.select('project').subscribe(projectsState => {
      this.allCategories = projectsState.categories;
    })

    this.searchedOptions = this.searchForm.valueChanges.subscribe(value1 => {
      console.log(value1)
    })
  }

  getFoundProjects(): Project[] {
    return this.allCategories.filter(value1 => value1.name === 'Design')
      .flatMap(value => value.projects);
  }

  submitSearchForm(): void {
    console.log(this.searchForm);
  }

  ngOnDestroy(): void {
    this.storeSubscription.unsubscribe();
  }

}
