package com.company;

import java.sql.*;
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
    private int userID;
    private String email;
    private String senha;
    private ArrayList<Evento> meusEventos;


    //Construtor
    public Usuario(String nome,String email,String senha, int userID) {
        this.nome = nome;
        this.userID = userID;
        this.email = email;
        this.senha = senha;
        meusEventos = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    /**
     * Este método cadastra um evento na lista de eventos do usuário
     * @param evento
     */
    public void cadastraEvento(Evento evento){
        meusEventos.add(evento);
    }






    /**
     * Retorna todos os eventos do usuário
     * @return
     */
    public ArrayList<Evento> getEventos() {
        return meusEventos;
    }
}
