
public class Produto {

    public String nomeproduto;

    public double quantidade;

    public Produto(String nomeproduto, double quantidade) {

        this.nomeproduto = nomeproduto;

        this.quantidade = quantidade;
    }

    public void info() {

        System.out.println("Nome do Produto: " + nomeproduto);

        System.out.println("Quantidade em Estoque: " + quantidade);
    }

}