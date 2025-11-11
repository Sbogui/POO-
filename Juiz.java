public class Juiz extends PessoaFisica {
    private String registroJudiciario;

    public Juiz(String nome, String endereco, String telefone, String cpf, String registroJudiciario) {
        super(nome, endereco, telefone, cpf);
        this.registroJudiciario = registroJudiciario;
    }

    public String getRegistroJudiciario() { return registroJudiciario; }
    public void setRegistroJudiciario(String registroJudiciario) { this.registroJudiciario = registroJudiciario; }

    @Override
    public String toString() {
        return "Juiz - " + super.toString() + ", Registro: " + registroJudiciario;
    }
}
