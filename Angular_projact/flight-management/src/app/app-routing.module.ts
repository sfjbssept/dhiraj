import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { FlightSearchComponent } from './components/flight-search/flight-search.component';
import { UserRagistrationComponent } from './components/user-ragistration/user-ragistration.component';
import { LoginComponent } from './components/login/login.component';
const routes: Routes = [{path:"", component: FlightSearchComponent},
 {path:"registeration" , component:UserRagistrationComponent},
 {path:"login" , component:LoginComponent}
 ];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
