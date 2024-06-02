public class Match extends UsuarioBase {
    private String idMatch;


    private boolean matchAceito;

    public Match(String nomeUsuario, int idadeUsuario, String biografiaUsuario, String alturaUsuario, String numeroUsuario, String sexoUsuario, String idMatch) {
        super(nomeUsuario, idadeUsuario, biografiaUsuario, alturaUsuario, numeroUsuario, sexoUsuario);
        this.idMatch = idMatch;
    }


    public String lerDados() {
        return "Nome do Match: " +
                nomeUsuario + "\n" +
                "Idade do Match: " +
                idadeUsuario + "\n" +
                "Biografia do Match: " +
                biografiaUsuario + "\n" +
                "Altura do Match" +
                alturaUsuario + "\n" +
                "Numero do Match: " +
                numeroUsuario + "\n" +
                "Sexo do Match: " +
                sexoUsuario + "\n\n";
    }

    public void setMatchAceito(boolean matchAceito) {
        this.matchAceito = matchAceito;
    }

    public String getNomeMatch(){
        return nomeUsuario;
    }


    public boolean matchAceito() {
        return matchAceito;
    }

    public void cancelarMatch() {
        this.matchAceito = false;
    }

}