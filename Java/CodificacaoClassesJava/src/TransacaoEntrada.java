import java.time.LocalDateTime;

public class TransacaoEntrada extends Transacao {

    public TransacaoEntrada() {
        super();
    }

    public TransacaoEntrada(Integer idTransacao, ContaBancaria contaBancaria, Double valorTransacao, LocalDateTime dataTransacao) {
        super(idTransacao, contaBancaria, valorTransacao, dataTransacao);

    }

    @Override
    public boolean processarTransacao() {
        if (getContaBancaria() == null)
            return false;
        //o return faz 3 coisas em sequencia: obtem a conta, solicita o valor do credito(getValorTransacao) e devolve true ou false produzido por creditar().
        return
                getContaBancaria().creditar(getValorTransacao());
    }


}