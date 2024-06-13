
import java.util.Set;
import java.util.TreeSet;


public class CadastraRobo {
    private Set<Robo> robos;

    public CadastraRobo() {
        robos = new TreeSet<>();
    }

    public void adicionarRobo(Robo robo) throws IllegalArgumentException {
        if (!robos.add(robo)) {
            throw new IllegalArgumentException("Robo com id " + robo.getId() + " já existe");
        }
    }

    public String listarRobo() {
        if (robos.isEmpty()) {
            return "Nenhum robo cadastrado.";
        }
        StringBuilder builder = new StringBuilder();
        int i = 0;
        for (Robo robo : robos) {
            builder.append(robo);
            if (i < robos.size() - 1) { // Verifica se não é o último robô na lista
                builder.append("\n"); // Adiciona uma quebra de linha se não for o último robô
            }
            i++;
        }
        return builder.toString();
    }
}

