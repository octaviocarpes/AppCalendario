package com.company;

import org.junit.Test;

import static org.junit.Assert.*;

public class AnoTest {

    @Test
    public void getAnoTest(){
        //given
        int anoEsperado = 2017;

        //when
        Ano ano = new Ano(2017);
        int anoRecebidoPeloGetAno = ano.getAno();

        //then
        assertEquals(anoEsperado,anoRecebidoPeloGetAno);
    }

    @Test
    public void getMesesTest(){
        //given
        Mes[] mesesEsperados = new Mes[12];
        mesesEsperados[0] = new Mes("Janeiro",2017);
        mesesEsperados[1] = new Mes("Fevereiro",2017);
        mesesEsperados[2] = new Mes("Março",2017);
        mesesEsperados[3] = new Mes("Abril",2017);
        mesesEsperados[4] = new Mes("Maio",2017);
        mesesEsperados[5] = new Mes("Junho",2017);
        mesesEsperados[6] = new Mes("Julho",2017);
        mesesEsperados[7] = new Mes("Agosto",2017);
        mesesEsperados[8] = new Mes("Setembro",2017);
        mesesEsperados[9] = new Mes("Outubro",2017);
        mesesEsperados[10] = new Mes("Novembro",2017);
        mesesEsperados[11] = new Mes("Dezembro",2017);

        //when
        Ano ano2017 = new Ano(2017);
        Mes[] mesesRecebidos = ano2017.getMeses();

        //then
        // Como eu tenho que mudar tudo para remover o "deprecated"
        // Eu resolvi deixar por que se não teria que mudar toda a estrutura do código,
        // sim eu podia ter copiado todos os itens para Lists mas fiquei com preguiça.
        assertEquals(mesesEsperados,mesesRecebidos);
    }

}