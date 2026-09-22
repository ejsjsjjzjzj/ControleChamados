package ControleChamados;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Chamado {
    private Long id;
    private String titulo;
    private String descricao;
    private Prioridade prioridade;
    private StatusChamado status;
    private LocalDateTime dataAbertura;
    private LocalDateTime dataEncerramento;
    
    private Cliente cliente;
    private Tecnico tecnico;
    private List<Atendimento> historicoAtendimentos;

    public Chamado(Long id, String titulo, String descricao, Prioridade prioridade, Cliente cliente) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.prioridade = prioridade;
        this.cliente = cliente;
        this.status = StatusChamado.ABERTO;
        this.dataAbertura = LocalDateTime.now();
        this.historicoAtendimentos = new ArrayList<>();
    }

    public void atribuirTecnico(Tecnico t) {
        if (this.status == StatusChamado.ABERTO || this.status == StatusChamado.AGUARDANDO_CLIENTE) {
            this.tecnico = t;
            this.status = StatusChamado.EM_ATENDIMENTO;
        } else {
            throw new IllegalStateException("O chamado só pode ser atribuído se estiver ABERTO ou AGUARDANDO_CLIENTE.");
        }
    }

    public void alterarStatus(StatusChamado s) {
        this.status = s;
    }

    public boolean estaAberto() {
        return this.status != StatusChamado.ENCERRADO;
    }

    public void encerrar() {
        if (this.historicoAtendimentos.isEmpty()) {
            throw new IllegalStateException("Regra de Negócio: Não é permitido encerrar um chamado sem nenhum atendimento registrado.");
        }
        this.status = StatusChamado.ENCERRADO;
        this.dataEncerramento = LocalDateTime.now();
    }
    
    public void adicionarAtendimento(Atendimento atendimento) {
        this.historicoAtendimentos.add(atendimento);
    }

    public Long getId() { return id; }
    public String getTitulo() { return titulo; }
    public String getDescricao() { return descricao; }
    public Prioridade getPrioridade() { return prioridade; }
    public StatusChamado getStatus() { return status; }
    public LocalDateTime getDataAbertura() { return dataAbertura; }
    public LocalDateTime getDataEncerramento() { return dataEncerramento; }
    public Cliente getCliente() { return cliente; }
    public Tecnico getTecnico() { return tecnico; }
    public List<Atendimento> getHistoricoAtendimentos() { return historicoAtendimentos; }
}

