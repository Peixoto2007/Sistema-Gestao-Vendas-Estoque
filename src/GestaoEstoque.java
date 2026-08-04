import java.util.ArrayList;

public class GestaoEstoque {

    ArrayList<Produto> produtos = new ArrayList<>();

    public void cadastrarprodutos(Produto produto) {

        System.out.println("---- Novo Produto para Cadastro ----");

        produtos.add(produto);

        System.out.println(produto.nomeproduto);
    }

    public void venda(Pedido pedido) {

        for (Produto produto : produtos) {

            if (produto.nomeproduto.equalsIgnoreCase(pedido.nomeproduto)) {
                if (produto.quantidade >= pedido.quantidade) {
                    produto.quantidade -= pedido.quantidade;
                    System.out.println("Venda realizada!");

                    System.out.println("Quantidade restante: " + produto.quantidade);

                } else
                {System.out.println("Quantidade insuficiente no estoque!");}

                return;
            }
        }

        System.out.println("Produto não encontrado no estoque.");
    }

    public void infos() {

        System.out.println("--- Informações do Estoque ---");

        for (Produto p : produtos) {

            p.info();
        }
    }
}