export interface Cliente {
  id: number;
  nomecliente: string;
  email: string;
  idade: number;

}

export interface Produto {
  codigoProduto: string;
  nomeProduto: string;
  quantidadeDisponivel: number;
}

export interface NovoCliente {
  nome: string;
  email: string;
  idade: number;
}

export interface NovoProduto {
  codigo: string;
  nome: string;
  quantidade: number;
}

export interface NovoPedido {
  cliente: string;
  produto: string;
  quantidade: number;
}

export interface ResultadoVenda {
  sucesso: boolean;
  mensagem: string;
}
