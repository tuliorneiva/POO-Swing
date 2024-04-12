package ProjetoPOO;
import java.util.ArrayList;

// classe para obter o arraylist das notas:
public class NotasMaterias {
    private ArrayList<NotasMateria> notasMaterias;

    // Construtor
    public NotasMaterias() {
        this.notasMaterias = new ArrayList<>();
    }

    // Método para adicionar notas de uma matéria
    public void adicionarNotasMateria(NotasMateria notas) {
        notasMaterias.add(notas);
    }

    // Método para obter as notas de todas as matérias
    public ArrayList<NotasMateria> obterNotasMaterias() {
        return notasMaterias;
    }
}
