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

    public Ano getAno(int numeroAno){
        boolean flag = false;
        for (int i = 0; i < anos.size(); i++) {
            if (anos.get(i).getAno() == numeroAno){
                return anos.get(i);
            }else{
                flag = true;
            }
        }
        if (flag){
            System.out.println("Ano inválido!");
            return null;
        }
        return null;
    }


}
