package med.voll.api.domain.consultas.validacoes;

import med.voll.api.domain.consultas.DadosAgendamentoConsulta;
import med.voll.api.domain.medicos.MedicoRepository;
import med.voll.api.infra.exceptions.ValidacaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidacaoMedicosAtivos implements ValidadorAgendamentoDeConsultas {

    @Autowired
    private MedicoRepository medicoRepository;

    public void validar(DadosAgendamentoConsulta dados) {

        var medicoEstaAtivo = medicoRepository.findAtivoById(dados.idMedico());
        if(!medicoEstaAtivo) {
            throw new ValidacaoException("Esse médico está inativo. Por favor, escolha outro médico que esteja disponível.");
        }

    }

}
