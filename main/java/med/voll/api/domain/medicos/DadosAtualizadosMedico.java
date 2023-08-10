package med.voll.api.domain.medicos;

import med.voll.api.domain.endereco.Endereco;

public record DadosAtualizadosMedico(String nome, String email, String telefone, String crm, Especialidades especialidade, Endereco endereco) {

    public DadosAtualizadosMedico(Medico medico) {
        this(medico.getNome(), medico.getEmail(), medico.getTelefone(), medico.getCrm(), medico.getEspecialidade(), medico.getEndereco());
    }

}
