package com.company;

import java.sql.*;

public class MySQLConnection {

    private static final  String driver = "com.mysql.jdbc.Driver";
    private static final  String url = "jdbc:mysql://localhost:3306/my_calendar";
    private static final  String user = "root";
    private static final  String senha = "senha";
    private static String status = "";



    public static String getStatus() {
        return status;
    }


    public static Connection getConnection(){
        Connection connection = null;
        try {

            Class.forName(driver);

            connection = DriverManager.getConnection(url,user,senha);

            if (connection != null) {

                status = ("STATUS--->Conectado com sucesso!");

            } else {

                status = ("STATUS--->Não foi possivel realizar conexão");

            }

            return connection;

        } catch (ClassNotFoundException | SQLException e ){

            throw new RuntimeException("Erro na conexão: ",e);

        }


    }

    public static void fechaConexao(Connection con){

        try {
            if(con!=null) {
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        status = ("Conectou e foi fechado");

    }

    public static void fechaConexao(Connection con, PreparedStatement stmt){

        fechaConexao(con);
        try {
            if(stmt!=null){
                stmt.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        status = ("Conectou e foi fechado");
    }

    public static void fechaConexao(Connection con, PreparedStatement stmt, ResultSet rs){

        fechaConexao(con,stmt);

        try {
            if(rs != null){
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        status = ("Conectou e foi fechado");
    }

    public static String statusConection() {

        return status;

    }

}
