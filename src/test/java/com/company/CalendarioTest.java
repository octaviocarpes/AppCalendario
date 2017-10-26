package com.company;

import org.junit.Test;

import static org.junit.Assert.*;

public class CalendarioTest {

    @Test
    public void getInstanceTest(){
        //given
        Calendario calndarioEsperado;

        //when
        calndarioEsperado = Calendario.getInstance();

        //then
        assertEquals(calndarioEsperado,Calendario.getInstance());
    }

    @Test
    public void getAnoTest(){
        //given
        Ano anoEsperado = new Ano(2018);

        //when
        Ano anoRecebido = Calendario.getInstance().getAno(2018);

        //then
        assertEquals(anoEsperado,anoRecebido);
    }

}