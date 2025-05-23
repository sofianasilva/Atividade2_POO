public class Prova extends Avaliacao{
    private int nQuestoes;
    private AlunoProva [] notas;

    public Prova(String nome, Data dtAplic, double valor, int nQuestoes, AlunoProva[] notas){
        super(nome, dtAplic, valor);
        this.nQuestoes = nQuestoes;
        this.notas = notas;
    }

    @Override
    public double nota(String cpf){
        for (AlunoProva ap: notas){
            if (ap.getAluno().getCpf().equals(cpf)){
                return ap.notaTotal();
            }
        }
        return 0;
    }

    public int getNQuestoes(){
        return nQuestoes;
    }

    public AlunoProva[] getNotas(){
        return notas;
    }
}
