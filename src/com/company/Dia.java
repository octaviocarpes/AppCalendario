package com.company;

import java.util.ArrayList;

public class Dia {
    private String nomeDia;
    private int data;
    private ArrayList<Evento> eventos;

    public Dia(String nomeDia, int data) {
        this.nomeDia = nomeDia;
        this.data = data;
        eventos = new ArrayList<>();
    }

    public String getNomeDia() {
        return nomeDia;
    }

    public int getData() {
        return data;
    }

    public ArrayList<Evento> getEventos() {
        return eventos;
    }

    public void addEventos(Evento evento){
        eventos.add(evento);
    }

    @Override
    public String toString() {
        return "Dia{" +
                "nomeDia='" + nomeDia + '\'' +
                ", data=" + data + "\'" +
                ", Eventos= " + eventos +
                '}';
    }
}
