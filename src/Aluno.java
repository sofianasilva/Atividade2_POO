public class Aluno extends Pessoa{
    private String matricula;

    public Aluno(String nome, String cpf, String matricula){
        super(nome,cpf);
        this.matricula = matricula;
    }

    @Override
    public String toString(){
        return nome + "(Matricula: " + matricula + ")";
    }

    public String getMatricula(){
        return matricula;
    }

}
