import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { FlightSearchComponent } from './components/flight-search/flight-search.component';
import { UserRagistrationComponent } from './components/user-ragistration/user-ragistration.component';
const routes: Routes = [{path:"", component: FlightSearchComponent},
 {path:"registeration" , component:UserRagistrationComponent}
 ];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
