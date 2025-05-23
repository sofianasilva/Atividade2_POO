import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Entrada {
    public Scanner input;

    public Entrada() {
        try {
            this.input = new Scanner(new FileInputStream("input.txt"));
        } catch (FileNotFoundException e) {

            this.input = new Scanner(System.in);
        }
    }

    private String lerLinha(String msg) {
        System.out.print(msg);
        String linha = this.input.nextLine();

        while (linha.charAt(0) == '#') {
            linha = this.input.nextLine();
        }
        return linha;
    }

    private int lerInteiro(String msg) {
        String linha = this.lerLinha(msg);
        return Integer.parseInt(linha);
    }

    private double lerDouble(String msg) {
        String linha = this.lerLinha(msg);
        return Double.parseDouble(linha);
    }

    public int menu() {

        String msg = "*********************\n" +
                "Escolha uma opção:\n" +
                "1) Cadastrar professor:\n" +
                "2) Cadastrar aluno:\n" +
                "3) Cadastrar turma:\n" +
                "4) Listar turmas:\n" +
                "0) Sair\n";

        int op = this.lerInteiro(msg);

        while (op < 0 || op > 4) {
            System.out.println("Opção inválida. Tente novamente: ");
            op = this.lerInteiro(msg);
        }

        return op;
    }


    public void cadProf(Sistema s) {
        System.out.println("\nCadastro de Professor:");
        String nome = this.lerLinha("Digite o nome do professor: ");
        String cpf = this.lerLinha("Digite o cpf do professor: ");
        double salario = this.lerDouble("Digite o salário do professor: R$");

        if (s.encontrarProfessor(cpf) == null) {
            Professor p = new Professor(nome, cpf, salario);
            s.novoProf(p);
            System.out.println("Professor cadastrado!");
        }
        else {
            System.out.println("Erro: CPF duplicado. Professor não adicionado.");
        }
    }
}
