package com.company;

import static javafx.application.Application.launch;

public class Main{

    public static void main(String[] args){
	// write your code here


        Ano kappa = Calendario.getInstance().getAno(2017);

        Mes[] meses = kappa.getMeses();

        LoopingLinkedList.getInstace().add("Segunda");
        LoopingLinkedList.getInstace().add("Terça");
        LoopingLinkedList.getInstace().add("Quarta");
        LoopingLinkedList.getInstace().add("Quinta");
        LoopingLinkedList.getInstace().add("Sexta");
        LoopingLinkedList.getInstace().add("Sabado");
        LoopingLinkedList.getInstace().add("Domingo");

        LoopingLinkedList.getInstace().setPointer("Sabado");

        meses[0].montaDatas();
        meses[1].montaDatas();
        meses[2].montaDatas();
        meses[3].montaDatas();
        meses[4].montaDatas();
        meses[5].montaDatas();
        meses[6].montaDatas();
        meses[7].montaDatas();
        meses[8].montaDatas();
        meses[9].montaDatas();

        Evento evento = new Evento("Teste Cadastra Evento","28/02/2017");
        evento.cadastraEvento();

        Evento evento2 = new Evento("Teste Cadastra Evento 2","28/02/2017");
        evento2.cadastraEvento();

        Evento evento1 = new Evento("Teste Cadastra Evento 1","26/02/2017");
        evento1.cadastraEvento();

        Evento evento3 = new Evento("Teste Cadastra Evento com o douglas","30/10/2017");
        evento3.cadastraEvento();

        //System.out.printf(meses[0].toString());
        //System.out.printf(meses[1].toString());
        System.out.printf(meses[9].toString());

    }


}