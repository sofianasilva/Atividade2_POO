import java.util.ArrayList;

public class Turma {
    private String nome;
    private int ano;
    private int sem;
    private Professor prof;
    private ArrayList<Aluno> alunos;
    private ArrayList<Avaliacao> avs;

    //IMPLEMENTAR SISTEMA DE MEDIAS DA TURMA KKKKK ALOKA MIGA

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
