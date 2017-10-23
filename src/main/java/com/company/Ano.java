package com.company;


/**
 * Esta classe representa um Ano de um calendário
 */
public class Ano {
    private int ano;
    private Mes[] meses;

    public Ano(int ano) {
        meses = new Mes[12];
        this.ano = ano;
        meses[0] = new Mes("Janeiro",ano);
        meses[1] = new Mes("Fevereiro",ano);
        meses[2] = new Mes("Março",ano);
        meses[3] = new Mes("Abril",ano);
        meses[4] = new Mes("Maio",ano);
        meses[5] = new Mes("Junho",ano);
        meses[6] = new Mes("Julho",ano);
        meses[7] = new Mes("Agosto",ano);
        meses[8] = new Mes("Setembro",ano);
        meses[9] = new Mes("Outubro",ano);
        meses[10] = new Mes("Novembro",ano);
        meses[11] = new Mes("Dezembro",ano);
    }

    /**
     * Retorna o ano
     * @return
     */
    public int getAno() {
        return ano;
    }

    /**
     * Retorna a lista dos meses do ano.
     * @return
     */
    public Mes[] getMeses() {
        return meses;
    }
}
