import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * Classe com as rotinas de entrada e saída do projeto
 * @author Hilario Seibel Junior, Sofia Nascimento da Silva e Vivian Moreira Gomes de Lacerda
 */

public class Entrada {
    public Scanner input;

    /**
     * Construtor da classe Entrada
     * Se houver um arquivo input.txt, define que o Scanner vai ler deste arquivo.
     * Se o arquivo não existir, define que o Scanner vai ler da entrada padrão (teclado)
     */
    public Entrada() {
        try {
            // Se houver um arquivo input.txt, o Scanner vai ler dele.
            this.input = new Scanner(new FileInputStream("input.txt"));
        } catch (FileNotFoundException e) {
            // Caso contrário, vai ler do teclado.
            this.input = new Scanner(System.in);
        }
    }

    /**
     * Faz a leitura de uma linha inteira
     * Ignora linhas começando com #, que vão indicar comentários no arquivo de entrada:
     * @param msg: Mensagem que será exibida ao usuário
     * @return Uma String contendo a linha que foi lida
     */
    public String lerLinha(String msg) {
        // Imprime uma mensagem ao usuário, lê uma e retorna esta linha
        System.out.print(msg);
        String linha = this.input.nextLine();

        // Ignora linhas começando com #, que vão indicar comentários no arquivo de entrada:
        while (linha.startsWith("#")) {
            linha = this.input.nextLine();
        }
        return linha;
    }

    /**
     * Faz a leitura de um número inteiro
     * @param msg: Mensagem que será exibida ao usuário
     * @return O número digitado pelo usuário convertido para int
     */
    public int lerInteiro(String msg) {
        // Imprime uma mensagem ao usuário, lê uma linha contendo um inteiro e retorna este inteiro
        String linha = this.lerLinha(msg);
        return Integer.parseInt(linha);
    }

    /**
     * Faz a leitura de um double
     * @param msg: Mensagem que será exibida ao usuário
     * @return O número digitado pelo usuário convertido para double
     */
    public double lerDouble(String msg) {
        // Imprime uma mensagem ao usuário, lê uma linha contendo um double e retorna este double
        String linha = this.lerLinha(msg);
        return Double.parseDouble(linha);
    }

    /**
    * Imprime o menu principal, lê a opção escolhida pelo usuário e retorna a opção selecionada.
    * @return Inteiro contendo a opção escolhida pelo usuário
    */
    public int menu() {
        // Imprime o menu principal, lê a opção escolhida pelo usuário e retorna a opção selecionada.
        String msg = "*********************\n" +
                    "Escolha uma opção:\n" +
                    "1) Cadastrar professor:\n" +
                    "2) Cadastrar aluno:\n" +
                    "3) Cadastrar turma:\n" +
                    "4) Listar turmas:\n" +
                    "0) Sair\n" +
                    "Opção: ";

        int op = this.lerInteiro(msg);

        while (op < 0 || op > 4) {
            System.out.println("Opção inválida. Tente novamente: ");
            op = this.lerInteiro(msg);
        }

        return op;
    }

    /**
     * Lê os dados de um novo Professor e cadastra-o no sistema.
     * @param s: Um objeto da classe Sistema
     */
    public void cadProf(Sistema s) {
        System.out.println("\nCadastro de Professor:");
        String nome = this.lerLinha("Digite o nome do professor: ");
        String cpf = this.lerLinha("Digite o cpf do professor: ");
        double salario = this.lerDouble("Digite o salário do professor: R$ ");

        if (s.encontrarProfessor(cpf) == null) {
            Professor p = new Professor(nome, cpf, salario);
            s.novoProf(p);
            System.out.println("Professor cadastrado com sucesso!");
        } else {
            System.out.println("Erro: CPF duplicado. Professor não adicionado.");
        }
    }

    /**
     * Lê os dados de um novo Aluno e cadastra-o no sistema.
     * @param s: Um objeto da classe Sistema
     */
    public void cadAluno(Sistema s) {
        System.out.println("\nCadastro de Aluno:");
        String nome = this.lerLinha("Digite o nome do aluno: ");
        String cpf = this.lerLinha("Digite o cpf do aluno: ");
        String matricula = this.lerLinha("Digite a matrícula do aluno: ");

        if (s.encontrarAluno(matricula) == null) {
            Aluno a = new Aluno(nome, cpf, matricula);
            s.novoAluno(a);
            System.out.println("Aluno cadastrado com sucesso!");
        } else {
            System.out.println("Erro: Matrícula duplicada. Aluno não adicionado.");
        }
    }

    /**
     * Lê os dados de uma nova Turma e cadastra-a no sistema.
     * @param s: Um objeto da classe Sistema
     */
    public void cadTurma(Sistema s) {
        System.out.println("\nCadastro de Turma:");
        String nomeDisciplina = this.lerLinha("Digite o nome da disciplina: ");
        int ano = this.lerInteiro("Digite o ano da disciplina: ");
        int sem = this.lerInteiro("Digite o semestre da disciplina: ");
        
        String cpfProf = this.lerLinha("Digite o CPF do professor: ");
        Professor prof = s.encontrarProfessor(cpfProf);
        if (prof == null) {
            System.out.println("Professor não encontrado!");
            return;
        }
        
        int qtdAlunos = this.lerInteiro("Digite a quantidade de alunos na disciplina: ");
        ArrayList<Aluno> alunosTurma = new ArrayList<>();
        
        for (int i = 0; i < qtdAlunos; i++) {
            String matricula = this.lerLinha("Digite a matrícula do aluno: ");
            Aluno aluno = s.encontrarAluno(matricula);
            if (aluno == null) {
                System.out.println("Aluno não encontrado!");
                i--; // Repete a iteração
            } else {
                alunosTurma.add(aluno);
            }
        }
        
        Turma t = new Turma(nomeDisciplina, ano, sem, prof, alunosTurma);
        
        int qtdAvaliacoes = this.lerInteiro("Digite a quantidade de avaliações na disciplina: ");
        for (int i = 0; i < qtdAvaliacoes; i++) {
            System.out.println("Escolha um tipo de avaliação:");
            System.out.println("1) Prova");
            System.out.println("2) Trabalho");
            int tipo = this.lerInteiro("Opção: ");
            
            Avaliacao av;
            if (tipo == 1) {
                av = lerProva(s, alunosTurma);
            } else if (tipo == 2) {
                av = lerTrabalho(s, alunosTurma);
            } else {
                System.out.println("Opção inválida! Avaliação não cadastrada.");
                i--; // Repete a iteração
                continue;
            }
            
            t.adicionarAvaliacao(av);
        }
        
        s.novaTurma(t);
        System.out.println("Turma cadastrada com sucesso!");
    }

    /**
     * Lê os dados de uma Prova e retorna o objeto criado
     * @param s: Sistema onde os alunos estão cadastrados
     * @param alunos: Lista de alunos que farão a prova
     * @return Objeto Prova criado
     */
    private Prova lerProva(Sistema s, ArrayList<Aluno> alunos) {
        String nome = this.lerLinha("Informe o nome desta prova: ");
        int dia = this.lerInteiro("Digite o dia da prova: ");
        int mes = this.lerInteiro("Digite o mês da prova: ");
        int ano = this.lerInteiro("Digite o ano da prova: ");
        Data data = new Data(dia, mes, ano);
        
        double valor = this.lerDouble("Digite o valor máximo desta avaliação: ");
        int nQuestoes = this.lerInteiro("Digite o número de questões: ");
        
        AlunoProva[] notas = new AlunoProva[alunos.size()];
        for (int i = 0; i < alunos.size(); i++) {
            System.out.println("\nNotas para " + alunos.get(i).getNome() + ":");
            notas[i] = lerAlunoProva(alunos.get(i), nQuestoes);
        }
        
        return new Prova(nome, data, valor, nQuestoes, notas);
    }

    /**
     * Lê os dados de um AlunoProva (notas de um aluno em uma prova)
     * @param aluno: Aluno que fez a prova
     * @param nQuestoes: Número de questões da prova
     * @return Objeto AlunoProva criado
     */
    private AlunoProva lerAlunoProva(Aluno aluno, int nQuestoes) {
        double[] notas = new double[nQuestoes];
        for (int i = 0; i < nQuestoes; i++) {
            notas[i] = this.lerDouble("Nota de " + aluno.getNome() + " na questão " + (i+1) + ": ");
        }
        return new AlunoProva(aluno, notas);
    }

    /**
     * Lê os dados de um Trabalho e retorna o objeto criado
     * @param s: Sistema onde os alunos estão cadastrados
     * @param alunos: Lista de alunos que farão o trabalho
     * @return Objeto Trabalho criado
     */
    private Trabalho lerTrabalho(Sistema s, ArrayList<Aluno> alunos) {
        String nome = this.lerLinha("Informe o nome desta avaliação: ");
        int dia = this.lerInteiro("Digite o dia do trabalho: ");
        int mes = this.lerInteiro("Digite o mês do trabalho: ");
        int ano = this.lerInteiro("Digite o ano do trabalho: ");
        Data data = new Data(dia, mes, ano);
        
        double valor = this.lerDouble("Digite o valor máximo desta avaliação: ");
        int nIntegrantes = this.lerInteiro("Digite o número máximo de integrantes: ");
        int nGrupos = this.lerInteiro("Digite o número de grupos: ");
        
        GrupoTrabalho[] grupos = new GrupoTrabalho[nGrupos];
        for (int i = 0; i < nGrupos; i++) {
            System.out.println("\nGrupo " + (i+1) + ":");
            grupos[i] = lerGrupoTrabalho(s, nIntegrantes);
        }
        
        return new Trabalho(nome, data, valor, nIntegrantes, grupos);
    }

    /**
     * Lê os dados de um GrupoTrabalho e retorna o objeto criado
     * @param s: Sistema onde os alunos estão cadastrados
     * @param nIntegrantes: Número máximo de integrantes no grupo
     * @return Objeto GrupoTrabalho criado
     */
    private GrupoTrabalho lerGrupoTrabalho(Sistema s, int nIntegrantes) {
        int qtd = this.lerInteiro("Digite o número de alunos neste grupo: ");
        if (qtd > nIntegrantes) {
            System.out.println("Número de alunos excede o máximo permitido! Usando " + nIntegrantes + ".");
            qtd = nIntegrantes;
        }
        
        Aluno[] alunosGrupo = new Aluno[qtd];
        for (int i = 0; i < qtd; i++) {
            String matricula = this.lerLinha("Digite a matrícula do aluno: ");
            Aluno a = s.encontrarAluno(matricula);
            if (a == null) {
                System.out.println("Aluno não encontrado!");
                i--; // Repete a iteração
            } else {
                alunosGrupo[i] = a;
            }
        }
        
        double nota = this.lerDouble("Nota do grupo: ");
        return new GrupoTrabalho(alunosGrupo, nota);
    }
}