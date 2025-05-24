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

    public Aluno encontrarAluno(String matricula){
        for (Aluno a : alunos){
            if (a.getMatricula().equals(matricula)){
                return a;
            }
        }
        return null;
    }

    public void listarProfessores() {
        if (professores.isEmpty()) {
            System.out.println("Nenhum professor cadastrado.");
            return;
        }
        System.out.println("Professores cadastrados:");
        for (Professor p : professores) {
            System.out.println("* " + p);
        }
    }

    public void listarAlunos() {
        if (alunos.isEmpty()) {
            System.out.println("Nenhum aluno cadastrado.");
            return;
        }
        System.out.println("Alunos cadastrados:");
        for (Aluno a : alunos) {
            System.out.println("* " + a);
        }
    }

    public void listarTurmas(){
        if(turmas.isEmpty()){
            System.out.println("\nNenhuma turma cadastrada.");
            return;
        }
            for (Turma t : turmas){
                t.medias();
            }
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
