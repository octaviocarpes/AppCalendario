package view;

import model.Calendario;
import model.Mes;

import java.util.Arrays;

public class ImpressorDeCalendario {
    private int ano;

    public ImpressorDeCalendario() {
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public void imprimeAno(){
        System.out.println("Ano " + ano);
        Mes[] meses = Calendario.getInstance().getAno(ano).getMeses();
        for (int i = 0; i < meses.length ; i++) {
            System.out.println(meses[i].getNome());
        }
    }
}
