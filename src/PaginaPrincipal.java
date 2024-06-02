
import java.util.Scanner;

public class PaginaPrincipal {
    private Usuario u;
    private Match[] matches;

    private Match[] listaMatchesAceitos;
    private int numMatchesAceitos = 0;
    private static Dados dados;
    private int numMatches = 0; // Variável para controlar o próximo Match a ser exibido


    public static void limparTela() {
        System.out.print("\u001b[H\u001b[2J");
        System.out.flush();
    }

    public static void pausarAntesDeLimpar() {
        System.out.println("Pressione Enter para continuar...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        limparTela();
    }

    public PaginaPrincipal() {
        dados = new Dados();
        dados.preencherDados();
        matches = dados.getMatches();
        listaMatchesAceitos = new Match[10];
    }

    //*************************USUARIO**********************************//
    public void configuracoesUsuario() {
        Usuario usuario = dados.getUsuario();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Configurações de Usuário");
        System.out.println("1. Alterar idade");
        System.out.println("2. Alterar biografia");
        System.out.println("3. Alterar altura");
        System.out.println("4. Alterar número de telefone");
        System.out.println("5. Alterar preferência de idade");
        System.out.println("6. Alterar preferência de gênero");
        System.out.println("7. Alterar preferencia de distancia maxima");

        int escolha = 0;
        boolean escolhaValida = false;
        while(!escolhaValida) {
            if (scanner.hasNextInt()) {
                escolha = scanner.nextInt();
                scanner.nextLine();
                escolhaValida = true;
            } else {
                System.out.println("Escolha Invalida.");
                scanner.next();
                pausarAntesDeLimpar();
            }
        }
        switch (escolha) {
            case 1:
                System.out.print("Nova idade: ");
                int novaIdade = scanner.nextInt();
                usuario.setIdadeUsuario(novaIdade);
                break;
            case 2:
                System.out.print("Nova biografia: ");
                String novaBiografia = scanner.next();
                usuario.setBiografiaUsuario(novaBiografia);
                break;
            case 3:
                System.out.print("Nova altura: ");
                String novaAltura = scanner.next();
                usuario.setAlturaUsuario(novaAltura);
                break;
            case 4:
                System.out.print("Novo número de telefone: ");
                String novoNumero = scanner.next();
                usuario.setNumeroUsuario(novoNumero);
                break;
            case 5:

                int novaPreferenciaIdade = 0;
                boolean preferenciaIdadeValida = false;
                while (!preferenciaIdadeValida) {
                    System.out.print("Nova preferencia de Idade: ");
                    if (scanner.hasNextInt()) {
                        novaPreferenciaIdade = scanner.nextInt();
                        usuario.setPreferenciaIdade(novaPreferenciaIdade);
                        scanner.nextLine();
                        preferenciaIdadeValida = true;
                    } else {
                        System.out.println("Digite um valor válido para a preferencia de idade.");
                        scanner.next();

                    }

                }

                break;
            case 6:
                System.out.print("Nova preferência de gênero: ");
                String novaPreferenciaGenero = scanner.next();
                usuario.setPreferenciaGenero(novaPreferenciaGenero);
                break;
            case 7:

                int novaPreferenciaDeDistanciaMaxima = 0;
                boolean preferenciaDeDistanciaMaximaValida = false;
                while(!preferenciaDeDistanciaMaximaValida) {
                    System.out.print("Nova preferência de distancia maxima: ");
                    if(scanner.hasNextInt()) {
                        novaPreferenciaDeDistanciaMaxima = scanner.nextInt();
                        usuario.setDistanciaMaxima(novaPreferenciaDeDistanciaMaxima);
                        scanner.nextLine();
                        preferenciaDeDistanciaMaximaValida = true;
                    }else{
                        System.out.println("Digite um valor válido para a preferencia de idade.");
                        scanner.next();
                    }
                }
                break;
            case 8:
                System.out.print("Novos interesses pessoais: ");
                String novosInteressesPessoais = scanner.next();
                usuario.setInteressesPessoais(novosInteressesPessoais);
                break;
            default:
                System.out.println("Escolha inválida.");
                pausarAntesDeLimpar();
                break;
        }
        pausarAntesDeLimpar();
    }

    public void listarInformacoesUsuario(){ //Listagem
        Usuario u = dados.getUsuario();
        System.out.println(u.getInformacoesUsuario());
    }
    //*****************************************************************//


    //*************************MATCHES**********************************//
    public void menuMatches() {
        Scanner scanner = new Scanner(System.in);
        boolean sair = false;

        // Exibe o primeiro próximoMatch
        limparTela();
        proximoMatch();

        while (!sair) {
            System.out.println("Opções de Matches:");
            System.out.println("1. Próximo Match");
            System.out.println("2. Match Anterior");
            System.out.println("3. Dar Match");
            System.out.println("4. Cancelar um Match");

            System.out.println("5. Voltar");



            int escolha = 0;
            boolean escolhaValida = false;
            while(!escolhaValida) {
                if (scanner.hasNextInt()) {
                    escolha = scanner.nextInt();
                    scanner.nextLine();
                    escolhaValida = true;
                } else {
                    System.out.println("Escolha Invalida.");
                    scanner.next();
                    pausarAntesDeLimpar();
                    System.out.println("Opções de Matches:");
                    System.out.println("1. Próximo Match");
                    System.out.println("2. Match Anterior");
                    System.out.println("3. Dar Match");
                    System.out.println("4. Cancelar um Match");

                    System.out.println("5. Voltar");


                }
            }

            switch (escolha) {
                case 1:
                    limparTela();
                    proximoMatch();
                    break;
                case 2:
                    limparTela();
                    voltarMatchAnterior();
                    break;

                case 3:
                    limparTela();
                    darMatch();
                    pausarAntesDeLimpar();
                    break;

                case 4:
                    cancelarMatch();
                    pausarAntesDeLimpar();
                    break;

                case 5:
                    sair = true;
                    limparTela();
                    break;

                default:
                    System.out.println("Escolha inválida.");
            }
        }
    }

    public void proximoMatch() {
        Match[] listaMatches = dados.getMatches();
        int totalMatches = dados.getnMatches();

        if (totalMatches > 0) {
            if (numMatches < totalMatches) {
                Match proximoMatch = listaMatches[numMatches];

                System.out.println("Próximo Match:\n\n");
                System.out.println(proximoMatch.lerDados());
                numMatches++; // Atualiza o índice para o próximo Match

            } else {
                System.out.println("Você já visualizou todos os Matches disponíveis.");
            }
        } else {
            System.out.println("Nenhum Match disponível.");
        }
    }

    private void voltarMatchAnterior() {
        Usuario  u = dados.getUsuario();
        if(u.possuiAssinatura()){


            if (numMatches > 0) {
                // Atualiza o índice para o Match anterior
                numMatches--;
                Match matchAnterior = dados.getMatches()[numMatches -1];

                System.out.println("Voltando ao Match Anterior:\n\n");
                System.out.println(matchAnterior.lerDados());

            } else {
                System.out.println("Não há Match anterior disponível.");
            }
        }else{
            System.out.println("Essa função está disponível apenas para usuários com assinatura.");
        }
    }

    public void darMatch() {
        Match[] listaMatches = dados.getMatches();
        int totalMatches = dados.getnMatches();

        if (totalMatches > 0) {
            if (numMatches > 0 && numMatches <= totalMatches) {

                if(!listaMatches[numMatches - 1].matchAceito()) {
                    listaMatches[numMatches - 1].setMatchAceito(true);


                    listaMatchesAceitos[numMatchesAceitos] = listaMatches[numMatches - 1];
                    numMatchesAceitos++;

                    System.out.println("Você deu Match com o Match atual!");
                }else{
                    System.out.println("Você já deu match com esse usuario!");
                }
            } else {
                System.out.println("Não há Match disponível para dar Match.");
            }
        } else {
            System.out.println("Nenhum Match disponível para dar Match.");
        }
    }

    public void cancelarMatch() {
        if (numMatchesAceitos == 0) {
            System.out.println("Você não possui nenhum Match aceito para cancelar.");
        } else {
            System.out.println("Lista de Matches Aceitos:");
            for (int i = 0; i < numMatchesAceitos; i++) {
                System.out.println((i + 1) + ". " + listaMatchesAceitos[i].lerDados());
            }

            System.out.print("Selecione o número do Match a ser cancelado: ");
            Scanner scanner = new Scanner(System.in);
            int escolha = scanner.nextInt();

            if (escolha >= 1 && escolha <= numMatchesAceitos) {
                int index = escolha - 1;
                listaMatchesAceitos[index].cancelarMatch();
                // remove o match cancelado do array e movee os elementos restantes para preencher o espaçoçs
                for (int i = index; i < numMatchesAceitos - 1; i++) {
                    listaMatchesAceitos[i] = listaMatchesAceitos[i + 1];
                }
                listaMatchesAceitos[numMatchesAceitos - 1] = null;
                numMatchesAceitos--;
                System.out.println("Match cancelado com sucesso.");
            } else {
                System.out.println("Escolha inválida.");
            }
        }
    }

    public String listarMatches() {
        String saida = "***** Lista de Matches *****\n";

        for (int i = 0; i < dados.getnMatches(); i++) {
            saida = saida + "\n" + matches[i].lerDados();
        }

        return saida;
    }

    public String buscarMatchesAceitos() {
        Match[] listaMatches = dados.getMatches();
        StringBuilder resultado = new StringBuilder();
        Scanner scanner = new Scanner(System.in);

        if (numMatchesAceitos != 0) {
            System.out.println("Digite o nome do match que deseja buscar: ");
            String nomeABuscar = scanner.next();

            for (int i = 0; i < numMatchesAceitos; i++) {
                if (nomeABuscar.equalsIgnoreCase(listaMatchesAceitos[i].getNomeMatch())) {
                    resultado.append(listaMatchesAceitos[i].lerDados());
                }
            }

            if (resultado.length() > 0) {
                return resultado.toString();
            } else {
                System.out.println("Nenhum Match aceito encontrado com o nome informado.");
                return "";  // ou null, dependendo do que faz mais sentido para o seu programa
            }
        } else {
            System.out.println("Não existem Matches aceitos para buscar!");
            return "";  // ou null, dependendo do que faz mais sentido para o seu programa
        }
    }

    public String filtrarMatchesUsuario(){ // Filtro
        Match[] listamatches = dados.getMatches();
        StringBuilder resultado = new StringBuilder();

        for(int i = 0; i<10; i++){
            if (listamatches[i].matchAceito()){ //==true
                resultado.append(listamatches[i].lerDados());
                resultado.append("\n");
                limparTela();

            }
        }

        return resultado.toString();

    }
    //***********************************************************//



    //*************************CARTOES E ASSINATURA**********************************//
    public void menuCartoes(){
        Usuario u = dados.getUsuario();
        Scanner scanner = new Scanner(System.in);
        boolean sair = false;
        limparTela();

        while(!sair){
            System.out.println("Bem-vindo ao menu de Cartoes!");
            System.out.println("Opções:");
            System.out.println("1. Criar cartao");
            System.out.println("2. Deletar Cartao");
            System.out.println("3. Editar dados do Cartao");
            System.out.println("4. Listar dados do cartao");
            System.out.println("5. Sair");

            int escolha = 0;
            boolean escolhaValida = false;
            while(!escolhaValida) {
                if (scanner.hasNextInt()) {
                    escolha = scanner.nextInt();
                    scanner.nextLine();
                    escolhaValida = true;
                } else {
                    System.out.println("Escolha Invalida.");
                    scanner.next();
                    pausarAntesDeLimpar();
                }
            }
            switch(escolha){
                case 1:
                    limparTela();
                    criarCartao();
                    break;
                case 2:
                    apagarCartao();
                    break;
                case 3:
                    editarCartao();
                    System.out.println("Alteracao realizada com sucesso!");
                    break;
                case 4:
                    System.out.println(listarDadosCartao());
                    pausarAntesDeLimpar();
                    break;
                case 5:
                    sair = true;
                    System.out.println("Saindo do programa.");
                    break;
                default:
                    System.out.println("Escolha inválida.");
                    pausarAntesDeLimpar();
                    break;

            }
        }
    }

    public String listarDadosCartao(){
        Usuario u = dados.getUsuario();
        StringBuilder resultado = new StringBuilder();
        if(u.getPossuiCartao()){
            resultado.append(u.getCartao().toString());
            return resultado.toString();
        }else{
            return "Você ainda não possui um cartao!";
        }
    }

    public void criarCartao() {
        Usuario usuario = dados.getUsuario();
        if (!usuario.getPossuiCartao()) {
            usuario.solicitarCadastroCartao();
            CartaoUsuario cartaoDoUsuario = usuario.getCartao();
            usuario.setPossuiCartao(true);
            limparTela();
            System.out.println("Cartão criado com sucesso:");
            pausarAntesDeLimpar();

        }else {
            System.out.println("Você já tem um cartão cadastrado!");
            pausarAntesDeLimpar();
        }
    }

    public void apagarCartao() {
        Usuario usuario = dados.getUsuario();
        if(usuario.getPossuiCartao()) {
            usuario.apagarCartao();
            usuario.setPossuiCartao(false);
            System.out.println("Cartao apagado com sucesso!");
            pausarAntesDeLimpar();
        }else{
            limparTela();
            System.out.println("\nVocê não possui cartões para apagar!");
            pausarAntesDeLimpar();
        }
    }

    public void editarCartao(){
        Usuario u = dados.getUsuario();
        u.setDadosCartao();
        pausarAntesDeLimpar();


    }

    public void menuAssinatura(){
        Usuario u = dados.getUsuario();
        Assinatura assinatura = new Assinatura();
        Scanner scanner = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);
        boolean sair = false;
        limparTela();
        while(!sair){
            System.out.println("Bem-vindo ao menu de Assinaturas!");
            System.out.println("Opções:");
            System.out.println("1. Detalhar assinatura");
            System.out.println("2. Assinar   assinatura");
            System.out.println("3. Cancelar Assinatura");
            System.out.println("4. Sair");

            int escolha = scanner.nextInt();
            int escolha2;
            switch(escolha){
                case 1:
                    System.out.println("Qual assinatura gostaria de detalhar?\n1.Platinum\n2.Diamond");
                    escolha2 = scanner2.nextInt();
                    switch (escolha2) {
                        case 1:
                        System.out.println(assinatura.detalharAssinaturaPlatinum());
                        pausarAntesDeLimpar();
                        break;
                        case 2:
                        System.out.println(assinatura.detalharAssinaturaDiamond());
                        pausarAntesDeLimpar();
                        break;
                        default:
                            System.out.println("Escolha Invalida");
                            pausarAntesDeLimpar();
                            break;
                    }
                    break;
                case 2:
                    if(u.possuiAssinatura()){
                        System.out.println("Voce ja tem uma assinatura!");
                        pausarAntesDeLimpar();
                        break;
                    }else {
                        System.out.println("Qual assinatura gostaria de assinar?\n1.Platinum\n2.Diamond");
                        escolha2 = scanner2.nextInt();
                        switch (escolha2) {
                            case 1:
                                u.comprarAssinaturaPlatinumCartao();
                                pausarAntesDeLimpar();
                                break;
                            case 2:
                                u.comprarAssinaturaDiamondCartao();
                                pausarAntesDeLimpar();
                                break;
                            default:
                                System.out.println("Escolha inválida.");
                                pausarAntesDeLimpar();
                                break;
                        }
                        break;
                    }
                case 3:
                    if(u.possuiAssinatura()) {
                        u.cancelarAssinatura();
                        pausarAntesDeLimpar();
                        break;
                    }else{
                        System.out.println("Voce nao possui uma assinatura para ser cancelada!");
                        pausarAntesDeLimpar();
                        break;
                    }

                case 4:
                    sair = true;
                    System.out.println("Saindo do programa.");
                    limparTela();
                    break;
                default:
                    System.out.println("Escolha inválida.");
                    pausarAntesDeLimpar();
                    break;
            }
        }
    }

    //***********************************************************//

    public static void main(String[] args) {
        PaginaPrincipal pagina = new PaginaPrincipal();

        Scanner scanner = new Scanner(System.in);
        boolean sair = false;
        while (!sair) {
            limparTela();
            System.out.println("Bem-vindo ao seu perfil de usuário!");
            System.out.println("Opções:");
            System.out.println("1. Menu de Matches");
            System.out.println("2. Configurações de usuário");
            System.out.println("3. Menu de Cartoes");

            System.out.println("4. Menu de Assinaturas");
            System.out.println("5. Filtrar Matches Aceitos do Usuario");
            System.out.println("6. Listar Informacoes do Usuario");

            System.out.println("7. Buscar Matches Aceitos");
            System.out.println("8. Listar todos os Matches");

            System.out.println("9. Sair");

            int escolha = 0;
            boolean escolhaValida = false;
            while(!escolhaValida) {
                if (scanner.hasNextInt()) {
                    escolha = scanner.nextInt();
                    scanner.nextLine();
                    escolhaValida = true;
                } else {
                    System.out.println("Escolha Invalida.");
                    scanner.next();
                    pausarAntesDeLimpar();
                    System.out.println("Bem-vindo ao seu perfil de usuário!");
                    System.out.println("Opções:");
                    System.out.println("1. Menu de Matches");
                    System.out.println("2. Configurações de usuário");
                    System.out.println("3. Menu de Cartoes");

                    System.out.println("4. Menu de Assinaturas");
                    System.out.println("5. Filtrar Matches Aceitos do Usuario");
                    System.out.println("6. Listar Informacoes do Usuario");

                    System.out.println("7. Buscar Matches Aceitos");
                    System.out.println("8. Listar todos os Matches");

                    System.out.println("9. Sair");
                }
            }
            switch (escolha) {
                case 1:
                    limparTela();
                    pagina.menuMatches();
                    break;
                case 2:
                    pagina.configuracoesUsuario();
                    break;


                case 3:
                    pagina.menuCartoes();
                    break;


                case 4:
                    pagina.menuAssinatura();
                    break;

                case 5:
                    String matchesUsuario2 = pagina.filtrarMatchesUsuario();
                    System.out.println(matchesUsuario2);
                    pausarAntesDeLimpar();
                    break;

                case 6:
                    pagina.listarInformacoesUsuario();
                    pausarAntesDeLimpar();
                    break;

                case 7:
                    String resultadoBusca = pagina.buscarMatchesAceitos();
                    System.out.println(resultadoBusca);
                    pausarAntesDeLimpar();
                    break;

                case 8:
                    System.out.println(pagina.listarMatches());
                    pausarAntesDeLimpar();
                    break;

                case 9:
                    sair = true;
                    System.out.println("Saindo do programa.");
                    break;

                default:
                    System.out.println("Escolha inválida.");
            }
        }
    }
}
