
public class Cliente extends Pessoa{

    public Cliente(String nomecliente , String email,int idade){

        super(nomecliente , email , idade );
    }

    public void info(){

        System.out.println("Nome : "+nomecliente);

        System.out.println("email : "+ email);



    }

}

