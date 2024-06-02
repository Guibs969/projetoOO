public abstract class UsuarioBase {

    protected String nomeUsuario;
    protected int idadeUsuario;
    protected String biografiaUsuario;
    protected String alturaUsuario;
    protected String numeroUsuario;
    protected String sexoUsuario;


    public UsuarioBase(String nomeUsuario, int idadeUsuario, String biografiaUsuario, String alturaUsuario, String numeroUsuario, String sexoUsuario) {
        this.nomeUsuario = nomeUsuario;
        this.idadeUsuario = idadeUsuario;
        this.biografiaUsuario = biografiaUsuario;
        this.alturaUsuario = alturaUsuario;
        this.numeroUsuario = numeroUsuario;
        this.sexoUsuario = sexoUsuario;
    }

    public void setIdadeUsuario(int idadeUsuario) {
        this.idadeUsuario = idadeUsuario;
    }

    public void setBiografiaUsuario(String biografiaUsuario) {
        this.biografiaUsuario = biografiaUsuario;
    }

    public void setAlturaUsuario(String alturaUsuario) {
        this.alturaUsuario = alturaUsuario;
    }

    public void setNumeroUsuario(String numeroUsuario) {
        this.numeroUsuario = numeroUsuario;
    }
}
