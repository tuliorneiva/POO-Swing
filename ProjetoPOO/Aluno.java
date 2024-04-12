package ProjetoPOO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;


public class Aluno implements Serializable{
    private String nome;
    private ArrayList<String> materiasCursadas;
    private ArrayList<Float> notas;
    private static Set<Integer> codigosUtilizados = new HashSet<>();
    private int codigoAluno;

    public Aluno(){}

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

    public int getCodigoAluno(){
        return codigoAluno;
    }

    public int addMateria(String materia, Float nota){
        if(materiasCursadas.contains(materia)){
            return -1;
        }
        materiasCursadas.add(materia);
        notas.add(nota);
        return 0;
    }

    public void removeMateria(String materia){
        int index = materiasCursadas.indexOf(materia);
        if(index != -1){
            materiasCursadas.remove(index);
            notas.remove(index);
        }
    }

    public void addNota(String materia, Float nota){
        int index = materiasCursadas.indexOf(materia);
        if(index != -1){
            notas.set(index, nota);
        }
    }
}
// Criar classe notasmaterias que vai conter um arraylist notasmaterias onde cada elemento é um objeto com as notas de um aluno em uma matéria