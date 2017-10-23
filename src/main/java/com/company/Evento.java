package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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

    //Formato dia/mes/ano
    public void cadastraEvento(){
        String[] data = dataDoEvento.split("/");
        int dia = Integer.parseInt(data[0]);
        int mes = Integer.parseInt(data[1]);
        int ano = Integer.parseInt(data[2]);

        if (mes == 02){
            if(dia < 1 || dia > 28){
                System.out.println("Não foi possível cadastrar Evento!");
                System.out.println("Dia Inválido");
                return;
            }
        }

        if (dia < 1 || dia > 31){
            System.out.println("Não foi possível cadastrar Evento!");
            System.out.println("Dia Inválido");
            return;
        }

        if (mes < 1 || mes > 12){
            System.out.println("Não foi possível cadastrar Evento!");
            System.out.println("Mês Inválido!");
            return;
        }

        if (ano < 2017 || ano > 2027){
            System.out.println("Não foi possível cadastrar Evento!");
            System.out.println("Ano Inválido!");
        }

        Ano year = Calendario.getInstance().getAno(ano);

        Mes [] meses = year.getMeses();

        Mes month = meses[mes -1];

        month.montaDatas();

        Dia day = month.getDia(dia -1 );

        day.addEventos(new Evento(nomeDoEvento,dataDoEvento));

    }

    @Override
    public String toString() {
        return "{'"
                 + nomeDoEvento + '\'' +
                '}';
    }
}
