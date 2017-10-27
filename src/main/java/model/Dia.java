package model;

import java.util.ArrayList;

/**
 * Esta classe Representa um dia no calendário.
 * Cada dia tem uma lista de eventos.
 */
public class Dia {
    private String nomeDia;
    private int data;
    private ArrayList<Evento> eventos;

    public Dia(String nomeDia, int data) {
        this.nomeDia = nomeDia;
        this.data = data;
        eventos = new ArrayList<>();
    }

    /**
     * Este método retorna o nome do Dia e.g: "Segunda", "Terça" ...
     * @return
     */
    public String getNomeDia() {
        return nomeDia;
    }


    /**
     * Este método retorna a data do dia.
     * No caso seria o número do dia.
     * @return
     */
    public int getData() {
        return data;
    }


    /**
     * Este método retorna uma lista com todos os seus eventos.
     * @return
     */
    public ArrayList<Evento> getEventos() {
        return eventos;
    }


    /**
     * Este método adiciona um Evento na lista de eventos do dia.
     * @param evento
     */
    public void addEventos(Evento evento){
        eventos.add(evento);
    }

    @Override
    public String toString() {
        return "Dia{" +
                "nomeDia='" + nomeDia + '\'' +
                ", data=" + data + "\'" +
                ", Eventos= " + eventos +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Dia dia = (Dia) o;

        if (data != dia.data) return false;
        if (nomeDia != null ? !nomeDia.equals(dia.nomeDia) : dia.nomeDia != null) return false;
        return eventos != null ? eventos.equals(dia.eventos) : dia.eventos == null;
    }

    @Override
    public int hashCode() {
        int result = nomeDia != null ? nomeDia.hashCode() : 0;
        result = 31 * result + data;
        result = 31 * result + (eventos != null ? eventos.hashCode() : 0);
        return result;
    }
}
