import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { StudentComponent } from './student/student.component';

const routes: Routes = [{
  path: 'students',
  component: StudentComponent
},
{
  path: 'create',
  component: StudentComponent
}, {
  path: 'student',
  component: StudentComponent
}];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
