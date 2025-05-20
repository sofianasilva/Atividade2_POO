public class Data {
    private int dia;
    private int mes;
    private int ano;

    public Data(int dia, int mes, int ano){
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    /* IMPLEMENTAR ESSA XERECA:
    O método posterior da classe Data recebe outra Data d2 como parâmetro, e retorna verdadeiro apenas quando a data em questão é posterior a d2
    */

    //o prof faz assim nas atividades amo roubei dele a formataçao
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
