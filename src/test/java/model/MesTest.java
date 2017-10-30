package model;

import helpers.LoopingLinkedList;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class MesTest {

    @Test
    public void montaDatasTest(){
        //given
        ArrayList<Dia> diasEsperados = new ArrayList<>();
        LoopingLinkedList.getInstance().add("Domingo");
        LoopingLinkedList.getInstance().add("Segunda");
        LoopingLinkedList.getInstance().add("Terça");
        LoopingLinkedList.getInstance().add("Quarta");
        LoopingLinkedList.getInstance().add("Quinta");
        LoopingLinkedList.getInstance().add("Sexta");
        LoopingLinkedList.getInstance().add("Sabado");
        LoopingLinkedList.getInstance().setPointer("Sabado");
        for (int i = 1; i < 32; i++) {
            diasEsperados.add(new Dia((String) LoopingLinkedList.getInstance().getNext(),i));
        }

        LoopingLinkedList.getInstance().setPointer("Sabado");
        Mes mesTeste = new Mes("Janeiro",2017);

        //when
        mesTeste.montaDatas();

        //then
        assertEquals(diasEsperados,mesTeste.getDias());
    }

}