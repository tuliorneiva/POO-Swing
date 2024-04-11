package ProjetoPOO;
import java.util.ArrayList;
import java.util.Random;

public class Professor{
    private String nome;
    private int codigo;
    private String materia;
    private ArrayList<String> turmas = new ArrayList<String>();

    public Professor(String nome, ArrayList<String> turmas, String materia){
        Random random = new Random();
        this.nome = nome;
        this.turmas = turmas;
        this.materia = materia;
        this.codigo = random.nextInt(1000);
    }

    public String getMateria() {
        
        return materia;
    }

    public ArrayList<String> getTurmas() {
        return turmas;
    }

    public String getNome() {
        return nome;
    }

    public int getCodigo() {
        return codigo;
    }

    // setters?
}