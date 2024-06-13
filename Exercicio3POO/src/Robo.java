import java.util.Objects;

public class Robo implements Comparable<Robo> {
    private int id;
    private String nome;
    private String modelo;

    public Robo(int id, String nome, String modelo) {
        this.id = id;
        this.nome = nome;
        this.modelo = modelo;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getModelo() {
        return modelo;
    }

    @Override
    public int compareTo(Robo o) {
        return Integer.compare(this.id, o.getId());
    }

    @Override
    public String toString() {
        return "Id: " +id+ ", " + "Nome: " +nome+ ", Modelo: " +modelo;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Robo robo = (Robo) obj;
        return id == robo.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
