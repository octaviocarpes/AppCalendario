package com.company;

public class Ano {
    private int ano;
    private Mes[] meses;

    public Ano(int ano) {
        this.ano = ano;
        meses[0] = new Mes("Janeiro");
        meses[1] = new Mes("Fevereiro");
        meses[2] = new Mes("Março");
        meses[3] = new Mes("Abril");
        meses[4] = new Mes("Maio");
        meses[5] = new Mes("Junho");
        meses[6] = new Mes("Julho");
        meses[7] = new Mes("Agosto");
        meses[8] = new Mes("Setembro");
        meses[9] = new Mes("Outubro");
        meses[10] = new Mes("Novembro");
        meses[11] = new Mes("Dezembro");
    }

    public int getAno() {
        return ano;
    }

    public Mes[] getMeses() {
        return meses;
    }
}
