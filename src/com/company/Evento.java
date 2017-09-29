package com.company;

public class Evento {
    private String nomeDoEvento;
    private String dataDoEvento;

    public Evento(String nomeDoEvento, String dataDoEvento) {
        this.nomeDoEvento = nomeDoEvento;
        this.dataDoEvento = dataDoEvento;
    }

    public String getNomeDoEvento() {
        return nomeDoEvento;
    }

    public void setNomeDoEvento(String nomeDoEvento) {
        this.nomeDoEvento = nomeDoEvento;
    }

    public String getDataDoEvento() {
        return dataDoEvento;
    }

    public void setDataDoEvento(String dataDoEvento) {
        this.dataDoEvento = dataDoEvento;
    }

    public void cadastraEvento(Dia dia, Mes mes, Ano ano){

    }
}
