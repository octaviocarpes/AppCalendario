package controller;

import dao.MySQLConnection;
import dao.UsuarioDAO;
import model.Calendario;
import helpers.LoopingLinkedList;
import model.Mes;
import model.Usuario;
import view.ImpressorDeCalendario;
import view.ImpressorDeMes;
import view.Menu;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Scanner;

import static javafx.application.Application.launch;

public class Main{

    public static void main(String[] args){

        MySQLConnection bancoDeDados = new MySQLConnection();
        UsuarioDAO userBD = new UsuarioDAO(bancoDeDados.getConnection());

        Scanner sc = new Scanner(System.in);

        LoopingLinkedList.getInstance().populaSemana();

        Menu meuMenu = new Menu();
        MeuController controller = new MeuController(userBD);

        controller.iniciarPrograma();
    }


}


