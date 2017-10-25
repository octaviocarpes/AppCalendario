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
    private ArrayList<Evento> meusEventos;


    //Construtor
    public Usuario(String nome,int userID) {
        this.nome = nome;
        this.userID = userID;
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

    //TODO refatorar método para ler dados do banco de dados.
    public void loadUser(){

    }


    public void saveUser(Connection connection) throws SQLException{
        for (Evento e:meusEventos
             ) {
            String[] data = e.getDataDoEvento().split("/");
            String dia = data[0];
            String mes = data[1];
            String ano = data[2];

            String descriscao = e.getNomeDoEvento();

            String sql = "insert into eventos(dia,mes,ano,descriscao,user_id)\n" +
                         "values("+ dia + ","+ mes +"," + ano + "," + "'" + descriscao + "'" + "," + getUserID() +")";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.execute();
            statement.close();
        }
    }

    /**
     * Retorna todos os eventos do usuário
     * @return
     */
    public ArrayList<Evento> getEventos() {
        return meusEventos;
    }
}
