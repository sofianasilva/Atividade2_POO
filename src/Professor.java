public class Professor extends Pessoa {
    private double salario;

    public Professor(String nome, String cpf, double salario){
        super(nome,cpf);
        this.salario = salario;
    }

    public double getSalario(){
        return salario;
    }

    @Override
    public String toString() {
        return nome + " (CPF: " + cpf + ")";
    }
}
