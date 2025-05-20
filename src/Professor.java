public class Professor extends Pessoa {
    private double salario;

    public Professor(String nome, String cpf, double salario){
        super(nome,cpf);
        this.salario = salario;
    }

    //na especificação do piru ta falando q vai ler o salario do prof, entao provalvemente vamos pegar o salario dele agui
    public double getSalario(){
        return salario;
    }
}
