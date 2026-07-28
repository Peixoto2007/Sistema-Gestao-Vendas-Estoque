public abstract class Pessoa {
    protected String nome;
    private String cpf;
    protected String email;

    public Pessoa(String nome , String cpf , String email){
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
    };
}
