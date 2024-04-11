package ProjetoPOO;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Turmas {
    private int codigoTurmas;
    private static Set<Integer> codigosUtilizados = new HashSet<>();
    private ArrayList<String> materias = new ArrayList<>();
    private ArrayList<Aluno> alunos = new ArrayList<>();
    private Professor professor;



    public Turmas(String[] materias, Professor professor) {
        Random random = new Random();
        this.materias = new ArrayList<>(Arrays.asList(materias)); // Converte o array em ArrayList
        this.professor = professor;
        do {
            this.codigoTurmas = random.nextInt(1000); // Gera um número aleatório entre 0 e 999
        } while (codigosUtilizados.contains(codigoTurmas));
        
        codigosUtilizados.add(codigoTurmas); // Adiciona o novo código ao conjunto de códigos utilizados
    }

    public void adicionarProfessor(Professor professor){
        this.professor = professor;
    }

    public void adicionarAluno(Aluno aluno){
        alunos.add(aluno);
    }

    public void adicionarMateria(String materia){
        materias.add(materia);
    }

    public ArrayList<Aluno> getAlunos() {
        return alunos;
    }

    public Professor getProfessor() {
        return professor;
    }

    public int getCodigoProfessor() {
        return professor.getCodigoProfessor();
    }

    public Aluno getCodigoAluno(Aluno a){
        return alunos.get(a.getCodigoAluno());
    }

    public int getCodigoTurmas(){
        return codigoTurmas;
    }

}
