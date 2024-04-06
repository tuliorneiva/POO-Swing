package ProjetoPOO;
import java.util.ArrayList;
import java.util.Random;

public class Turmas {
    private int codigo;
    private ArrayList<String> materias = new ArrayList<>();
    private ArrayList<Aluno> alunos = new ArrayList<>();
    private Professor professor;



    public Turmas(){
        Random random = new Random();
        this.codigo = random.nextInt();
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

    public int getCodigo() {
        return codigo;
    }

}
