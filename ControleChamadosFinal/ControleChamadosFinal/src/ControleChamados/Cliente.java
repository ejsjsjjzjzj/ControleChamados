package ControleChamados;



public class Cliente extends Usuario {
    private String cpfCnpj;
    private String endereco;

    public Cliente(Long id, String nome, String email, String telefone, String cpfCnpj, String endereco) {
        super(id, nome, email, telefone);
        this.cpfCnpj = cpfCnpj;
        this.endereco = endereco;
    }

    public String getCpfCnpj() { return cpfCnpj; }
    public String getEndereco() { return endereco; }
}

