package ProjetoPOO;
import java.io.Serializable;
import java.util.Random;

public class Professor implements Serializable {
    private static final long serialVersionUID = 42;    
    private String nome;
    private int codigoProfessor;
    

    public Professor(){}

    public Professor(String nome){
        Random random = new Random();
        this.nome = nome;
        this.codigoProfessor = random.nextInt(1000);
    }

    public String getNome() {
        return nome;
    }

    public int getCodigoProfessor() {
        return codigoProfessor;
    }

    public String toString(){
        return "Nome: " + nome + " - Código: " + codigoProfessor;
    }
}