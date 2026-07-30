public abstract class Pessoa {
    protected String nomecliente;
    private String cpf;
    protected String email;

    public Pessoa(String nomecliente , String cpf , String email){
        this.nomecliente = nomecliente;
        this.cpf = cpf;
        this.email = email;
    };
}
