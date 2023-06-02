import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { DemoPipe } from './demo.pipe';
import { TodoStatePipe } from './todo-state.pipe';

@NgModule({
  declarations: [
    AppComponent,
    DemoPipe,
    TodoStatePipe
  ],
  
  imports: [
    BrowserModule,
    FormsModule
  ],

  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
