package ProjetoPOO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;


public class Aluno {
    private String nome;
    private ArrayList<String> materiasCursadas;
    private ArrayList<Float> notas;
    private static Set<Integer> codigosUtilizados = new HashSet<>();
    private int codigoAluno;

    public Aluno(String nome, Float[] notas, String[] materias) {
        Random random = new Random();
        this.nome = nome;
        this.materiasCursadas = new ArrayList<>(Arrays.asList(materias)); // Converte o array em ArrayList
        this.notas = new ArrayList<>(Arrays.asList(notas)); // Converte o array em ArrayList
        do {
            this.codigoAluno = random.nextInt(1000); // Gera um número aleatório entre 0 e 999
        } while (codigosUtilizados.contains(codigoAluno));
        
        codigosUtilizados.add(codigoAluno); // Adiciona o novo código ao conjunto de códigos utilizados
    }
    

    public String getNome() {
        return nome;
    }

    public ArrayList<Float> getNotas() {
        return notas;
    }

    public ArrayList<String> getMaterias() {
        return materiasCursadas;
    }

    public int codigoAluno(){
        return codigoAluno;
    }
}
