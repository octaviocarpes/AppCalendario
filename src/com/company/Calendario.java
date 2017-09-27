package com.company;

import java.util.ArrayList;

public class Calendario {

    private static Calendario calendario;

    public static Calendario getInstance(){
        if(calendario == null){
            calendario = new Calendario();
        }
        return calendario;
    }

    public Calendario() {
        anos = new ArrayList<Ano>();
        contadorDias = 1;
        //Adiciona 10 anos no Calendario
        int anoInicial = 2017;
        for (int i = anoInicial; i < 2027 ; i++) {
            anos.add(new Ano(i));
        }
    }

    private ArrayList<Ano> anos;
    public static int contadorDias;


}
