import java.util.Scanner;

public class Main {

    public static  void mostrarCartasDosJogadoresDisponiveis(Jogador[] jogadores,int qtdJogadores){
        System.out.println("Jogadores restantes:");
        for (int i=0; i<qtdJogadores;i++){
            if(!jogadores[i].isAbandonouJogo()){

                System.out.print(jogadores[i].getNome()+" -> "+jogadores[i].getCartasAtuais()+"\n");
            }
        }

    }
   static int apostaTotal=0;
    public static void gerenciarApostas(Jogador[] jogadores,int qtdJogadores){
        int apostaJogadorAnterior = 0,apostaIndividual;
        String resposta;
        Scanner scanner = new Scanner(System.in);
        for (int i=0; i<qtdJogadores;i++){
            System.out.println(jogadores[i].getNome()+" Deseja apostar ou fugir?");
            resposta = scanner.next();

            if(resposta.equalsIgnoreCase("apostar") && jogadores[i].isAbandonouJogo()==false){
                if(apostaJogadorAnterior==0){
                    System.out.println(jogadores[i].getNome()+" qual o valor da sua aposta");
                    apostaIndividual = scanner.nextInt();
                    apostaTotal+=apostaIndividual;
                    apostaJogadorAnterior=apostaIndividual;
                }else{
                    System.out.println("O jogador "+jogadores[i-1].getNome()+" apostou "+apostaJogadorAnterior+" voce precisa cobrir ou apostar um valor maior, digite quanto vc deseja apostar:");
                    apostaIndividual = scanner.nextInt();
                    if(apostaIndividual == apostaJogadorAnterior){
                        System.out.println(jogadores[i].getNome()+" cobriu a aposta.");
                        apostaTotal+=apostaIndividual;
                        apostaJogadorAnterior=apostaIndividual;
                    } else if (apostaIndividual>apostaJogadorAnterior && jogadores[i-1].isAbandonouJogo()==false) {
                        int diferenca =apostaIndividual-apostaJogadorAnterior;
                        System.out.println(jogadores[i].getNome()+" cobriu a aposta e adicionou "+diferenca);
                        apostaJogadorAnterior=apostaIndividual;
                        System.out.println(jogadores[i-1].getNome()+" o jogador "+jogadores[i].getNome()+" cobriu sua aposta e aumentou em "+diferenca+"" +
                                "\n você pode adicionar "+diferenca+" ou fugir(responda com cobrir ou fugir)");
                        resposta = scanner.next();
                        if(resposta.equalsIgnoreCase("cobrir")){
                            apostaTotal+=(apostaIndividual-apostaJogadorAnterior);
                        } else if (resposta.equalsIgnoreCase("fugir")) {
                            System.out.println(jogadores[i].getNome()+" fugiu");
                            jogadores[i].setAbandonouJogo(true);
                            mostrarCartasDosJogadoresDisponiveis(jogadores,qtdJogadores);
                        }
                    }
                }
            } else if (resposta.equalsIgnoreCase("fugir")) {
                System.out.println(jogadores[i].getNome()+" fugiu");
                jogadores[i].setAbandonouJogo(true);
                mostrarCartasDosJogadoresDisponiveis(jogadores,qtdJogadores);
                apostaIndividual = 0;
                apostaJogadorAnterior=0;
            }
        }

        System.out.println("apostaTotal: "+apostaTotal);
    }

    public static void main(String[] args) {

        Baralho baralho = new Baralho();
        int totalJogadores = 0;
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Quantos jogadores?");
            totalJogadores = scanner.nextInt();
            if(totalJogadores<=0){
                throw new Exception("Numeros negativos nao permitidos");
            }
            Jogador[] vetorJogadores = new Jogador[totalJogadores];
            for (int i=0; i<totalJogadores;i++){
                vetorJogadores[i] = new Jogador(String.valueOf(i),i);
            }


        baralho.embaralha();

        System.out.println("Cartas de todos os jogadores:");
        for (int i=0; i<totalJogadores;i++){

            vetorJogadores[i].setCartasAtuais(baralho.darCartas());
            System.out.print(vetorJogadores[i].getNome()+" -> "+vetorJogadores[i].getCartasAtuais()+"\n");
        }
        System.out.println("=================");
        System.out.println("Hora das apostas:");
        System.out.println("=================");

        gerenciarApostas(vetorJogadores,totalJogadores);

        mostrarCartasDosJogadoresDisponiveis(vetorJogadores,totalJogadores);

        baralho.mostrarCincoCartas();
        String fim;
        System.out.println("Quem ganhou o jogo?");
        fim = scanner.next();
        System.out.println("O jogador "+ fim+" ganhou "+ apostaTotal);
        }catch (Exception e){
            System.out.println(e);
        }


    }
}