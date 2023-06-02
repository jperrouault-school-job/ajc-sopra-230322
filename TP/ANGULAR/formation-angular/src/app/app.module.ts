import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { DemoPipe } from './demo.pipe';
import { TodoStatePipe } from './todo-state.pipe';
import { DemoComponent } from './demo/demo.component';
import { SostBoldComponent } from './sost-bold/sost-bold.component';
import { SostTextFieldComponent } from './sost-text-field/sost-text-field.component';

@NgModule({
  declarations: [
    AppComponent,
    DemoPipe,
    TodoStatePipe,
    DemoComponent,
    SostBoldComponent,
    SostTextFieldComponent
  ],
  
  imports: [
    BrowserModule,
    FormsModule
  ],

  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
