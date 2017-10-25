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

        MySQLConnection bd = new MySQLConnection();

        Usuario usr = new Usuario("Octavio",0001);
        Evento bdTeste = new Evento("Teste do Banco de Dados","25/10/2017");

        usr.cadastraEvento(bdTeste);

        try {
            usr.saveUser(bd.getConnection());
        } catch (SQLException e) {
            e.printStackTrace();
        }


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
