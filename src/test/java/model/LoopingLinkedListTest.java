package model;

import helpers.LoopingLinkedList;
import org.junit.Test;

import static org.junit.Assert.*;

public class LoopingLinkedListTest {

    @Test
    public void getInstanceTest(){
        //given
        LoopingLinkedList loopingLinkedListEsperada;

        //when
        loopingLinkedListEsperada = LoopingLinkedList.getInstance();

        //then
        assertEquals(loopingLinkedListEsperada,LoopingLinkedList.getInstance());
    }

    @Test
    public void addTest(){
        //given
        LoopingLinkedList list = LoopingLinkedList.getInstance();

        //when
        String test = "teste";
        list.add(test);

        //then
        assertFalse(list.isEmpty());
    }

    @Test
    public void setPointerTest(){
        //given
        LoopingLinkedList.getInstance().add("Segunda");
        LoopingLinkedList.getInstance().add("Terça");
        LoopingLinkedList.getInstance().add("Quarta");

        //when
        LoopingLinkedList.getInstance().setPointer("Terça");

        //then
        assertEquals("Terça",LoopingLinkedList.getInstance().get());
    }

    @Test
    public void getTest(){
        //given
        String textoEsperado =  "Kappa";
        LoopingLinkedList.getInstance().add(textoEsperado);

        //when
        String textoRecebido = (String) LoopingLinkedList.getInstance().get();

        //then
        assertEquals(textoEsperado,textoRecebido);
    }

    @Test
    public void getNextTest(){
        //given
        String primeiro = "Primeiro";
        String segundo = "segundo";
        LoopingLinkedList.getInstance().add(primeiro);
        LoopingLinkedList.getInstance().add(segundo);

        //when
        LoopingLinkedList.getInstance().setPointer(primeiro);

        //then
        assertEquals(segundo,LoopingLinkedList.getInstance().getNext());
    }

    @Test
    public void sizeTest(){
        //given
        int tamanhoEsperado = 1;
        String aux= "test";

        //when
        LoopingLinkedList.getInstance().add(aux);
        int tamanhoRecebido = LoopingLinkedList.getInstance().size();

        //then
        assertEquals(tamanhoEsperado,tamanhoRecebido);
    }

    @Test
    public void isEmptyTest(){
        //given
        boolean valorEsperado = true;

        //when
        boolean valorRecebido = LoopingLinkedList.getInstance().isEmpty();

        //then
        assertEquals(valorEsperado,valorRecebido);
    }

}