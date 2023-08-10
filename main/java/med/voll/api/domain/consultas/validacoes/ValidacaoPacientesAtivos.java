package med.voll.api.domain.consultas.validacoes;

import med.voll.api.domain.consultas.DadosAgendamentoConsulta;
import med.voll.api.domain.pacientes.PacienteRepository;
import med.voll.api.infra.exceptions.ValidacaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidacaoPacientesAtivos implements ValidadorAgendamentoDeConsultas {

    @Autowired
    private PacienteRepository pacienteRepository;

    public void validar(DadosAgendamentoConsulta dados) {

        if(dados.idPaciente() == null) {
            return;
        }

        var pacienteEstaAtivo = pacienteRepository.findAtivoById(dados.idPaciente());
        if(!pacienteEstaAtivo) {
            throw new ValidacaoException("O paciente está inativo.");
        }
    }

}
