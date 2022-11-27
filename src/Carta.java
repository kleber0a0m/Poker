public class Carta {
    private String nome;
    private String naipe;

    private boolean disponivel = true;

    public Carta(String nome, String naipe) {
        String nomeTemp,naipeTemp;

        switch(Integer.parseInt(nome)) {
            case 1:
                nomeTemp = "A";
                break;
            case 11:
                nomeTemp = "Q";
                break;
            case 12:
                nomeTemp = "J";
                break;
            case 13:
                nomeTemp = "K";
                break;
            default:
                nomeTemp = nome;
        }

        switch(Integer.parseInt(naipe)) {
            case 1:
                naipeTemp = "♦";
                break;
            case 2:
                naipeTemp = "♠";
                break;
            case 3:
                naipeTemp = "♥";
                break;
            case 4:
                naipeTemp = "♣";
                break;
            default:
                naipeTemp = "✖";
        }
        this.nome = nomeTemp;
        this.naipe = naipeTemp;
        this.disponivel = true;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNaipe() {
        return naipe;
    }

    public void setNaipe(String naipe) {
        this.naipe = naipe;
    }
}
