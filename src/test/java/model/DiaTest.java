package model;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class DiaTest {

    @Test
    public void getNomeDiaTest(){
        //given
        String nomeEsperado = "Segunda";
        Dia dia = new Dia(nomeEsperado,1);

        //when
        String nomeRecebido = dia.getNomeDia();

        //then
        assertEquals(nomeEsperado,nomeRecebido);
    }

    @Test
    public void getDataTest(){
        //given
        int dataEsperada = 1;
        Dia dia = new Dia("", dataEsperada);

        //when
        int dataRecebida = dia.getData();

        //then
        assertEquals(dataEsperada,dataRecebida);
    }

    @Test
    public void getEventosTest(){
        //given
        ArrayList<Evento> eventosEsperados = new ArrayList<>();
        Evento eventoEsperado = new Evento("Evento teste","");
        eventosEsperados.add(eventoEsperado);
        Dia dia = new Dia("",1);

        //when
        dia.addEventos(eventoEsperado);
        ArrayList<Evento> eventosRecebidos = dia.getEventos();

        //then
        assertEquals(eventosEsperados,eventosRecebidos);
    }

    

}