import java.util.ArrayList;

public class Turma {
    private String nome;
    private int ano;
    private int sem;
    private Professor prof;
    private ArrayList<Aluno> alunos;
    private ArrayList<Avaliacao> avs;

    public Turma(String nome, int ano, int sem, Professor prof, ArrayList<Aluno> alunos){
        this.nome = nome;
        this.ano = ano;
        this.sem = sem;
        this.prof = prof;
        this.alunos = alunos;
        this.avs = new ArrayList<>();
    }

    public void medias(){
        System.out.println("Médias da Turma " + nome + "(" + ano + "/" + sem + "):");
        double totalTurma = 0;
        for (Aluno a : alunos){
            double soma = 0;
            System.out.println(a + ": ");
            for (Avaliacao av : avs){
                double nota = av.nota(a.getCpf());
                System.out.println(nota + " ");
                soma += nota;
            }
            if (soma > 100) soma = 100;
            System.out.println("= " + soma);
            totalTurma += soma;
        }
        double mediaTurma = totalTurma / alunos.size();
        System.out.println("Média da turma: " + mediaTurma); 
    }



    public void adicionarAvaliacao(Avaliacao av){
        avs.add(av);
    }

    public String getNome(){
        return nome;
    }

    public int getAno(){
        return ano;
    }

    public int getSem(){
        return sem;
    }

    public Professor getProf(){
        return prof;
    }

    public ArrayList<Aluno> getAlunos(){
        return alunos;
    }

    public ArrayList<Avaliacao> getAvs(){
        return avs;
    }
}
