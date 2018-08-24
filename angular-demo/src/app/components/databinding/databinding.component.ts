import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-databinding',
  templateUrl: './databinding.component.html',
  styleUrls: ['./databinding.component.css']
})
export class DatabindingComponent implements OnInit {

  title = 'Data Binding';
  image = 'assets/images/databinding.png';
  documentation = 'https://angular.io/guide/architecture#data-binding';

  // For Interpolation
  interpolationNotation = '{{}}';
  interpolation = 'Welcome to the Interpolation.';


 ngOnInit() {

 }

}
