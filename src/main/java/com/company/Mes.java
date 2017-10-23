package com.company;

import java.util.ArrayList;


public class Mes {
    private String nome;
    private ArrayList<Dia> dias;

    private int ano;

    public Mes(String nome,int ano) {
        this.nome = nome;
        dias = new ArrayList<>();

        this.ano = ano;
    }

    public void montaDatas(){
        int i = 1;
        switch (nome){

            case "Janeiro":
                if (i >= 28){i = 1;}
                while(i < 32) {
                    String diasDaSemana = LoopingLinkedList.getInstance().getNext().toString();
                    dias.add(new Dia(diasDaSemana, i));
                    i++;
                }
                break;

            case "Fevereiro":
                if (i >= 28){i = 1;}
                while(i < 29) {
                    String diasDaSemana = LoopingLinkedList.getInstance().getNext().toString();
                    dias.add(new Dia(diasDaSemana, i));
                    i++;
                }
                break;

            case "Março":
                if (i >= 28){i = 1;}
                while(i < 32) {
                    String diasDaSemana = LoopingLinkedList.getInstance().getNext().toString();
                    dias.add(new Dia(diasDaSemana, i));
                    i++;
                }
                break;

            case "Abril":
                if (i >= 28){i = 1;}
                while(i < 31) {
                    String diasDaSemana = LoopingLinkedList.getInstance().getNext().toString();
                    dias.add(new Dia(diasDaSemana, i));
                    i++;
                }
                break;

            case "Maio":
                if (i >= 28){i = 1;}
                while(i < 32) {
                    String diasDaSemana = LoopingLinkedList.getInstance().getNext().toString();
                    dias.add(new Dia(diasDaSemana, i));
                    i++;
                }
                break;

            case "Junho":
                if (i >= 28){i = 1;}
                while(i < 31) {
                    String diasDaSemana = LoopingLinkedList.getInstance().getNext().toString();
                    dias.add(new Dia(diasDaSemana, i));
                    i++;
                }
                break;

            case "Julho":
                if (i >= 28){i = 1;}
                while(i < 32) {
                    String diasDaSemana = LoopingLinkedList.getInstance().getNext().toString();
                    dias.add(new Dia(diasDaSemana, i));
                    i++;
                }
                break;

            case "Agosto":
                if (i >= 28){i = 1;}
                while(i < 32) {
                    String diasDaSemana = LoopingLinkedList.getInstance().getNext().toString();
                    dias.add(new Dia(diasDaSemana, i));
                    i++;
                }
                break;

            case "Setembro":
                if (i >= 28){i = 1;}
                while(i < 31) {
                    String diasDaSemana = LoopingLinkedList.getInstance().getNext().toString();
                    dias.add(new Dia(diasDaSemana, i));
                    i++;
                }
                break;

            case "Outubro":
                if (i >= 28){i = 1;}
                while(i < 32) {
                    String diasDaSemana = LoopingLinkedList.getInstance().getNext().toString();
                    dias.add(new Dia(diasDaSemana, i));
                    i++;
                }
                break;

            case "Novembro":
                if (i >= 28){i = 1;}
                while(i < 31) {
                    String diasDaSemana = LoopingLinkedList.getInstance().getNext().toString();
                    dias.add(new Dia(diasDaSemana, i));
                    i++;
                }
                break;

            case "Dezembro":
                if (i >= 28){i = 1;}
                while(i < 32) {
                    String diasDaSemana = LoopingLinkedList.getInstance().getNext().toString();
                    dias.add(new Dia(diasDaSemana, i));
                    i++;
                }
                break;
        }
    }

    public Dia getDia(int data){
        return dias.get(data);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(nome);
        res.append("\n");
        for (int i = 0; i < dias.size() ; i++) {
            res.append("**********************************************\n");
            res.append("* " + dias.get(i).getNomeDia() + "                      \n");
            res.append("* " + dias.get(i).getData() + "/" + nome + "/" + ano + "\n");
            res.append("* " + dias.get(i).getEventos().toString() + "                                            \n");
            res.append("*                                             \n");
            res.append("*                                             \n");
            res.append("*                                             \n");
            res.append("*                                             \n");
            res.append("*                                             \n");
            res.append("**********************************************\n");
            res.append("\n");
        }
        return res.toString();
    }
}
