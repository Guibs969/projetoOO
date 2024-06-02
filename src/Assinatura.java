public class Assinatura { //Segundo Crud


    private String descricaoAssinaturaPlatinum = "Assinatura Platinum:\n Preco: R$29,90 P/Mes \n ";

    private String descricaoAssinaturaDiamond = "Assinatura Diamond:\n Preco: R$49,90 P/Mes \n";

    private boolean assinaturaPlatinumAtivada;

    private boolean assinaturaDiamondAtivada;

    private boolean assinaturaAtivada;

    public Assinatura() {

        this.assinaturaAtivada = false;
    }


    public String detalharAssinaturaPlatinum(){
        return descricaoAssinaturaPlatinum;
    }
    public String detalharAssinaturaDiamond(){
        return descricaoAssinaturaDiamond;
    }
    public void ativarRecursoPremiumPlatinum(){

        this.assinaturaAtivada = true;
        this.assinaturaPlatinumAtivada = true;
        this.assinaturaDiamondAtivada = false;
        System.out.println("Assinatura Platinum paga e ativada com sucesso!");
    }

    public void ativarRecursoPremiumDiamond(){

        this.assinaturaAtivada = true;
        this.assinaturaDiamondAtivada = true;
        this.assinaturaPlatinumAtivada = false;
        System.out.println("Assinatura Diamond paga e ativada com sucesso!");
    }

    public void cancelarRecursoPremium(){

        this.assinaturaAtivada = false;
        this.assinaturaDiamondAtivada = false;
        this.assinaturaPlatinumAtivada = false;

    }

    public String getAssinaturaAtivada(){//Usado no toString
        if(assinaturaPlatinumAtivada)
        return "Tem assinatura platinum ativada.";
        else if(assinaturaDiamondAtivada){
        return "Tem assinatura diamond ativada.";
        }
        else{
            return "Não tem assinatura";
        }

    }
    public boolean getBooleanAssinaturaAtivada(){
        return assinaturaAtivada;
    }

    public boolean getAssinaturaPlatinumAtivada() {
        return assinaturaPlatinumAtivada;
    }

    public boolean getAssinaturaDiamondAtivada() {
        return assinaturaDiamondAtivada;
    }
}

