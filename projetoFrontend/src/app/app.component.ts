import { Component, afterNextRender, inject, signal } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ApiService } from './api.service';
import { Cliente, Produto } from './models';

type Aba = 'clientes' | 'produtos' | 'pedido';

@Component({
  selector: 'app-root',
  imports: [FormsModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css',
})
export class App {

  private api = inject(ApiService);

  aba = signal<Aba>('clientes');
  clientes = signal<Cliente[]>([]);
  produtos = signal<Produto[]>([]);
  mensagem = signal<{ texto: string; erro: boolean } | null>(null);

  novoCliente = { nome: '', email: '', idade: null as number | null };
  novoProduto = { codigo: '', nome: '', quantidade: null as number | null };
  pedido = { cliente: '', produto: '', quantidade: null as number | null };

  constructor() {
    // Só roda no navegador (o servidor do SSR não chama a API Java)
    afterNextRender(() => this.carregarTudo());
  }

  trocarAba(aba: Aba) {
    this.aba.set(aba);
    this.mensagem.set(null);
  }

  carregarTudo() {
    this.carregarClientes();
    this.carregarProdutos();
  }

  carregarClientes() {
    this.api.listarClientes().subscribe({
      next: (lista) => this.clientes.set(lista),
      error: () => this.falha('Não foi possível carregar os clientes. A API Java está rodando em localhost:8080?'),
    });
  }

  carregarProdutos() {
    this.api.listarProdutos().subscribe({
      next: (lista) => this.produtos.set(lista),
      error: () => this.falha('Não foi possível carregar os produtos. A API Java está rodando em localhost:8080?'),
    });
  }

  cadastrarCliente() {
    const { nome, email, idade } = this.novoCliente;
    this.api.cadastrarCliente({ nome, email, idade: Number(idade) }).subscribe({
      next: () => {
        this.novoCliente = { nome: '', email: '', idade: null };
        this.ok('Cliente cadastrado.');
        this.carregarClientes();
      },
      error: () => this.falha('Não foi possível cadastrar o cliente. Esse e-mail já pode estar em uso.'),
    });
  }

  excluirCliente(cliente: Cliente) {
    if (!confirm(`Excluir o cliente ${cliente.nomecliente}?`)) return;
    this.api.excluirCliente(cliente.id).subscribe({
      next: () => {
        this.ok('Cliente excluído.');
        this.carregarClientes();
      },
      error: () => this.falha('Não foi possível excluir o cliente.'),
    });
  }

  cadastrarProduto() {
    const { codigo, nome, quantidade } = this.novoProduto;
    this.api.cadastrarProduto({ codigo, nome, quantidade: Number(quantidade) }).subscribe({
      next: () => {
        this.novoProduto = { codigo: '', nome: '', quantidade: null };
        this.ok('Produto cadastrado.');
        this.carregarProdutos();
      },
      error: () => this.falha('Não foi possível cadastrar o produto. Confira se o código ou o nome já existem.'),
    });
  }

  excluirProduto(produto: Produto) {
    if (!confirm(`Excluir o produto ${produto.nomeProduto}?`)) return;
    this.api.excluirProduto(produto.codigoProduto).subscribe({
      next: () => {
        this.ok('Produto excluído.');
        this.carregarProdutos();
      },
      error: () => this.falha('Não foi possível excluir o produto.'),
    });
  }

  fazerPedido() {
    const { cliente, produto, quantidade } = this.pedido;
    this.api.vender({ cliente, produto, quantidade: Number(quantidade) }).subscribe({
      next: (resultado) => {
        if (resultado.sucesso) {
          this.ok(resultado.mensagem);
          this.pedido.quantidade = null;
          this.carregarProdutos();
        } else {
          this.falha(resultado.mensagem);
        }
      },
      error: () => this.falha('Não foi possível registrar o pedido. A API Java está rodando?'),
    });
  }

  private ok(texto: string) {
    this.mensagem.set({ texto, erro: false });
  }

  private falha(texto: string) {
    this.mensagem.set({ texto, erro: true });
  }
}
