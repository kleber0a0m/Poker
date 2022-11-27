import java.util.Arrays;
import java.util.Collections;

public class Baralho {
    Carta[] baralho = new Carta[52];

    public void imprimeBaralho(){

        for(int j = 0;j < 52;j++){ //naipe
            if(baralho[j].isDisponivel()){
                System.out.println(baralho[j].getNome()+baralho[j].getNaipe());
            }
        }
    }

    public void embaralha(){
        Collections.shuffle(Arrays.asList(baralho));

    }

    public String darCartas(){

        int totalCartasInicial = 2;

        for(int j = 51;j >= 0;j--){ //naipe
            if(baralho[j].isDisponivel()){
                baralho[j].setDisponivel(false);
                baralho[j-1].setDisponivel(false);
                return baralho[j].getNome()+baralho[j].getNaipe() + "-" + baralho[j-1].getNome()+baralho[j-1].getNaipe();
            }
        }

        System.out.println();
        if(totalCartasInicial == 2){
            return "O baralho está sem cartas";
        }
        return"";

    }

    public String mostrarCincoCartas(){

        for(int j = 51;j >= 0;j--){ //naipe
            if(baralho[j].isDisponivel()){
                baralho[j].setDisponivel(false);
                baralho[j-1].setDisponivel(false);
                baralho[j-2].setDisponivel(false);
                baralho[j-3].setDisponivel(false);
                baralho[j-4].setDisponivel(false);
                System.out.println(baralho[j].getNome()+baralho[j].getNaipe() + "\n"
                        + baralho[j-1].getNome()+baralho[j-1].getNaipe() + "\n"
                        + baralho[j-2].getNome()+baralho[j-2].getNaipe() + "\n"
                        + baralho[j-3].getNome()+baralho[j-3].getNaipe() + "\n"
                        + baralho[j-4].getNome()+baralho[j-4].getNaipe() + "\n")
                ;
            }
            return"";
        }

        return"";

    }


    public void temCarta(){
        int contador = 0;
        for(int j = 51;j >= 0;j--){ //naipe
            if(!baralho[j].isDisponivel()){
                contador++;
            }
        }
        if(contador==51){
            System.out.println("Não tem cartas disponiveis");
        }else{
            System.out.println("Ainda existem cartas disponiveis");
        }
    }

    public Baralho() {//Baralho novo

        int posicao =0;
        for (int i = 1;i <= 13;i++){//nome

            for(int j = 1;j <= 4;j++){ //naipe
                baralho[posicao] = new Carta(String.valueOf(i),String.valueOf(j));
                posicao++;
            }

        }
    }

    public Baralho(Carta carta1, Carta carta2) {//Baralho com 2 cartas
        baralho[0].setNome(carta1.getNome());
        baralho[0].setNaipe(carta1.getNaipe());

        baralho[1].setNome(carta2.getNome());
        baralho[1].setNaipe(carta2.getNaipe());
    }
}
