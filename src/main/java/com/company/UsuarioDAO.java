package com.company;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UsuarioDAO {

    private Usuario usuario;
    private Connection connection;

    public UsuarioDAO(Connection connection){
        this.connection = connection;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void saveUser() throws SQLException {
        for (Evento e:usuario.getEventos()
                ) {
            String[] data = e.getDataDoEvento().split("/");
            String dia = data[0];
            String mes = data[1];
            String ano = data[2];

            String descriscao = e.getNomeDoEvento();

            String sql = "insert into eventos(dia,mes,ano,descriscao,user_id)\n" +
                         "values("+ dia + ","+ mes +"," + ano + "," + "'" + descriscao + "'" + "," + usuario.getUserID() +")";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.execute();
            statement.close();
        }
    }


    public void loadUser(String email,String senha){
        ArrayList<Evento> listaEventosBD = new ArrayList<>();

        String sql = "select * from usuarios" +
                    " where nome= '" + email + "'"+ "and senha ='" + senha + "'";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()) {
                String nome = resultSet.getString("nome");
                int user_id = resultSet.getInt("user_id");
                usuario = new Usuario(nome, email, senha, user_id);
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Usuario getUsuario() {
        return usuario;
    }
}
