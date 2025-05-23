public class AlunoProva {
    private Aluno aluno;
    private double[] notas;

    public AlunoProva(Aluno aluno, double[] notas){
        this.aluno = aluno;
        this.notas = notas;
    }

    public double notaTotal(){
        double total = 0;
        for (double nota : notas){
            total += nota;
        }
        return total;
    }

    public Aluno getAluno(){
        return aluno;
    }

    public double[] getNotas(){
        return notas;
    }
}
