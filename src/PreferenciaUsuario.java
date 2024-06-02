public class PreferenciaUsuario {//3 Crud
    private int distanciaMaxima;
    private String generoDeInteresse;
    private int faixaEtariaDeInteresse;
    private String InteressesPessoais;

    public PreferenciaUsuario(int distanciaMaxima, String generoDeInteresse, int faixaEtariaDeInteresse, String interessesPessoais) {
        this.distanciaMaxima = distanciaMaxima;
        this.generoDeInteresse = generoDeInteresse;
        this.faixaEtariaDeInteresse = faixaEtariaDeInteresse;
        InteressesPessoais = interessesPessoais;
    }

    public int getDistanciaMaxima() {
        return distanciaMaxima;
    }

    public String getGeneroDeInteresse() {
        return generoDeInteresse;
    }

    public int getFaixaEtariaDeInteresse() {
        return faixaEtariaDeInteresse;
    }

    public String getInteressesPessoais() {
        return InteressesPessoais;
    }

    public void setDistanciaMaxima(int distanciaMaxima) {
        this.distanciaMaxima = distanciaMaxima;
    }

    public void setGeneroDeInteresse(String generoDeInteresse) {
        this.generoDeInteresse = generoDeInteresse;
    }

    public void setFaixaEtariaDeInteresse(int faixaEtariaDeInteresse) {
        this.faixaEtariaDeInteresse = faixaEtariaDeInteresse;
    }

    public void setInteressesPessoais(String interessesPessoais) {
        InteressesPessoais = interessesPessoais;
    }
}


