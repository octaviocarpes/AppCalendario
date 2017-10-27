package model;

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
    public Usuario(String nome,String email,String senha) {
        this.nome = nome;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
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

    public void setMeusEventos(ArrayList<Evento>eventoArrayList){
        for (Evento e:eventoArrayList
             ) {
            meusEventos.add(e);
        }
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nome='" + nome + '\'' +
                ", userID=" + userID +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                '}';
    }
}
