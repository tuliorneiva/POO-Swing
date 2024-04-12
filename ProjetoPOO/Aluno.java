package ProjetoPOO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;


public class Aluno implements Serializable{
    private String nome;
    private ArrayList<String> materiasCursadas;
    private ArrayList<Nota> notas;
    private static Set<Integer> codigosUtilizados = new HashSet<>();
    private int codigoAluno;

    public Aluno(String nome) {
        Random random = new Random();
        this.nome = nome;
        this.notas = new ArrayList<>();
        for (Nota nota : notas) {
            this.notas.add(nota);
        do {
            this.codigoAluno = random.nextInt(1000); // Gera um número aleatório entre 0 e 999
        } while (codigosUtilizados.contains(codigoAluno));
        
        codigosUtilizados.add(codigoAluno); // Adiciona o novo código ao conjunto de códigos utilizados
    } 
     
}  

    public String getNome() {
        return nome;
    }

    public ArrayList<Nota> getNotas() {
        return notas;
    }

    public ArrayList<String> getMaterias() {
        return materiasCursadas;
    }

    public int getCodigoAluno(){
        return codigoAluno;
    }

    public void removeMateria(String materia){
        int index = materiasCursadas.indexOf(materia);
        if(index != -1){
            materiasCursadas.remove(index);
            notas.remove(index);
        }
    }


  public int addNota(Nota nota){
        // Verifica se a matéria já foi adicionada
        for (Nota n : notas) {
            if (n.getMateria().equals(nota.getMateria())) {
                return -1;
            }
        }
        // Adiciona a nova nota
        notas.add(nota);
        return 0;
    }

    public void removeNota(String materia){
        for (int i = 0; i < notas.size(); i++) {
            Nota nota = notas.get(i);
            if (nota.getMateria().equals(materia)) {
                notas.remove(i);
                break;
            }
        }
    }

    public void alterarNota(String materia, float novaNota){
        for (Nota nota : notas) {
            if (nota.getMateria().equals(materia)) {
                nota.valor = novaNota;
                break;
            }
        }
    }
  

    public String toString(){
        return "Nome: " + nome + " - Código: " + codigoAluno;
    }
}
// Criar classe notasmaterias que vai conter um arraylist notasmaterias onde cada elemento é um objeto com as notas de um aluno em uma matéria