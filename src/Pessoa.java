public abstract class Pessoa {

    public String nomecliente;

    protected int idade;

    protected String email;


    public Pessoa(String nomecliente , String email,int idade){

        this.nomecliente = nomecliente;

        this.idade = idade;

        this.email = email;
    }

}
