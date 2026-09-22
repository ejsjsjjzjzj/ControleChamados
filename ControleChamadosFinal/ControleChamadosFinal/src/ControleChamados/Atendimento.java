package ControleChamados;


import java.time.LocalDateTime;

public class Atendimento {
    private Long id;
    private LocalDateTime dataHora;
    private String descricao;
    private Tecnico realizadoPor;

    public Atendimento(Long id, LocalDateTime dataHora, String descricao, Tecnico realizadoPor) {
        this.id = id;
        this.dataHora = dataHora;
        this.descricao = descricao;
        this.realizadoPor = realizadoPor;
    }

    public void registrar() {
        // Lógica de registro de atendimento
    }

    public Long getId() { return id; }
    public LocalDateTime getDataHora() { return dataHora; }
    public String getDescricao() { return descricao; }
    public Tecnico getRealizadoPor() { return realizadoPor; }
}

