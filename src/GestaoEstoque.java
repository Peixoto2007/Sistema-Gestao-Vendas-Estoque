import java.util.ArrayList;

public class GestaoEstoque {
    ArrayList<Produto> produtos = new ArrayList<>();

    void infos (){

        for (Produto p : produtos){

            p.info();

        };
    };



}


