package view;
import jcurses.system.CharColor;
import jcurses.widgets.*;

import helpers.LoopingLinkedList;
import model.Mes;

import java.util.ArrayList;

public class ImpressorDeMes {
    Mes mesParaImpressao;

    public ImpressorDeMes(Mes mesParaImpressao) {
        this.mesParaImpressao = mesParaImpressao;
    }

    public void imprimeVisaoMensal(ArrayList<String> datasComEvento){
        if (mesParaImpressao.getNome().equals("Fevereiro")){
            imprimeVisaoMensalFevereiro(datasComEvento);
        }
        System.out.println(mesParaImpressao.getNome() + " " + mesParaImpressao.getAno());

        String nomePriemiroDia = mesParaImpressao.getDia(1).getNomeDia();

        switch(nomePriemiroDia){
            case "Domingo":
                imprimePrimeiroDiaDomingo(datasComEvento);
                break;

            case "Segunda":
                imprimePrimeiroDiaSegunda(datasComEvento);
                break;

            case "Terça":
                imprimePrimeiroDiaTerca(datasComEvento);
                break;

            case "Quarta":
                imprimePrimeiroDiaQuarta(datasComEvento);
                break;

            case "Quinta":
                imprimePrimeiroDiaQuinta(datasComEvento);
                break;

            case "Sexta":
                imprimePrimeiroDiaSexta(datasComEvento);
                break;

            case "Sabado":
                imprimePrimeiroDiaSabado(datasComEvento);
                break;
        }
    }

    private void imprimePrimeiroDiaSabado(ArrayList<String> datasComEvento){
        String[][] calendario = new String[5][7];
        Integer calendarioCount = 1;
        System.out.println("D  S  T  Q  Q  S  S");
        calendario[0][0] = "          ";
        calendario[0][1] = "          ";
        calendario[0][2] = "          ";
        calendario[0][3] = "          ";
        int conta6dias = 0;
        boolean flag = true;

        for (int i = 0; i < 5 ; i++) {
            for (int j = 0; j < 7 ; j++) {
                if (calendarioCount > mesParaImpressao.getDias().size()){
                    calendarioCount = 1;
                }
                if (conta6dias <= 5){
                    conta6dias++;
                    continue;
                }if (flag){
                    StringBuilder aux = new StringBuilder();
                    aux.append("                  ");
                    aux.append("1  ");
                    calendarioCount = 2;
                    System.out.print(aux.toString());
                    flag = false;
                }
                if (i > 0){
                    calendario[i][j] = calendarioCount.toString();
                    if (calendario[i][j].length() > 1){
                        for (String data:datasComEvento
                             ) {
                            if (data.equals(calendario[i][j])){
                                System.out.print(calendario[i][j] + " ");

                            }
                        }
                    }else{
                        System.out.print(calendario[i][j] + "  ");
                    }
                    calendarioCount++;
                }
            }
            System.out.println();
        }
    }

    private void imprimePrimeiroDiaSexta(ArrayList<String> datasComEvento){
        String[][] calendario = new String[5][7];
        Integer calendarioCount = 1;
        System.out.println("D  S  T  Q  Q  S  S");
        calendario[0][0] = "          ";
        calendario[0][1] = "          ";
        calendario[0][2] = "          ";
        calendario[0][3] = "          ";
        int conta5dias = 0;
        boolean flag = true;

        for (int i = 0; i < 5 ; i++) {
            for (int j = 0; j < 7 ; j++) {
                if (calendarioCount > mesParaImpressao.getDias().size()){
                    calendarioCount = 1;
                }
                if (conta5dias <= 5){
                    conta5dias++;
                    continue;
                }if (flag){
                    StringBuilder aux = new StringBuilder();
                    aux.append("               ");
                    aux.append("1  2");
                    calendarioCount = 3;
                    System.out.print(aux.toString());
                    flag = false;
                }
                if (i > 0){
                    calendario[i][j] = calendarioCount.toString();
                    if (calendario[i][j].length() > 1){
                        System.out.print(calendario[i][j] + " ");
                    }else{
                        System.out.print(calendario[i][j] + "  ");
                    }
                    calendarioCount++;
                }
            }
            System.out.println();
        }
    }

    private void imprimePrimeiroDiaQuinta(ArrayList<String> datasComEvento){
        String[][] calendario = new String[5][7];
        Integer calendarioCount = 1;
        System.out.println("D  S  T  Q  Q  S  S");
        calendario[0][0] = "          ";
        calendario[0][1] = "          ";
        calendario[0][2] = "          ";
        calendario[0][3] = "          ";
        int conta3dias = 0;
        boolean flag = true;

        for (int i = 0; i < 5 ; i++) {
            for (int j = 0; j < 7 ; j++) {
                if (calendarioCount > mesParaImpressao.getDias().size()){
                    calendarioCount = 1;
                }
                if (conta3dias <= 3){
                    conta3dias++;
                    continue;
                }if (flag){
                    StringBuilder aux = new StringBuilder();
                    aux.append("            ");
                    aux.append("1  2  3");
                    calendarioCount = 4;
                    System.out.print(aux.toString());
                    flag = false;
                }
                if (i > 0){
                    calendario[i][j] = calendarioCount.toString();
                    if (calendario[i][j].length() > 1){
                        System.out.print(calendario[i][j] + " ");
                    }else{
                        System.out.print(calendario[i][j] + "  ");
                    }
                    calendarioCount++;
                }
            }
            System.out.println();
        }
    }

    private void imprimePrimeiroDiaQuarta(ArrayList<String> datasComEvento) {
        String[][] calendario = new String[5][7];
        Integer calendarioCount = 1;
        System.out.println("D  S  T  Q  Q  S  S");
        calendario[0][0] = "         ";
        calendario[0][1] = "         ";
        calendario[0][2] = "         ";
        int conta3dias = 0;
        boolean flag = true;

        for (int i = 0; i < 5 ; i++) {
            for (int j = 0; j < 7 ; j++) {
                if (calendarioCount > mesParaImpressao.getDias().size()){
                    calendarioCount = 1;
                }
                if (conta3dias <= 3){
                    conta3dias++;
                    continue;
                }if (flag){
                    StringBuilder aux = new StringBuilder();
                    aux.append("         ");
                    aux.append("1  2  3  4");
                    calendarioCount = 5;
                    System.out.print(aux.toString());
                    flag = false;
                }
                if (i > 0){
                    calendario[i][j] = calendarioCount.toString();
                    if (calendario[i][j].length() > 1){
                        System.out.print(calendario[i][j] + " ");
                    }else{
                        System.out.print(calendario[i][j] + "  ");
                    }
                    calendarioCount++;
                }
            }
            System.out.println();
        }
    }

    private void imprimePrimeiroDiaTerca(ArrayList<String> datasComEvento) {
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

    private void imprimePrimeiroDiaSegunda(ArrayList<String> datasComEvento) {
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

    private void imprimePrimeiroDiaDomingo(ArrayList<String> datasComEvento) {
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

    private void imprimeVisaoMensalFevereiro(ArrayList<String> datasComEvento) {
        System.out.println(mesParaImpressao.getNome() + " " + mesParaImpressao.getAno());
        System.out.println("D  S  T  Q  Q  S  S");
        String nomePriemiroDiaFevereiro = mesParaImpressao.getDia(1).getNomeDia();

    }
}
