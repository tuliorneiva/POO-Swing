package ProjetoPOO;
import java.util.ArrayList;
import java.util.Random;

public class Professor{
    private String nome;
    private int codigo;
    private ArrayList<String> materias = new ArrayList<String>();
    private ArrayList<String> turmas = new ArrayList<String>();

    public Professor(String nome, ArrayList<String> turmas, ArrayList<String> materias){
        Random random = new Random();
        this.nome = nome;
        this.turmas = turmas;
        this.materias = materias;
        this.codigo = random.nextInt(1000);
    }

    public ArrayList<String> getMaterias() {
        // for(int i = 0; i < materias.size(); i++){
        //     materias´.get(i);
        // }
        return materias;
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