package ControleChamados;


import java.time.LocalDate;

public class Tecnico extends Usuario {
    private String especialidade;
    private LocalDate dataCadastro;
    private Equipe equipe; // Associação com Equipe

    public Tecnico(Long id, String nome, String email, String telefone, String especialidade, LocalDate dataCadastro) {
        super(id, nome, email, telefone);
        this.especialidade = especialidade;
        this.dataCadastro = dataCadastro;
    }

    public String getEspecialidade() { return especialidade; }
    public LocalDate getDataCadastro() { return dataCadastro; }
    public Equipe getEquipe() { return equipe; }
    public void setEquipe(Equipe equipe) { this.equipe = equipe; }
}


