package ControleChamados;



public class Equipe {
    private Long id;
    private String nome;
    private String descricao;

    public Equipe(Long id, String nome, String descricao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
    }

    public Long getId() { return id; }
    public String getNome() { return nome; }
    public String getDescricao() { return descricao; }
}

