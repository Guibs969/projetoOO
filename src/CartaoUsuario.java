public class CartaoUsuario {//4 Crud
    private String numeroCartao;
    private String validadeCartao;
    private int numeroSeguranca;
    private String nomeNoCartao;
    private String bandeiraCartao;
    private String identificadorCartao;

    public CartaoUsuario(String numeroCartao, String validadeCartao, int numeroSeguranca, String nomeNoCartao, String bandeiraCartao, String identificadorCartao) {
        this.numeroCartao = numeroCartao;
        this.validadeCartao = validadeCartao;
        this.numeroSeguranca = numeroSeguranca;
        this.nomeNoCartao = nomeNoCartao;
        this.bandeiraCartao = bandeiraCartao;
        this.identificadorCartao = identificadorCartao;
    }

    public void editarCartao(String numeroCartao, String validadeCartao, int numeroSeguranca, String nomeNoCartao, String bandeiraCartao, String identificadorCartao){
        this.numeroCartao = numeroCartao;
        this.validadeCartao = validadeCartao;
        this.numeroSeguranca = numeroSeguranca;
        this.nomeNoCartao = nomeNoCartao;
        this.bandeiraCartao = bandeiraCartao;
        this.identificadorCartao = identificadorCartao;
    }

    public void setNumeroCartao(String numeroCartao){
        this.numeroCartao = numeroCartao;
    }

    public void setValidadeCartao(String validadeCartao){
        this.validadeCartao = validadeCartao;
    }

    public void setNumeroSeguranca(int numeroSeguranca) {
        this.numeroSeguranca = numeroSeguranca;
    }

    public void setNomeNoCartao(String nomeNoCartao) {
        this.nomeNoCartao = nomeNoCartao;
    }

    public void setBandeiraCartao(String bandeiraCartao) {
        this.bandeiraCartao = bandeiraCartao;
    }

    public void setIdentificadorCartao(String identificadorCartao) {
        this.identificadorCartao = identificadorCartao;
    }

    public String toString() {
        return  "Numero do cartao: " +
                numeroCartao + "\n" +
                "Validade do cartao: " +
                validadeCartao + "\n" +
                "Numero de seguranca: " +
                numeroSeguranca + "\n" +
                "Nome no cartao: " +
                nomeNoCartao + "\n"+
                "Bandeira do cartao: " +
                bandeiraCartao + "\n" +
                "Identificar do cartao: " +
                identificadorCartao + "\n";
    }
}
