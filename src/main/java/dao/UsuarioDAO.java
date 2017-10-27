package dao;

import model.Evento;
import model.Usuario;

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


    public void registerUser() throws SQLException{
        String sql = "insert into usuarios(nome,email,senha)"+
                     "values('"+ usuario.getNome() + "','" + usuario.getEmail() + "','" + usuario.getSenha() + "')";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.execute();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try{
            PreparedStatement statement = connection.prepareStatement("SELECT user_id from usuarios where nome = ?");
            statement.setString(1,usuario.getNome());

            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()){
                usuario.setUserID(resultSet.getInt("user_id"));
            }

            statement.close();

            System.out.println("Usuário Registrado com Sucesso!");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }


    public void saveUser() throws SQLException {
        for (Evento e:usuario.getEventos()
                ) {
            String[] data = e.getDataDoEvento().split("/");
            String dia = data[0];
            String mes = data[1];
            String ano = data[2];

            String descriscao = e.getNomeDoEvento();

            PreparedStatement statement =
                    connection.prepareStatement("INSERT INTO eventos(dia,mes,ano,descriscao,user_id)" +
                    "                                VALUES (?,?,?,?,?)          ");

            statement.setString(1,dia);
            statement.setString(2,mes);
            statement.setString(3,ano);
            statement.setString(4,descriscao);
            statement.setInt(5,usuario.getUserID());

            statement.execute();
            statement.close();

            System.out.printf("Usuário salvo com Sucesso!");
        }
    }


    public Usuario loadUser(String email, String senha){
        ArrayList<Evento> listaEventosBD = new ArrayList<>();

        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM usuarios" +
                    "                                                      WHERE email = ? and senha = ?");

            statement.setString(1,email);
            statement.setString(2,senha);

            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()) {
                String nome = resultSet.getString("nome");
                int user_id = resultSet.getInt("user_id");
                usuario = new Usuario(nome, email, senha);
                usuario.setUserID(user_id);

            }else{
                System.out.println("Erro! ResultSet está Vazio!");
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            PreparedStatement statement = connection.prepareStatement("SELECT dia,mes,ano,descriscao FROM eventos" +
                    "                                                      WHERE user_id = ?");

            statement.setInt(1,usuario.getUserID());

            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){

                String dia = resultSet.getString("dia");
                String mes = resultSet.getString("mes");
                String ano = resultSet.getString("ano");
                String data = dia + "/" + mes + "/" + ano;

                String descriscao = resultSet.getString("descriscao");

                usuario.cadastraEvento(new Evento(descriscao,data));
            }

            System.out.println("Usuario Carregado com Sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }
}
