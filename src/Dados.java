public class Dados {
    private Usuario usuario; // Manter apenas uma instância de Usuario

    private Match[] matches;
    private int nMatches = 0;

    public Dados() {
        matches = new Match[50];
    }

    public Match[] getMatches() {
        return matches;
    }

    public Match getMatch(int i) {
        return matches[i];
    }

    public String[] getNomeMatch() {
        String[] s = new String[nMatches];
        for (int i = 0; i < nMatches; i++) {
            s[i] = matches[i].getNomeMatch();
        }
        return s;
    }

    public void setMatch(Match[] matches) {
        this.matches = matches;
    }

    public void setMatches(int i, Match m) {
        matches[i] = m;
    }

    public int getnMatches() {
        return nMatches;
    }

    public void setnMatches(int nMatches) {
        this.nMatches = nMatches;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void preencherDados() {
        usuario = new Usuario("Usuario", 18, "Biografia", "Altura", "Numero do Usuario", "Sexo", 30, 18 , "Feminino/Masculino", "Viajar, escutar musica, andar de bicicleta");

        for (int i = 0; i < 10; i++) {
            String s = String.valueOf(i);

            matches[i] = new Match("Match".concat(s), 18 , "Biografia".concat(s),
                    "Altura do Match".concat(s), "Numero do Match".concat(s), "Sexo do Match".concat(s), "IdMatch".concat(s));
        }
        nMatches = 10;
    }

}
