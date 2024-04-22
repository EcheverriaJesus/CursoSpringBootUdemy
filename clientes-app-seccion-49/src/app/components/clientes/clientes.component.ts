import { Component } from '@angular/core';
import { Cliente } from './cliente';

@Component({
  selector: 'app-clientes',
  standalone: true,
  imports: [],
  templateUrl: './clientes.component.html',
  styleUrl: './clientes.component.css'
})
export class ClientesComponent {
  clientes: Cliente[] = [
    { id: 1, name: 'Jesus', lastname: 'Echeverria', email: 'jesus@gmail.com', createAt: '2024-04-18' },
    { id: 2, name: 'Jesus1', lastname: 'Echeverria1', email: 'jesus@gmail.com', createAt: '2024-04-18' },
    { id: 3, name: 'Jesus2', lastname: 'Echeverria2', email: 'jesus@gmail.com', createAt: '2024-04-18' },
    { id: 4, name: 'Jesus3', lastname: 'Echeverria3', email: 'jesus@gmail.com', createAt: '2024-04-18' },
    { id: 5, name: 'Jesus4', lastname: 'Echeverria4', email: 'jesus@gmail.com', createAt: '2024-04-18' },
    { id: 6, name: 'Jesus5', lastname: 'Echeverria5', email: 'jesus@gmail.com', createAt: '2024-04-18' },
  ]
$cliente: any;
}
