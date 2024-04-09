package ProjetoPOO;
import java.util.ArrayList;
import java.util.Random;

public class Turmas {
    private int codigoTurmas;
    private ArrayList<String> materias = new ArrayList<>();
    private ArrayList<Aluno> alunos = new ArrayList<>();
    private Professor professor;



    public Turmas(){
        Random random = new Random();
        this.codigoTurmas = random.nextInt();

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
        return codigoProfessor;
    }

    public int getCodigoAluno(){
        return codigoAluno;
    }

    public int getCodigoTurmas(){
        return codigoTurmas;
    }

}
