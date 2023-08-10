package med.voll.api.domain.consultas.validacoes;

import med.voll.api.domain.consultas.DadosAgendamentoConsulta;
import med.voll.api.infra.exceptions.ValidacaoException;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component
public class ValidacaoHorarioAntecedencia implements ValidadorAgendamentoDeConsultas {

    public void validar(DadosAgendamentoConsulta dados) {

        var dataConsulta = dados.data();
        var agora = LocalDateTime.now();
        var diferencaEmMinutos = Duration.between(agora, dataConsulta).toMinutes();

        if(diferencaEmMinutos < 30) {
            throw new ValidacaoException("A consulta deverá ser marcada com 30 minutos de antecedência mínima.");
        }

    }

}
