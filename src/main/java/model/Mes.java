package model;

import helpers.LoopingLinkedList;

import java.util.ArrayList;

/**
 * Esta classe Representa os meses de um ano.
 * cada mês contém umaa lista de Dias, seu ano correspondente  e seu nome e.g: "Março".
 */
public class Mes {
    private String nome;
    private ArrayList<Dia> dias;

    private int ano;

    /**
     * No construtor são passados o nome do mês e o ano o qual pertençe.
     * @param nome
     * @param ano
     */
    public Mes(String nome,int ano) {
        this.nome = nome;
        dias = new ArrayList<>();
        this.ano = ano;
    }

    public String getNome() {
        return nome;
    }

    public int getAno() {
        return ano;
    }

    /**
     * Monta os dias dos meses utilizando a LoopingLinkedList
     */
    public void montaDatas(){
        int i = 1;
        switch (nome){

            /**
             * Cria laços dependendo de qual é o nome do mês.
             * por exemplo se for Fevereiro, o laço vai até 28.
             * Em cada iteração é criado um Dia e esse dia é adicionado na lista de dias.
             */
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


    /**
     * retorna um dia
     * @param data
     * @return
     */
    public Dia getDia(int data){
        return dias.get(data);
    }

    public ArrayList<Dia> getDias() {
        return dias;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Mes mes = (Mes) o;

        if (ano != mes.ano) return false;
        if (nome != null ? !nome.equals(mes.nome) : mes.nome != null) return false;
        return dias != null ? dias.equals(mes.dias) : mes.dias == null;
    }

    @Override
    public int hashCode() {
        int result = nome != null ? nome.hashCode() : 0;
        result = 31 * result + (dias != null ? dias.hashCode() : 0);
        result = 31 * result + ano;
        return result;
    }
}
