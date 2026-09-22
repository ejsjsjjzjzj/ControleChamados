package ControleChamados;

import java.time.LocalDate;

public class ControleChamados {

    public static void main(String[] args) {
        // 1. Cadastrando um Cliente
        Cliente cliente = new Cliente(1L, "Maria Silva", "maria@email.com", "(11) 98765-4321", "123.456.789-00", "Rua A, 100");
        
        // 2. Cadastrando um Técnico
        Tecnico tecnico = new Tecnico(1L, "Carlos Suporte", "carlos@email.com", "(11) 91234-5678", "Redes e Infraestrutura", LocalDate.now());

        // 3. Abrindo um Chamado (Regra: Todo chamado começa Aberto)
        Chamado chamado = new Chamado(1L, "Sem internet", "O computador não conecta na rede da empresa.", Prioridade.ALTA, cliente);
        
        System.out.println("Chamado criado com ID: " + chamado.getId() + " | Status: " + chamado.getStatus());

        // 4. Atribuindo o Técnico (Regra: Muda o status para EM_ATENDIMENTO)
        chamado.atribuirTecnico(tecnico);
        System.out.println("Técnico atribuído! Novo status: " + chamado.getStatus());

        // 5. Tentando encerrar sem atendimento (Deve disparar a regra de negócio que impede o encerramento)
        try {
            chamado.encerrar();
        } catch (IllegalStateException e) {
            System.out.println("Aviso da Regra de Negócio: " + e.getMessage());
        }

        // 6. Registrando um atendimento válido no histórico
        Atendimento atendimento = new Atendimento(1L, java.time.LocalDateTime.now(), "Cabo de rede trocado e porta do switch testada.", tecnico);
        chamado.adicionarAtendimento(atendimento);
        System.out.println("Atendimento registrado no histórico.");

        // 7. Agora sim, encerrando o chamado com sucesso
        chamado.encerrar();
        System.out.println("Chamado encerrado com sucesso! Status atual: " + chamado.getStatus());
    }
}

