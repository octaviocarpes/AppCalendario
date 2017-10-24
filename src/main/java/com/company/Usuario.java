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

    //TODO refatorar método para ler dados do banco de dados.
    public void loadUser(){

    }

    //TODO refatorar método para inserir dados no banco de dados.
    public void saveUser(){

    }

    /**
     * Retorna todos os eventos do usuário
     * @return
     */
    public ArrayList<Evento> getEventos() {
        return meusEventos;
    }
}
