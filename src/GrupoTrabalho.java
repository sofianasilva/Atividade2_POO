public class GrupoTrabalho {
    private Aluno[] alunos;
    private double nota;

    public GrupoTrabalho(Aluno[] alunos, double nota){
        this.alunos = alunos;
        this.nota = nota;
    }

    public boolean alunoNoGrupo(String cpf){
        for (Aluno a: alunos){
            if (a.getCpf().equals(cpf)){
                return true;
            }
        }
        return false;
    }

    public double getNota(){
        return nota;
    }

    public Aluno[] getAlunos(){
        return alunos;
    }
}
