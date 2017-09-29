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

    //Fromato dia/mes/ano
    public void cadastraEvento(){
        String[] data = dataDoEvento.split("/");
        int dia = Integer.parseInt(data[0]);
        int mes = Integer.parseInt(data[1]);
        int ano = Integer.parseInt(data[2]);

        Ano year = Calendario.getInstance().getAno(ano);

        Mes [] meses = year.getMeses();

        Mes month = meses[mes -1];

        Dia day = month.getDia(dia - 1);

        day.addEventos(new Evento(nomeDoEvento,dataDoEvento));
    }

    @Override
    public String toString() {
        return "{'"
                 + nomeDoEvento + '\'' +
                '}';
    }
}
