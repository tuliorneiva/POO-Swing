package ProjetoPOO;

// Classe que representa uma nota de uma matéria
class Nota {
    private String materia;
    float valor;
    
    public Nota(String materia, float valor) {
        this.materia = materia;
        this.valor = valor;
    }

    public String getMateria() {
        return materia;
    }

    public float getValor() {
        return valor;
    }
}
