import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SideNavComponent } from './side-nav/side-nav.component';
import { RoutePanelComponent } from './route-panel/route-panel.component';

@NgModule({
  declarations: [SideNavComponent, RoutePanelComponent],
  imports: [CommonModule],
  exports: [SideNavComponent],
})
export class SharedModule {}
