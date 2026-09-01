
public class Produto {

    public String NomeProduto;

    public String CodigoProduto;

    public double QuantidadeDisponivel;

    public Produto(String CodigoProduto,String NomeProduto, double QuantidadeDisponivel) {

        this.CodigoProduto= CodigoProduto;

        this.NomeProduto = NomeProduto;

        this.QuantidadeDisponivel = QuantidadeDisponivel;
    }

    public void info() {


        System.out.println("Codigo do Produto: " + CodigoProduto);

        System.out.println("Nome do Produto: " + NomeProduto);

        System.out.println("Quantidade em Estoque: " + QuantidadeDisponivel);
    }

}