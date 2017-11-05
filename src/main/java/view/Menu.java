package view;

import dao.UsuarioDAO;
import model.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    public Menu() {
    }

    public void imprimeTelaInicial(){
        System.out.println("MyCalendar!");
        System.out.println("Escolha uma opção:");
        System.out.println("1 - Fazer Login");
        System.out.println("2 - Cadastrar Conta");
        System.out.println("3 - Sair");
    }

    public void imprimeInterfaceUsuario(Usuario usuario) {
        System.out.println("Bem-Vindo " + usuario.getNome() + "\n");

        if (usuario.getEventos().size() > 0){
            System.out.println("Voce tem " + usuario.getEventos().size() + " Eventos marcados!\n");
        }

        System.out.println("Escolha uma das opções abaixo:");
        System.out.println("1 - Visualizar o Calendario");
        System.out.println("2 - Visualizar seus Eventos");
        System.out.println("3 - Cadastrar um Evento");
        System.out.println("4 - Configurações");
        System.out.println("5 - Sair");
    }

    public void imprimeCalendario(int ano) {
        ImpressorDeCalendario impressorDeCalendario = new ImpressorDeCalendario();
        impressorDeCalendario.setAno(ano);
        impressorDeCalendario.imprimeAno();
    }

    public void imprimeMesDesejado(int ano, String mes, Usuario usuario) {
        Mes mesParaImprimir = null;
        for (Mes mesEscolhido:Calendario.getInstance().getAno(ano).getMeses()
             ) {
            if (mes.equals(mesEscolhido.getNome())){
                mesParaImprimir = mesEscolhido;
            }
        }

        ArrayList<Evento> eventosDoUsuario = new ArrayList<>();

        eventosDoUsuario = usuario.getEventos();

        ArrayList<String> mesesComEvento = new ArrayList<>();

        for (Evento evento:eventosDoUsuario
             ) {
            String[]data = evento.getDataDoEvento().split("/");
            mesesComEvento.add(data[1]);

        }

        ArrayList<Mes> meses = new ArrayList<>();

        for (String data : mesesComEvento
             ) {
            meses.add(Calendario.getInstance().getAno(ano).getMeses()[Integer.parseInt(data) - 1]);
        }



        ArrayList<String> diasComEventos = new ArrayList<>();



        for (Dia dia:mesParaImprimir.getDias()

             ) {
            if (dia.getEventos().size() > 0){
                Integer diaComEvento = dia.getData();
                diasComEventos.add(diaComEvento.toString());
            }
        }

        ImpressorDeMes impressorDeMes = new ImpressorDeMes(mesParaImprimir);

        impressorDeMes.imprimeVisaoMensal(diasComEventos);
    }

    public void imprimeEventos(Usuario usuario){
        for (int i = 0; i < usuario.getEventos().size() ; i++) {
            System.out.println(usuario.getEventos().get(i).getNomeDoEvento() + " " + usuario.getEventos().get(i).getDataDoEvento());
        }
        System.out.println();
    }


    public void imprimeOpcoesVisualizarEventos() {

        System.out.println("Opcoes de Visualizacao: ");
        System.out.println("1 - Visualizar uma semana");
        System.out.println("2 - Visualizar um dia em específico");
        System.out.println("3 - Sair do modo de visualizacao");

    }

    public void imprimeEscolhaSemana(String mesAnalisado, int ano) {
        Mes mesParaImprimir = null;
        for (Mes mesEscolhido:Calendario.getInstance().getAno(ano).getMeses()
                ) {
            if (mesAnalisado.equals(mesEscolhido.getNome())){
                mesParaImprimir = mesEscolhido;
            }
        }

        int divisor = mesParaImprimir.getDias().size()/7;

        System.out.println(divisor);

        System.out.println("Digite uma opcao de 1 a 4:");
        System.out.println("1 - para a semana de 1 a 7" );
        System.out.println("2 - para a semana de 7 a 14" );
        System.out.println("3 - para a semana de 14 a 21" );
        System.out.println("4 - para a semana de 21 a 28" );
    }

    public void imprimePrimeiraSemana(Mes mesParaImpressao) {
        System.out.println(mesParaImpressao.toString(0,7));
    }

    public void imprimeSegundaSemana(Mes mesParaImpressao) {
        System.out.println(mesParaImpressao.toString(7,14));
    }

    public void imprimeTerceiraSemana(Mes mesParaImpressao) {
        System.out.println(mesParaImpressao.toString(14,21));

    }

    public void imprimeQuartaSemana(Mes mesParaImpressao) {
        if (mesParaImpressao.getDias().size() == 31){
            System.out.println(mesParaImpressao.toString(21, 31));
        }else{
            System.out.println(mesParaImpressao.toString(21, 30));
        }

    }

    public void imprimeRequisicaoData() {
        System.out.println("Digite o numero do dia desejado: ");
    }

    public void imprimeDia(Mes mesAnalisado, int diaDoEvento) {
        System.out.println(mesAnalisado.getDia(diaDoEvento-1));
    }

    public void imprimeInterfaceConfiguracoes() {
    }
}
