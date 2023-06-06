import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class DemoService {
  constructor() { }

  public hello() {
    console.log("Hello world");
  }
}
