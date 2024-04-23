package ProjetoPOO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Turmas implements Serializable {
    private static final long serialVersionUID = 40;
    private int codigoTurmas;
    private String nomeTurma;
    private static Set<Integer> codigosUtilizados = new HashSet<>();
    private ArrayList<Integer> alunos = new ArrayList<>();
    //private ArrayList<NotasMateria> NotasMateria = new ArrayList<>();
    private HashMap<Integer, NotasMaterias> notas;

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
        this.notas = new HashMap<>();
    }

    public void adicionarAluno(Integer aluno){
        alunos.add(aluno);
    }

    public ArrayList<Integer> getAlunos() {
        return alunos;
    }

    public Professor getProfessor(){
        return Faculdade.getProfessor(codigoProfessor);
    }

    public int setCodigoProfessor(int codigoProfessor){
        return this.codigoProfessor = codigoProfessor;
    }

    public int getCodigoProfessor() {
        return codigoProfessor;
    }

    public int getCodigoTurmas(){
        return codigoTurmas;
    }

    public void setNome(String nome){
        this.nomeTurma = nome;
    }

    public String getNomeTurma(){
        return nomeTurma;
    }

    public boolean hasAluno(int aluno) {
        return alunos.contains(aluno);
    }

    
    public HashMap<Integer, NotasMaterias> getNotas() {
        return notas;
    }

    public NotasMaterias getNotas(int codigoAluno) {
        return notas.get(codigoAluno);
    }

    

//   public void addNota(int codigoAluno, float nota){
//         // Verifica se a matéria já foi adicionada
//         if (!notas.containsKey(codigoAluno))
//             return;
//         notas.get(codigoAluno).adicionarNotasMateria(nota);
//     }

    public void addNota(Integer codigoAluno, Float nota) {
        NotasMaterias notasMaterias = this.notas.get(codigoAluno);
        if (notasMaterias == null) {
            notasMaterias = new NotasMaterias();
            notas.put(codigoAluno, notasMaterias);
        }
        notasMaterias.removeNota(0.0f);
        notasMaterias.adicionarNotasMateria(nota);
    }

    public void removeNota(int codigoAluno, int i){
        notas.get(codigoAluno).removeNota(i);
    }

    public void alterarNota(int codigoAluno, float novaNota){
        // verificar se o aluno já tem nota
        notas.get(codigoAluno).adicionarNotasMateria(novaNota);
    }

    public void removeProfessor(){
        this.codigoProfessor = 0;
    }


    @Override
    public String toString() { // Para fazer o método toString a fim de retornar ArrayLists, é necessário fazer de maneira diferente.
        StringBuilder sb = new StringBuilder();
        sb.append("Nome da turma: ").append(nomeTurma).append("\n");
        sb.append("Código da turma: ").append(codigoTurmas).append("\n");
        sb.append("Alunos Matriculados: ").append(alunos.toString()).append("\n"); // Retorna o ArrayList de alunos matriculados
        sb.append("Professor - ").append(Faculdade.getProfessor(codigoProfessor)).append("\n");
        return sb.toString();
    }

}
