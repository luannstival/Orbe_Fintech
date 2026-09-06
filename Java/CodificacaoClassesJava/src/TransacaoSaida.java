import java.time.LocalDateTime;

public class TransacaoSaida  extends Transacao {


    public TransacaoSaida() {

        super();
    }

    public TransacaoSaida(Integer idTransacao, ContaBancaria contaBancaria, Double valorTransacao, LocalDateTime dataTransacao) {
        super(idTransacao, contaBancaria, valorTransacao, dataTransacao);
    }

    @Override
    public boolean processarTransacao() {
        if (getContaBancaria() == null) {
            return false;
        }
            return getContaBancaria().debitar(getValorTransacao());

    }
}
