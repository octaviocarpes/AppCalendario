package com.company;

import java.util.ArrayList;

public class Usuario {
    private String nome;
    private ArrayList<Evento> meusEventos;

    public Usuario(String nome) {
        this.nome = nome;
        meusEventos = new ArrayList<>();
    }

    public void cadastraEvento(Evento evento){
        meusEventos.add(evento);
    }

    public void loadUser(String fileName){
        ArrayList<String> aux = FileManipulator.getInstance().readFile(fileName);

        for (int i = 0; i < aux.size() ; i++) {
            String[] data = aux.get(i).split(";");
            Evento evento = new Evento(data[1],data[0]);
            meusEventos.add(evento);
            evento.cadastraEvento();
        }
    }

    public void saveUser(String fileName){
        FileManipulator.getInstance().writeFile(meusEventos,fileName);
    }

    public ArrayList<Evento> getEventos() {
        return meusEventos;
    }
}
