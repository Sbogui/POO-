public class Processo {
    private int numero;
    private final Pessoa autor;
    private final Pessoa reu;
    private final Advogado advogado;
    private final Juiz juiz;
    private Resolucao resolucao;

    public Processo(int numero, Pessoa autor, Pessoa reu, Advogado advogado, Juiz juiz) {
        this.numero = numero;
        this.autor = autor;
        this.reu = reu;
        this.advogado = advogado;
        this.juiz = juiz;
    }

    public int getNumero() { return numero; }
    public void setNumero(int numero) { this.numero = numero; }

    public Pessoa getAutor() { return autor; }
    public Pessoa getReu() { return reu; }

    public Advogado getAdvogado() { return advogado; }

    public Juiz getJuiz() { return juiz; }

    public Resolucao getResolucao() { return resolucao; }
    public void setResolucao(Resolucao resolucao) { this.resolucao = resolucao; }

    @Override
    public String toString() {
        String res = (resolucao != null) ? resolucao.toString() : "Sem resolução ainda.";
        return "Processo Nº " + numero + 
               "\nAutor: " + autor.getNome() + 
               "\nRéu: " + reu.getNome() +
               "\nAdvogado: " + advogado.getNome() + 
               "\nJuiz: " + juiz.getNome() + 
               "\nResolução: " + res;
    }
}
