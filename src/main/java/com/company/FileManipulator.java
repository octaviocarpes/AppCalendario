package com.company;

import java.io.*;
import java.util.ArrayList;

/**
 * Classe que escreve e le um arquivo txt
 * para carregar e salvar os eventos
 *
 */
public class FileManipulator {

    private BufferedReader myReader;
    private BufferedWriter myWriter;

    public static FileManipulator instance;

    public static FileManipulator getInstance(){
        if(instance == null){
            instance = new FileManipulator();
        }
        return instance;
    }

    private FileManipulator() {
    }

    /**
     * Método retorna uma lista com todas as linhas
     * lidas no arquivo txt
     *
     */
    public ArrayList<String> readFile(String fileName){
        ArrayList<String> res = new ArrayList<>();
        String line = "";
        try {
            myReader = new BufferedReader(new FileReader(fileName));
        } catch (FileNotFoundException e) {
                e.printStackTrace();
        }

        try {
            while ((line = myReader.readLine()) != null){
                res.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }


    /**
     *  Método escreve os eventos do usuário em um arquivo txt;
     *  Modelo:
     *  nome do evento ; data do evento
     */
    public void writeFile(ArrayList<Evento> dados, String fileName){
        StringBuilder typewriter = new StringBuilder();
        try {
            myWriter = new BufferedWriter(new FileWriter(fileName));
            for (Evento evento:dados
                 ) {
                typewriter.append(evento.getDataDoEvento());
                typewriter.append(";");
                typewriter.append(evento.getNomeDoEvento());
                myWriter.write(typewriter.toString());
                myWriter.write("\n");
                typewriter.setLength(0);
            }
            myWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
