import java.util.ArrayList;

public class Sistema{
    private ArrayList<Professor> professores;
    private ArrayList<Aluno> alunos;
    private ArrayList<Turma> turmas;

    public Sistema(){
        professores = new ArrayList<>();
        alunos = new ArrayList<>();
        turmas = new ArrayList<>();
    }

    public void novoProf(Professor p) {
        professores.add(p);
    }

    public void novoAluno(Aluno a) {
        alunos.add(a);
    }

    public void novaTurma(Turma t) {
        turmas.add(t);
    }

    public Professor encontrarProfessor(String cpf) {
        for (Professor p : this.professores) {
            if (p.getCpf().equals(cpf)) {
                return p;
            }
        }
        return null;
    }

    public ArrayList<Professor> getProfessores(){
        return professores;
    }

    public ArrayList<Aluno> getAlunos(){
        return alunos;
    }

    public ArrayList<Turma> getTurma(){
        return turmas;
    }
}
