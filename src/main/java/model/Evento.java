package model;

/**
 * Esta classe representa um Evento em um dia
 * Cada evento possi uma data e um nome
 */
public class Evento {
    private String nomeDoEvento;
    private String dataDoEvento;

    public Evento(String nomeDoEvento, String dataDoEvento) {
        this.nomeDoEvento = nomeDoEvento;
        this.dataDoEvento = dataDoEvento;
    }

    /**
     * Retorna o Nome do Evento
     * @return
     */
    public String getNomeDoEvento() {
        return nomeDoEvento;
    }

    /**
     * Ajusta o nome do evento
     * @param nomeDoEvento
     */
    public void setNomeDoEvento(String nomeDoEvento) {
        this.nomeDoEvento = nomeDoEvento;
    }


    /**
     * Retorna a data do Evento no formato dd/mm/aa
     * @return
     */
    public String getDataDoEvento() {
        return dataDoEvento;
    }


    /**
     * Modifica a data do Evento no formato dd/mm/aa;
     * @param dataDoEvento
     */
    public void setDataDoEvento(String dataDoEvento) {
        this.dataDoEvento = dataDoEvento;
    }

    /**
     * Cadastra um Evento em um dia utilizando a propria data do evento.
     */
    public void cadastraEvento(){
        String[] data = dataDoEvento.split("/");
        int dia = Integer.parseInt(data[0]);
        int mes = Integer.parseInt(data[1]);
        int ano = Integer.parseInt(data[2]);

        if (mes == 02){
            if(dia < 1 || dia > 28){
                System.out.println("Não foi possível cadastrar Evento!");
                System.out.println("Dia Inválido");
                return;
            }
        }

        if (dia < 1 || dia > 31){
            System.out.println("Não foi possível cadastrar Evento!");
            System.out.println("Dia Inválido");
            return;
        }

        if (mes < 1 || mes > 12){
            System.out.println("Não foi possível cadastrar Evento!");
            System.out.println("Mês Inválido!");
            return;
        }

        if (ano < 2017 || ano > 2027){
            System.out.println("Não foi possível cadastrar Evento!");
            System.out.println("Ano Inválido!");
        }


//        for (Mes m: Calendario.getInstance().getAno(ano).getMeses()
//             ) {
//            m.montaDatas();
//        }

        Calendario.getInstance().getAno(ano).getMeses()[mes -1].getDia(dia-1).addEventos(new Evento(nomeDoEvento,dataDoEvento));

    }

    @Override
    public String toString() {
        return "{'"
                 + nomeDoEvento + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Evento evento = (Evento) o;

        if (nomeDoEvento != null ? !nomeDoEvento.equals(evento.nomeDoEvento) : evento.nomeDoEvento != null)
            return false;
        return dataDoEvento != null ? dataDoEvento.equals(evento.dataDoEvento) : evento.dataDoEvento == null;
    }

    @Override
    public int hashCode() {
        int result = nomeDoEvento != null ? nomeDoEvento.hashCode() : 0;
        result = 31 * result + (dataDoEvento != null ? dataDoEvento.hashCode() : 0);
        return result;
    }
}
