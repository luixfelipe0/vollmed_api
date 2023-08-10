package med.voll.api.domain.consultas.validacoes;

import med.voll.api.domain.consultas.ConsultaRepository;
import med.voll.api.domain.consultas.DadosAgendamentoConsulta;
import med.voll.api.infra.exceptions.ValidacaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidacaoConsultaComMedicoOcupado implements ValidadorAgendamentoDeConsultas {

    @Autowired
    private ConsultaRepository consultaRepository;

    public void validar(DadosAgendamentoConsulta dados) {

        var MedicoJaOcupadoNesseDiaEHorario = consultaRepository.existsByMedicoIdAndData(dados.idMedico(), dados.data());
        if(MedicoJaOcupadoNesseDiaEHorario) {
            throw new ValidacaoException("Médico já possui uma consulta marcada nesse dia e horário.");
        }

    }

}
