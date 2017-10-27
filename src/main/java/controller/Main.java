package controller;

import dao.MySQLConnection;
import dao.UsuarioDAO;
import model.Calendario;
import helpers.LoopingLinkedList;
import model.Mes;
import model.Usuario;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
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
        System.out.println("Digite Usuário e senha para fazer Login!");

        Scanner sc = new Scanner(System.in);

        System.out.print("Usuário:" );
        String inputLogin = sc.next();

        System.out.print("Senha: ");
        String inputPassword = sc.next();

        MySQLConnection  bd = new MySQLConnection();
        UsuarioDAO userDAO = new UsuarioDAO(bd.getConnection());

        Usuario master = userDAO.loadUser(inputLogin,inputPassword);

        System.out.println("\n");
        System.out.println("Bem vindo! " + master.getNome());

        System.out.println(master.getEventos().get(0));
        System.out.println(master.getEventos().get(0).getDataDoEvento());

    }


}


