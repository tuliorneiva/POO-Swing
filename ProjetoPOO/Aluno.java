package ProjetoPOO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Aluno {
    private String nome;
    private int codigo;
    private ArrayList<String> materiasCursadas;
    private HashMap<Integer, Float> notasPorTurma;

    public Aluno(String nome, int codigo, String[] materias) {
        this.nome = nome;
        this.codigo = codigo;
        this.materiasCursadas = new ArrayList<>(Arrays.asList(materias)); // Converte o array em ArrayList
        this.notasPorTurma = new HashMap<>(); // Converte o array em ArrayList
    }

    public String getNome() {
        return nome;
    }

    public void addNota(int codigoTurma, float nota){
        notasPorTurma.put(codigoTurma, nota);
    }

    public Float getNotas(int codigoTurma) {
        return notasPorTurma.get(codigoTurma);
    }


    public ArrayList<String> getMaterias() {
        return materiasCursadas;
    }

    public int getCodigo() {
        return codigo;
    }
}
