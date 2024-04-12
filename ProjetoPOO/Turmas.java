package ProjetoPOO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Turmas implements Serializable {
    private static final long serialVersionUID = 40;
    private int codigoTurmas;
    private String nomeTurma;
    private static Set<Integer> codigosUtilizados = new HashSet<>();
    private ArrayList<Aluno> alunos = new ArrayList<>();
    @SuppressWarnings("unused")
    private int codigoProfessor; // Depois na aba editar atribuir um professor usando isso 

    public Turmas(){}

    public Turmas(String nomeTurma) {
        Random random = new Random();
        this.nomeTurma = nomeTurma;
        do {
            this.codigoTurmas = random.nextInt(1000); // Gera um número aleatório entre 0 e 999
        } while (codigosUtilizados.contains(codigoTurmas));
        
        codigosUtilizados.add(codigoTurmas); // Adiciona o novo código ao conjunto de códigos utilizados
    }

    public void adicionarAluno(Aluno aluno){
        alunos.add(aluno);
    }

    public ArrayList<Aluno> getAlunos() {
        return alunos;
    }

    public Aluno getCodigoAluno(Aluno a){
        return alunos.get(a.getCodigoAluno());
    }

    public int getCodigoTurmas(){
        return codigoTurmas;
    }

    public String getNomeTurma(){
        return nomeTurma;
    }

    @Override
    public String toString() { // Para fazer o método toString a fim de retornar ArrayLists, é necessário fazer de maneira diferente.
        StringBuilder sb = new StringBuilder();
        sb.append("Nome da turma: ").append(nomeTurma).append("\n");
        sb.append("Código da turma: ").append(codigoTurmas).append("\n");
        sb.append("Alunos Matriculados: ").append(alunos.toString()).append("\n"); // Retorna o ArrayList de alunos matriculados
        return sb.toString();
    }

}
