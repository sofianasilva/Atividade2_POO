public class Trabalho extends Avaliacao {
    private int nIntegrantes;
    private GrupoTrabalho[] grupos;

    /* IMPLEMENTAR ESSA PERERECAR SUICIDA:
    • Todo Trabalho possui um número máximo de integrantes no grupo e um array com objetos da classe GrupoTrabalho para cada grupo que fez este trabalho. A classe
    GrupoTrabalho armazena o array de alunos do grupo e a nota do grupo. Há um método para verificar se um aluno pertence ao grupo, dado seu cpf.
    */

    public int getNItegrantes(){
        return nIntegrantes;
    }

    public GrupoTrabalho[] getGrupos(){
        return grupos;
    }
}
