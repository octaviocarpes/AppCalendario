package view;

import helpers.LoopingLinkedList;
import model.Mes;

public class ImpressorDeMes {
    Mes mesParaImpressao;

    public ImpressorDeMes(Mes mesParaImpressao) {
        this.mesParaImpressao = mesParaImpressao;
    }

    public void imprimeVisaoMensal(){
        if (mesParaImpressao.getNome().equals("Fevereiro")){
            imprimeVisaoMensalFevereiro();
        }
        System.out.println(mesParaImpressao.getNome() + " " + mesParaImpressao.getAno());

        String nomePriemiroDia = mesParaImpressao.getDia(1).getNomeDia();

        switch(nomePriemiroDia){
            case "Domingo":
                imprimePrimeiroDiaTerca();
                break;

            case "Segunda":
                imprimePrimeiroDiaSegunda();
                break;

            case "Terça":
                imprimePrimeiroDiaTerca();
                break;

            case "Quarta":
                imprimePrimeiroDiaQuarta();
                break;

            case "Quinta":
                imprimePrimeiroDiaQuinta();
                break;

            case "Sexta":
                imprimePrimeiroDiaSexta();
                break;

            case "Sabado":
                imprimePrimeiroDiaSabado();
                break;
        }
    }

    private void imprimePrimeiroDiaSabado(){

    }

    private void imprimePrimeiroDiaSexta(){

    }

    private void imprimePrimeiroDiaQuinta(){

    }

    private void imprimePrimeiroDiaQuarta() {
        String[][] calendario = new String[5][7];

    }

    private void imprimePrimeiroDiaTerca() {
        System.out.println("D  S  T  Q  Q  S  S");
        Integer calendarioCount = 1;
        String[][] calendario = new String [5][7];
        int conta2dias = 1;
        boolean trigger = true;
        StringBuilder aux = new StringBuilder();
        calendario[0][0] = "     ";
        calendario[0][1] = "     ";
        for (int i = 0; i < 5 ; i++) {
            for (int j = 0; j < 7 ; j++) {
                if(calendarioCount > mesParaImpressao.getDias().size()){
                    calendarioCount = 1;
                }
                if (conta2dias <= 2){
                    conta2dias++;
                    continue;
                }
                if (trigger){
                    aux.append("      ");
                    aux.append("1  2  3  4  5");
                    calendarioCount = 6;
                    System.out.print(aux.toString());
                    trigger = false;
                }

                if (i > 0) {
                    calendario[i][j] = calendarioCount.toString();
                    if (calendario[i][j].length() > 1) {
                        System.out.print(calendario[i][j] + " ");
                    } else {
                        System.out.print(calendario[i][j] + "  ");
                    }
                    calendarioCount++;
                }
            }
            System.out.println();
        }
    }

    private void imprimePrimeiroDiaSegunda() {
        Integer calendarioCount = 1;
        String[][] calendario = new String[5][7];
        boolean trigger = false;

        for (int i = 0; i < 5 ; i++) {
            for (int j = 0; j < 7; j++) {
                if (calendarioCount > mesParaImpressao.getDias().size()){
                    calendarioCount = 1;
                }
                if(trigger == false){
                    trigger = true;
                    continue;
                }
                calendario[i][j] = calendarioCount.toString();
                calendarioCount++;
            }
        }

        System.out.println("D  S  T  Q  Q  S  S");
        StringBuilder res = new StringBuilder();
        res.append("  ");
        boolean executouApriemiraLinha = false;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 7; j++) {
                if (executouApriemiraLinha == false){
                    if(i != 0){
                        executouApriemiraLinha = true;
                    }
                    calendario[0][0] = res.toString();
                }
                if (calendario[i][j].length() > 1){
                    System.out.print(calendario[i][j] + " ");
                }else{
                    System.out.print(calendario[i][j] + "  ");
                }
            }
            System.out.println();
        }
    }

    private void imprimePrimeiroDiaDomingo() {
        Integer calendarioCount = 1;
        String[][] calendario = new String[5][7];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 7; j++) {
                if (calendarioCount > mesParaImpressao.getDias().size()){
                    calendarioCount = 1;
                }
                calendario[i][j] = calendarioCount.toString();
                calendarioCount++;
            }
        }

        System.out.println("D  S  T  Q  Q  S  S");
        for (int i = 0; i < 5 ; i++) {
            for (int j = 0; j < 7 ; j++) {
                if (calendario[i][j].length() > 1){
                    System.out.print(calendario[i][j] + " ");
                }else{
                System.out.print(calendario[i][j] + "  ");
                }
            }
            System.out.println();
        }
    }

    private void imprimeVisaoMensalFevereiro() {
        System.out.println(mesParaImpressao.getNome() + " " + mesParaImpressao.getAno());
        System.out.println("D  S  T  Q  Q  S  S");
        String nomePriemiroDiaFevereiro = mesParaImpressao.getDia(1).getNomeDia();

    }
}
