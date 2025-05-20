/* Não deve ser criado um objeto da classe Avaliacao que não seja uma Prova ou um
Trabalho. Por isso, o método nota da Avaliação pode apenas retornar um valor qualquer.
Quando ele for executado, na verdade, o método utilizado será o método nota que está sendo
reescrito nas subclasses Prova e Trabalho.*/

public abstract class Avaliacao {
    protected String nome;
    protected Data dtAplic;
    protected double valor;

    //IMPLEMENTAR LEITURA DO TIPO DE AVALIACAO, COM NOME, DATA (DIA MES ANO) E VALORES DA NOTA

    public String getNome(){
        return nome;
    }

    public Data getDtAplic(){
        return dtAplic;
    }

    public double getValor(){
        return valor;
    }

}
