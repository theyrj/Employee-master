import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { AdminComponent } from './admin.component';
import { ViewEmployeesComponent } from './view-employees/view-employees.component';

const routes: Routes = [
  { path: '', component: AdminComponent },
  { path: 'view', component: ViewEmployeesComponent }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AdminRoutingModule { }
