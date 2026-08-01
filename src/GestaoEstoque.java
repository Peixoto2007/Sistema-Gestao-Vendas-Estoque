import java.util.ArrayList;

public class GestaoEstoque {
    ArrayList<Produto> produtos = new ArrayList<>();

    public void cadastrarprodutos(Produto produto){
        System.out.println("---- Novo Cliente para Cadastro ----");
        produtos.add(produto);
        System.out.println(produto.nomeproduto);}


    void infos (){
        System.out.println("--- Informações do Estoque ---");
        for (Produto p : produtos){

            p.info();

        };
    };



}


