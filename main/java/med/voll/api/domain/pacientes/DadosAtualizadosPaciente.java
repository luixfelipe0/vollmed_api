package med.voll.api.domain.pacientes;

import med.voll.api.domain.endereco.Endereco;

public record DadosAtualizadosPaciente(String nome, String email, String telefone, String cpf, Endereco endereco) {

    public DadosAtualizadosPaciente(Paciente paciente) {
        this(paciente.getNome(), paciente.getEmail(), paciente.getTelefone(), paciente.getCpf(), paciente.getEndereco());
    }
}
