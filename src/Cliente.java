public class Cliente extends Pessoa{

    public Cliente(String nomecliente , String cpf , String email){

        super(nomecliente , cpf ,email);
    };

    public void info(){

        System.out.println("Nome : "+nomecliente);

        System.out.println("email : "+ email);



    };

}

