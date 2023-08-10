package med.voll.api.domain.consultas.validacoes;

import med.voll.api.domain.consultas.DadosAgendamentoConsulta;
import med.voll.api.infra.exceptions.ValidacaoException;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;

@Component
public class ValidacaoHorarioDeFuncionamentoDaClinica implements ValidadorAgendamentoDeConsultas {

    public void validar(DadosAgendamentoConsulta dados) {

        var dataConsulta = dados.data();
        var domingo = dados.data().getDayOfWeek().equals(DayOfWeek.SUNDAY);
        var antesDaAberturaDaClinica = dataConsulta.getHour() < 7;
        var depoisDofechamentoDaClinica = dataConsulta.getHour() > 18;

        if(domingo || antesDaAberturaDaClinica || depoisDofechamentoDaClinica) {
            throw new ValidacaoException("Dia ou horário escolhido está fora do funcionamento da clínica. Por favor, escolha outra data.");
        }

    }

}
