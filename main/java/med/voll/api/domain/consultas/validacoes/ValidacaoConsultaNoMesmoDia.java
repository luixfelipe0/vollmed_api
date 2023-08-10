package med.voll.api.domain.consultas.validacoes;

import med.voll.api.domain.consultas.ConsultaRepository;
import med.voll.api.domain.consultas.DadosAgendamentoConsulta;
import med.voll.api.infra.exceptions.ValidacaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidacaoConsultaNoMesmoDia implements ValidadorAgendamentoDeConsultas {

    @Autowired
    private ConsultaRepository consultaRepository;

    public void validar(DadosAgendamentoConsulta dados) {

        var primeiroHorario = dados.data().withHour(7);
        var ultimoHorario = dados.data().withHour(18);
        var pacientePossuiOutraConsultaNoDia = consultaRepository.existsByPacienteIdAndDataBetween(dados.idPaciente(),
                primeiroHorario, ultimoHorario);

       if(pacientePossuiOutraConsultaNoDia) {
           throw new ValidacaoException("Não é possível marcar duas consultas no mesmo dia. Por favor escolha outra data.");
       }
    }

}
