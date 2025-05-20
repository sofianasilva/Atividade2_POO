public class Prova extends Avaliacao{
    private int nQuestoes;
    private AlunoProva [] notas;

     /* IMPLEMENTAR ESSA XANA DE METODO:
    O método nota da classe Prova recebe o cpf de um aluno no array, acessa o objeto AlunoProva do aluno
    com este cpf, e retorna a nota total que ele tirou na prova. O método notaTotal da classe AlunoProva simplesmente soma as notas do aluno em cada questão.
    */

    public int getNQuestoes(){
        return nQuestoes;
    }

    public AlunoProva[] getNotas(){
        return notas;
    }
}
