import java.util.Scanner;

public class Jogador {
    private String nome;
    private String cartasAtuais;
    private int apostaAtual;

    private boolean abandonouJogo;

    public boolean isAbandonouJogo() {
        return abandonouJogo;
    }

    public void setAbandonouJogo(boolean abandonouJogo) {
        this.abandonouJogo = abandonouJogo;
    }

    public Jogador(String nome, int numero) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o nome do jogador "+numero);
        String nomeFinal = "["+String.valueOf(numero)+"]" + scanner.nextLine();
        this.nome = nomeFinal;
    }

    public String getCartasAtuais() {
        return cartasAtuais;
    }

    public void setCartasAtuais(String cartasAtuais) {
        this.cartasAtuais = cartasAtuais;
    }

    public int getApostaAtual() {
        return apostaAtual;
    }

    public void setApostaAtual(int apostaAtual) {
        this.apostaAtual = apostaAtual;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void jogadoresDisponiveis(){
        System.out.println();
    }


}
