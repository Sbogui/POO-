import java.time.LocalDate;

public class Resolucao {
    private final String descricao;
    private final LocalDate data;

    public Resolucao(String descricao) {
        this.descricao = descricao;
        this.data = LocalDate.now();
    }

    public String getDescricao() { return descricao; }
    public LocalDate getData() { return data; }

    @Override
    public String toString() {
        return descricao + " (Data: " + data + ")";
    }
}
