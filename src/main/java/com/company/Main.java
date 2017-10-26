package com.company;

import com.sun.jmx.snmp.SnmpUnknownSubSystemException;

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

        UsuarioDAO octavioDAO = new UsuarioDAO(bd.getConnection());

        octavioDAO.loadUser("octavio@email.com","super senha secreta");

        Usuario octavioDoBanco = new Usuario(octavioDAO.getUsuario().getNome(),
                                             octavioDAO.getUsuario().getEmail(),
                                             octavioDAO.getUsuario().getSenha());

        octavioDoBanco.setUserID(octavioDAO.getUsuario().getUserID());

        octavioDoBanco.setMeusEventos(octavioDAO.getUsuario().getEventos());

        System.out.println(octavioDoBanco);
        System.out.println(octavioDoBanco.getEventos());

        /**
         * Testesinho para ver se estava dando tudo certo
         */
//        UsuarioDAO usuarioDAO = new UsuarioDAO(bd.getConnection());
//
//        Usuario octavio = new Usuario("Octavio","octavio@email.com","super senha secreta");
//
//        usuarioDAO.setUsuario(octavio);
//
//        try {
//            usuarioDAO.registerUser();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        octavio.setUserID(usuarioDAO.getUsuario().getUserID());
//
//        System.out.println(octavio.toString());
//
//        Evento kappa = new Evento("Kappa Pride Event Tiem(Teste DAO saveUser)","26/10/2017");
//
//        octavio.cadastraEvento(kappa);
//
//        usuarioDAO.setUsuario(octavio);
//
//        try {
//            usuarioDAO.saveUser();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }


    }


}
