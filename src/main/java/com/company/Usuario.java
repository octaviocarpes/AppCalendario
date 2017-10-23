package com.company;

import java.util.ArrayList;

/**
 * Classe representa um usuário da aplicação
 * o usuário pode cadastrar eventos
 * todos os eventos do usuário ficam salvos em um arquivo txt
 *
 * para representar os eventos foi utilizado um ArrayList de eventos
 */
public class Usuario {
    private String nome;
    private ArrayList<Evento> meusEventos;


    //Construtor
    public Usuario(String nome) {
        this.nome = nome;
        meusEventos = new ArrayList<>();
    }

    /**
     * Este método cadastra um evento na lista de eventos do usuário
     * @param evento
     */
    public void cadastraEvento(Evento evento){
        meusEventos.add(evento);
    }

    /**
     * Este método "Carrega" todos os eventos do usuário
     * Lê o arquvo txt e converte as Strings para eventos.
     * @param fileName
     */
    public void loadUser(String fileName){
        ArrayList<String> aux = FileManipulator.getInstance().readFile(fileName);

        for (int i = 0; i < aux.size() ; i++) {
            String[] data = aux.get(i).split(";");
            Evento evento = new Evento(data[1],data[0]);
            meusEventos.add(evento);
            evento.cadastraEvento();
        }
    }

    /**
     * Este método "Salva" todos os eventos do usuário
     * em um arquivo txt
     * @param fileName
     */
    public void saveUser(String fileName){
        FileManipulator.getInstance().writeFile(meusEventos,fileName);
    }

    /**
     * Retorna todos os eventos do usuário
     * @return
     */
    public ArrayList<Evento> getEventos() {
        return meusEventos;
    }
}
