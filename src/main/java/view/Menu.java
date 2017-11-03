package view;

import model.Calendario;
import model.Dia;
import model.Mes;
import model.Usuario;

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
        System.out.println("2 - Cadastrar um Evento");
        System.out.println("3 - Configurações");
        System.out.println("4 - Sair");
    }

    public void imprimeCalendario(int ano) {
        ImpressorDeCalendario impressorDeCalendario = new ImpressorDeCalendario();
        impressorDeCalendario.setAno(ano);
        impressorDeCalendario.imprimeAno();
    }

    public void imprimeMesDesejado(int ano,String mes) {
        Mes mesParaImprimir = null;
        for (Mes mesEscolhido:Calendario.getInstance().getAno(ano).getMeses()
             ) {
            if (mes.equals(mesEscolhido.getNome())){
                mesParaImprimir = mesEscolhido;
            }
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
        impressorDeMes.imprimeVisaoMensal();
    }

    public void imprimeInterfaceCadastroEvento(){

    }
}
