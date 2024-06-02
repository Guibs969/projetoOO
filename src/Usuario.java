import java.util.Scanner;
public class Usuario extends UsuarioBase{ //Primeiro Crud
    private boolean tipoAssinatura;

    private PreferenciaUsuario pU;
    private Assinatura aP;
    private int preferenciaIdade;
    private String preferenciaGenero;

    private String interessesPessoais;

    private int distanciaMaxima;
    private String likesUsuario;
    private CartaoUsuario cartaousuario;

    private boolean possuiCartao = false;

    Scanner scanner = new Scanner(System.in);

    public Usuario(String nomeUsuario, int idadeUsuario, String biografiaUsuario, String alturaUsuario, String numeroUsuario, String sexoUsuario, int distanciaMaxima, int preferenciaIdade, String preferenciaGenero, String interessesPessoais) {
        super(nomeUsuario, idadeUsuario, biografiaUsuario, alturaUsuario, numeroUsuario, sexoUsuario);
        this.aP = new Assinatura();
        this.pU = new PreferenciaUsuario(distanciaMaxima, preferenciaGenero, preferenciaIdade, interessesPessoais);

    }



    public void setDistanciaMaxima(int distanciaMaxima){
        this.pU.setDistanciaMaxima(distanciaMaxima);
    }
    public void setPreferenciaGenero(String preferenciaGenero){
        this.pU.setGeneroDeInteresse(preferenciaGenero);
    }
    public void setPreferenciaIdade(int preferenciaIdade){
        this.pU.setFaixaEtariaDeInteresse(preferenciaIdade);
    }
    public void setInteressesPessoais(String interessesPessoais){
        this.pU.setInteressesPessoais(interessesPessoais);
    }


    public boolean getPossuiCartao(){
        return possuiCartao;
    }

    public void setPossuiCartao(boolean possuiCartao){
        this.possuiCartao = possuiCartao;
    }
    public void deletarConta(){

    }

    public void cadastrarCartao() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Por favor, forneça os detalhes do cartão do usuário:");

        System.out.print("Número do Cartão: ");
        String numeroCartao = scanner.next();
        scanner.nextLine();

        System.out.print("Validade do Cartão: ");
        String validadeCartao = scanner.next();
        scanner.nextLine();

        int numeroSeguranca = 0; // Inicializando com um valor inválido

        boolean numeroSegurancaValido = false;
        while (!numeroSegurancaValido) {
            System.out.print("Número de Segurança: ");
            if (scanner.hasNextInt()) {
                numeroSeguranca = scanner.nextInt();
                scanner.nextLine();
                numeroSegurancaValido = true;
            } else {
                System.out.println("Digite um valor válido para o número de segurança.");
                scanner.nextLine(); // Limpar entrada inválida

            }
        }

        System.out.print("Nome no Cartão: ");
        String nomeNoCartao = scanner.next();
        scanner.nextLine();

        System.out.print("Bandeira do Cartão: ");
        String bandeiraCartao = scanner.next();
        scanner.nextLine();

        System.out.print("Identificador do Cartão: ");
        String identificadorCartao = scanner.next();
        scanner.nextLine();

        cartaousuario = new CartaoUsuario(numeroCartao, validadeCartao, numeroSeguranca, nomeNoCartao, bandeiraCartao, identificadorCartao);
    }



    public void solicitarCadastroCartao() {
        cadastrarCartao();
    }

    public void apagarCartao(){
        this.cartaousuario = null;
    }

    public void comprarAssinaturaPlatinumCartao(){
        if(getPossuiCartao()){
            aP.ativarRecursoPremiumPlatinum();

        } else{
            System.out.println("Você precisa ter um cartão cadastrado para pagar a assinatura!");
        }
    }

    public void comprarAssinaturaDiamondCartao(){
        if(getPossuiCartao()){
            aP.ativarRecursoPremiumDiamond();

        } else{
            System.out.println("Você precisa ter um cartão cadastrado para pagar a assinatura!");
        }
    }

    public void cancelarAssinatura(){
        if(!possuiAssinatura()){
            System.out.println("Não há assinatura para ser cancelada!");
        }else{
            if(aP.getAssinaturaPlatinumAtivada()) {
                aP.cancelarRecursoPremium();
                System.out.println("Assinatura Platinum cancelada!");
            }else{
                aP.cancelarRecursoPremium();
                System.out.println("Assinatura Diamond cancelada!");
            }
        }
    }



    public CartaoUsuario getCartao() {
        return cartaousuario;
    }

    public boolean possuiAssinatura(){
        return aP.getBooleanAssinaturaAtivada();
    }

    public String getNomeUsuario(){
        return nomeUsuario;
    }


    public void setDadosCartao(){

        Scanner scanner1 = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);
        int escolha1;
        String escolha2;
        System.out.println("Qual dos dados abaixo gostaria de editar?");
        System.out.println("1. Numero do cartao");
        System.out.println("2. Validade do cartao");
        System.out.println("3. Numero de seguranca");
        System.out.println("4. Nome no cartao");
        System.out.println("5. Bandeira do cartao");
        System.out.println("Sair");
        escolha1 = scanner1.nextInt();
        switch(escolha1){
            case 1:
                System.out.println("Digite o numero do cartao");
                escolha2 = scanner1.next();
                cartaousuario.setNumeroCartao(escolha2);
                break;
            case 2:
                System.out.println("Digite a validade do cartao");
                escolha2 = scanner1.next();
                cartaousuario.setValidadeCartao(escolha2);
                break;
            case 3:
                System.out.println("Digite o número de segurança do cartão:");
                if (scanner1.hasNextInt()) {
                    escolha1 = scanner1.nextInt();
                    cartaousuario.setNumeroSeguranca(escolha1);
                } else {
                    System.out.println("Digite um valor válido.");
                }
                break;


            case 4:
                System.out.println("Digite o nome no cartao");
                escolha2 = scanner1.next();
                cartaousuario.setNomeNoCartao(escolha2);
                break;
            case 5:
                System.out.println("Digite a bandeira do cartao");
                escolha2 = scanner1.next();
                cartaousuario.setBandeiraCartao(escolha2);
                break;

            case 6:
                System.out.println("Saindo...");
                break;
            default:
                System.out.println("Escolha invalida");
        }
    }


    public String getInformacoesUsuario() {
        return "Nome do Usuario: " + nomeUsuario + "\n" +
                "Tipo de Assinatura: " + aP.getAssinaturaAtivada() + "\n" +
                "Preferencia de Idade: " + pU.getFaixaEtariaDeInteresse() + "\n" +
                "Preferencia de Genero: " + pU.getGeneroDeInteresse() + "\n" +
                "Idade do Usuario: " + idadeUsuario + "\n" +
                "Biografia do Usuario: " + biografiaUsuario + "\n" +
                "Altura do Usuario: " + alturaUsuario + "\n" +
                "Numero do Usuario: " + numeroUsuario + "\n" +
                "Sexo do Usuario: " + sexoUsuario + "\n" +
                "Preferencia de distancia maxima: " + pU.getDistanciaMaxima() + "Km" + "\n" +
                "Interesses Pessoais: " + pU.getInteressesPessoais();
    }
}
