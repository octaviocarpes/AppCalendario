package model;

import java.util.ArrayList;

/**
 * Esta classe Representa o Calendário.
 * O Calendário contém uma lista de anos.
 */
public class Calendario {

    private ArrayList<Ano> anos;
    private static Calendario calendario;


    public static Calendario getInstance(){
        if(calendario == null){
            calendario = new Calendario();
        }
        return calendario;
    }

    private Calendario() {
        anos = new ArrayList<Ano>();
        //Adiciona 10 anos no Calendario
        int anoInicial = 2017;
        for (int i = anoInicial; i < 2027 ; i++) {
            anos.add(new Ano(i));
        }
    }

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
