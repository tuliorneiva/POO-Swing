package ProjetoPOO;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class Faculdade {
    private static ArrayList<Aluno> alunos = new ArrayList<>();
    private static ArrayList<Professor> professores = new ArrayList<>();
    private static ArrayList<Turmas> turmas = new ArrayList<>();
    //adicionar o arraylist de códigos utilizados aqui

    public static void addAluno(Aluno aluno){
        alunos.add(aluno);
    }

    public static void removeAluno(Aluno aluno){
        alunos.remove(aluno);
    }

    public static void addProfessor(Professor professor){
        professores.add(professor);
    }

    public static void removeProfessor(Professor professor){
        professores.remove(professor);
    }

    public static void addTurma(Turmas turma){
        turmas.add(turma);
    }

    public static void removeTurma(Turmas turma){
        turmas.remove(turma);
    }

    public static ArrayList<Aluno> getAlunos(){
        return alunos;
    }

    public static ArrayList<Professor> getProfessores(){
        return professores;
    }

    public static ArrayList<Turmas> getTurmas(){
        return turmas;
    }

    public static Aluno getAluno(int codigo){
        for(Aluno aluno : alunos){
            if(aluno.getCodigoAluno() == codigo){
                return aluno;
            }
        }
        return null;
    }

    public static Professor getProfessor(int codigo){
        for(Professor professor : professores){
            if(professor.getCodigoProfessor() == codigo){
                return professor;
            }
        }
        return null;
    }

    public static Turmas getTurma(int codigo){
        for(Turmas turma : turmas){
            if(turma.getCodigoTurmas() == codigo){
                return turma;
            }
        }
        return null;
    }



    @SuppressWarnings("unchecked")
    public static void loadProfessores(){
        try {
            // Criar um FileInputStream para ler dados de um arquivo
            FileInputStream fileInputStream = new FileInputStream("Professores.txt");
            
            // Criar um DataInputStream usando o FileInputStream
            ObjectInputStream dataInputStream = new ObjectInputStream(fileInputStream);
            
            // Ler dados do arquivo usando métodos do DataInputStream
            try {
                professores = (ArrayList<Professor>) dataInputStream.readObject();
            } catch (ClassNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            

            // Fechar o DataInputStream
            dataInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @SuppressWarnings("unchecked")
    public static void loadTurmas(){
        try {
            // Criar um FileInputStream para ler dados de um arquivo
            FileInputStream fileInputStream = new FileInputStream("Turmas.txt");
            
            // Criar um DataInputStream usando o FileInputStream
            ObjectInputStream dataInputStream = new ObjectInputStream(fileInputStream);
            
            // Ler dados do arquivo usando métodos do DataInputStream
            try {
                turmas = (ArrayList<Turmas>) dataInputStream.readObject();
            } catch (ClassNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            

            // Fechar o DataInputStream
            dataInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public static void loadAlunos() {
        try {
            FileInputStream fileInputStream = new FileInputStream("alunos.txt"); // Use o nome correto do arquivo
            ObjectInputStream dataInputStream = new ObjectInputStream(fileInputStream);
            alunos = (ArrayList<Aluno>) dataInputStream.readObject();
            dataInputStream.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
