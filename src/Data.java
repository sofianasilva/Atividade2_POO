public class Data {
    private int dia;
    private int mes;
    private int ano;

    public Data(int dia, int mes, int ano){
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    public boolean posterior(Data d2) {
        if (ano > d2.ano) return true;
        if (ano == d2.ano && mes > d2.mes) return true;
        if (ano == d2.ano && mes == d2.mes && dia > d2.dia) return true;
        return false;
    }

    public String toString(){
        return dia + "/" + mes + "/" + ano;
    }

    public int getDia(){
        return dia;
    }

    public int getMes(){
        return mes;
    }

    public int getAno(){
        return ano;
    }
}
