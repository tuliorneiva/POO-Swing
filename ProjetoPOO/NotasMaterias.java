package ProjetoPOO;
import java.util.ArrayList;

// classe para obter o arraylist das notas:
public class NotasMaterias {
    private ArrayList<Float> notasMaterias;

    // Construtor
    public NotasMaterias() {
        this.notasMaterias = new ArrayList<>();
    }

    // Método para adicionar notas de uma matéria
    public void adicionarNotasMateria(float nota) {
        notasMaterias.add(nota);
    }

    // Método para obter as notas de todas as matérias
    public ArrayList<Float> obterNotasMaterias() {
        return notasMaterias;
    }
    // metodo para remover nota e qual vai remover
    public void removeNota(float nota){
        notasMaterias.remove(nota);
    }

}
