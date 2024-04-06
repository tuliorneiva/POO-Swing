package ProjetoPOO;

import java.util.ArrayList;
import java.util.Arrays;

public class Aluno {
    private String nome;
    private ArrayList<String> materiasCursadas;
    private ArrayList<Float> notas;

    public Aluno(String nome, Float[] notas, String[] materias) {
        this.nome = nome;
        this.materiasCursadas = new ArrayList<>(Arrays.asList(materias)); // Converte o array em ArrayList
        this.notas = new ArrayList<>(Arrays.asList(notas)); // Converte o array em ArrayList
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
}
