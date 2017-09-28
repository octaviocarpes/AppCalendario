package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here


        Ano kappa = Calendario.getInstance().getAno(2017);

        Mes[] meses = kappa.getMeses();


        meses[0].montaDatas();
        meses[1].montaDatas();
        System.out.printf(meses[0].toString());
        System.out.printf(meses[1].toString());


    }
}
