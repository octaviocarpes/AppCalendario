package controller;

import model.Calendario;
import helpers.LoopingLinkedList;
import model.Mes;

import static javafx.application.Application.launch;

public class Main{

    public static void main(String[] args){
        LoopingLinkedList.getInstance().add("Segunda");
        LoopingLinkedList.getInstance().add("Terça");
        LoopingLinkedList.getInstance().add("Quarta");
        LoopingLinkedList.getInstance().add("Quinta");
        LoopingLinkedList.getInstance().add("Sexta");
        LoopingLinkedList.getInstance().add("Sabado");
        LoopingLinkedList.getInstance().add("Domingo");

        LoopingLinkedList.getInstance().setPointer("Sabado");

        Mes[] months = Calendario.getInstance().getAno(2017).getMeses();

        for (Mes m:months
             ) {
            m.montaDatas();
        }



    }


}
