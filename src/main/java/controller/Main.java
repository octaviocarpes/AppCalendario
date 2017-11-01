package controller;

import dao.MySQLConnection;
import dao.UsuarioDAO;
import model.Calendario;
import helpers.LoopingLinkedList;
import model.Mes;
import model.Usuario;
import view.ImpressorDeCalendario;
import view.ImpressorDeMes;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Scanner;

import static javafx.application.Application.launch;

public class Main{

    public static void main(String[] args){
        LoopingLinkedList.getInstance().populaSemana();


        ImpressorDeCalendario kappa = new ImpressorDeCalendario();
        kappa.setAno(2017);
        kappa.imprimeAno();

        Calendario.getInstance().getAno(2017).getMeses()[0].montaDatas();
        ImpressorDeMes impressorDeMes = new ImpressorDeMes(Calendario.getInstance().getAno(2017).getMeses()[0]);
        impressorDeMes.imprimeVisaoMensal();
    }


}


