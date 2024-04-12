package ProjetoPOO;

// Classe para representar as notas de um aluno em uma matéria específica:
class NotasMateria {
    private String materia;
    private float nota;

    // Construtor
    public NotasMateria(String materia, float nota) {
        this.materia = materia;
        this.nota = nota;
    }


    public String getMateria() {
        return materia;
    }

    public float getNota() {
        return nota;
    }
}
