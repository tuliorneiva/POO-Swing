package ProjetoPOO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;


public class Aluno implements Serializable{
    private static final long serialVersionUID = 44;
    private String nome;
    private ArrayList<String> materiasCursadas;
    private static Set<Integer> codigosUtilizados = new HashSet<>();
    private int codigoAluno;

    public Aluno(String nome) {
        Random random = new Random();
        this.nome = nome;
        do {
            this.codigoAluno = random.nextInt(1000); // Gera um número aleatório entre 0 e 999
        } while (codigosUtilizados.contains(codigoAluno));
        codigosUtilizados.add(codigoAluno); // Adiciona o novo código ao conjunto de códigos utilizados
     
}  

    public String getNome() {
        return nome;
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
        }
    }

    @Override
    public boolean equals(Object obj) { // Método equals para comparar objetos do tipo Aluno. Pois sem ele, o tratamento de aluno já existente não funcionava.
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Aluno aluno = (Aluno) obj;
        return codigoAluno == aluno.codigoAluno;
    }
  

  @Override
    public String toString() { // Para fazer o método toString a fim de retornar ArrayLists, é necessário fazer de maneira diferente.
        StringBuilder sb = new StringBuilder();
        sb.append("Nome do aluno: ").append(nome).append("\n  ");
        sb.append("Código do aluno: ").append(codigoAluno).append("\n  ");
        for (Turmas turma : Faculdade.getTurmas()) {
            if (turma.hasAluno(getCodigoAluno())) {
                NotasMaterias notas = turma.getNotas(codigoAluno);
                sb.append("Nota do aluno: " + turma.getNomeTurma()).append(notas.toString()).append("\n  "); // Retorna o ArrayList de notas dos alunos
            }
        }
       
        return sb.toString();
    }
}
// Criar classe notasmaterias que vai conter um arraylist notasmaterias onde cada elemento é um objeto com as notas de um aluno em uma matéria