public class Advogado extends PessoaFisica {
    private String oab;

    public Advogado(String nome, String endereco, String telefone, String cpf, String oab) {
        super(nome, endereco, telefone, cpf);
        this.oab = oab;
    }

    public String getOab() { return oab; }
    public void setOab(String oab) { this.oab = oab;}

    @Override
    public String toString() {
        return "Advogado - " + super.toString() + ", OAB: " + oab;
    }
}
