package model;

import helpers.LoopingLinkedList;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class EventoTest {

    @Test
    public void getNomeEventoTest(){
        //given
        Evento evento;

        //when
        evento  = new Evento("","");

        //then
        assertNotNull(evento.getNomeDoEvento());
    }

    @Test
    public void setNomeEventoTest(){
        //given
        String nomeDoEvento = "";
        Evento evento = new Evento(nomeDoEvento,"");

        //when
        String nomeEsperado = "Evento";
        evento.setNomeDoEvento(nomeEsperado);

        //then
        assertEquals(evento.getNomeDoEvento(),nomeEsperado);
    }


    @Test
    public void getDataDoEventoTest(){
        //Given
        String dataDoEvento = "24/10/2017";
        Evento evento = new Evento("",dataDoEvento);

        //when
        String dataEsperada = evento.getDataDoEvento();
        boolean flag = dataEsperada.matches("([0-2][0-9]|[3][0-1])/([0][0-9]|[1][0-2])/\\d{4}");

        //then
        assertTrue(flag);
    }

    @Test
    public void setDataDoEventoTest(){
        //given
        String dataDoevento = "";
        Evento evento = new Evento("", dataDoevento);

        //when
        dataDoevento = "10/08/9654";
        evento.setDataDoEvento(dataDoevento);

        //then
        assertEquals(dataDoevento,evento.getDataDoEvento());
    }

    @Test
    public void cadastraEventoTest(){
        /**
         * GIVEN
         */
        //Monta looping linked list
        LoopingLinkedList.getInstance().add("Segunda");
        LoopingLinkedList.getInstance().add("Terça");
        LoopingLinkedList.getInstance().add("Quarta");
        LoopingLinkedList.getInstance().add("Quinta");
        LoopingLinkedList.getInstance().add("Sexta");
        LoopingLinkedList.getInstance().add("Sabado");
        LoopingLinkedList.getInstance().add("Domingo");

        //Faz o primeiro item da lista ser sabado
        LoopingLinkedList.getInstance().setPointer("Sabado");

        //Instancia um ano e pega todos seus meses
        Ano ano2017 = Calendario.getInstance().getAno(2017);
        Mes[] meses2017 = ano2017.getMeses();

        //para cada mes no vetor de meses2017, montar os dias
        for (Mes m:meses2017
             ) {
            m.montaDatas();
        }

        //cria um mes outubro
        Mes outubro2017 = meses2017[9];

        //cria um evento para teste
        Evento eventoTeste = new Evento("Teste de Cadastro","24/10/2017");

        //cria uma lista de eventos para se igualar a do dia
        ArrayList<Evento> listaDeEventosEsperada = new ArrayList<>();
        listaDeEventosEsperada.add(eventoTeste);


        /**
         * WHEN
         */
        eventoTeste.cadastraEvento();
        System.out.println(outubro2017);

        /**
         * THEN
         */
        assertEquals(listaDeEventosEsperada,outubro2017.getDia(24).getEventos());
    }



}