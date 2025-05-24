public class Trabalho extends Avaliacao {
    private int nIntegrantes;
    private GrupoTrabalho[] grupos;

    public Trabalho(String nome, Data dtAplic, double valor, int nIntegrantes, GrupoTrabalho[] grupos) {
        super(nome, dtAplic, valor);
        this.nIntegrantes = nIntegrantes;
        this.grupos = grupos;
    }

    @Override
    public double nota(String cpf) {
        for (GrupoTrabalho gt : grupos) {
            if (gt.alunoNoGrupo(cpf)) {
                return gt.getNota();
            }
        }
        return 0;
    }

    
    public int getNIntegrantes(){ 
        return nIntegrantes; 
    }

    public GrupoTrabalho[] getGrupos(){ 
        return grupos; 
    }
}