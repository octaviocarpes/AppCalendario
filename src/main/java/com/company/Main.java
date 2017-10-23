package com.company;

import java.sql.SQLException;
import java.util.Scanner;

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

        System.out.println("MyCalendar!");


        boolean flag = true;
//
//        while(flag){
//            Scanner sc = new Scanner(System.in);
//
//
//            System.out.print("Login: ");
//            sc.next();
//
//            System.out.print("Senha: ");
//            sc.next();
//            flag = false;
//
//        }

    }


}
