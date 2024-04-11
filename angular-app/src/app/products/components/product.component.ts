import { Component, OnInit } from '@angular/core';
import { ProductService } from '../services/product.service';
import { Product } from '../models/products';
import { FormComponent } from './form/form.component';

@Component({
  selector: 'app-product',
  standalone: true,
  imports: [FormComponent],
  templateUrl: './product.component.html',
  styleUrl: './product.component.css'
})
export class ProductComponent implements OnInit {
  products: Product[] = [];

  productSelected: Product = new Product;

  constructor(private service: ProductService) {
  }
  ngOnInit(): void {
    this.service.findAll().subscribe(products => this.products = products)
  }

  addProduct(product: Product): void {
    if (product.id > 0) {
      this.service.update(product).subscribe(productUpdated => {

        this.products = this.products.map(prod => {
          if (prod.id == product.id) {
            return { ...productUpdated };
          }
          return prod;
        })

      })

    } else {
      this.service.create(product).subscribe(productNew => {
        /* product.id = new Date().getTime();
        this.products.push(productNew); */
        this.products = [... this.products, { ...productNew }]
      });

    }
    this.productSelected = new Product();

  }

  onRemoveProduct(id: number): void {
    this.service.remove(id).subscribe(() => {
      this.products = this.products.filter(product => product.id != id);
    })

  }

  onUpdateProduct(productRow: Product): void {
    this.productSelected = { ... productRow };
  }

}
