import { Injectable, inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {
  Cliente,
  NovoCliente,
  NovoPedido,
  NovoProduto,
  Produto,
  ResultadoVenda,
} from './models';

const API = 'http://localhost:8080/api';

@Injectable({ providedIn: 'root' })
export class ApiService {
  private http = inject(HttpClient);

  listarClientes() {
    return this.http.get<Cliente[]>(`${API}/clientes`);
  }

  cadastrarCliente(cliente: NovoCliente) {
    return this.http.post<Cliente>(`${API}/clientes`, cliente);
  }

  excluirCliente(id: number) {
    return this.http.delete<void>(`${API}/clientes/${id}`);
  }

  listarProdutos() {
    return this.http.get<Produto[]>(`${API}/produtos`);
  }

  cadastrarProduto(produto: NovoProduto) {
    return this.http.post<Produto>(`${API}/produtos`, produto);
  }

  excluirProduto(codigo: string) {
    return this.http.delete<void>(`${API}/produtos/${codigo}`);
  }

  vender(pedido: NovoPedido) {
    return this.http.post<ResultadoVenda>(`${API}/pedidos`, pedido);
  }
}