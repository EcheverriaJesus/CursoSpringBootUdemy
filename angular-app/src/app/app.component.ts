import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterOutlet } from '@angular/router';
import { ProductComponent } from './products/components/product.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule, RouterOutlet, ProductComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'Hola Jesus Noe';
  enabled: boolean = false;

  courses: String[] = ['Angular', 'React', 'Spring Boot'];

  setEnabled(): void{
    this.enabled = this.enabled? false : true;
  }
}
