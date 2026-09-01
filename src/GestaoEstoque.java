import java.sql.SQLException;
import java.util.ArrayList;

public class GestaoEstoque {

    ArrayList<Produto> produtos = new ArrayList<>();

    private ProdutoDAO prodao = new ProdutoDAO();

    public void cadastrarprodutos(Produto produto) throws SQLException {

        System.out.println("---- Novo Produto para Cadastro ----");

        prodao.inserirproduto(produto);

        System.out.println("Adicionado ao Banco de dados");

        produtos.add(produto);

        System.out.println(produto.NomeProduto);
    }

    public void venda (Pedido pedido) {

        for (Produto produto : produtos) {

            if (produto.NomeProduto.equalsIgnoreCase(pedido.NomeProduto)) {
                if (produto.QuantidadeDisponivel >= pedido.QuantidadeDisponivel) {
                    produto.QuantidadeDisponivel -= pedido.QuantidadeDisponivel;
                    System.out.println("Venda realizada!");

                    System.out.println("Quantidade restante: " + produto.QuantidadeDisponivel);

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