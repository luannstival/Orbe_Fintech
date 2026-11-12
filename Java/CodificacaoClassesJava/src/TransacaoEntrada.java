import java.time.LocalDateTime;

public class TransacaoEntrada extends Transacao {

    private String categoriaEntrada;

    public TransacaoEntrada() { super();}

    public TransacaoEntrada(Integer idTransacao, ContaBancaria contaBancaria, Double valorTransacao, LocalDateTime dataTransacao, String categoriaEntrada) {
        super(idTransacao, contaBancaria, valorTransacao, dataTransacao);
        this.categoriaEntrada = categoriaEntrada;
    }

    @Override
    public boolean processarTransacao() {
        if (getContaBancaria() == null) {
            return false;
        }
        //o return faz 3 coisas em sequencia: obtem a conta, solicita o valor do credito(getValorTransacao) e devolve true ou false produzido por creditar().
        return
                getContaBancaria().creditar(getValorTransacao());
    }

    public String getCategoriaEntrada() {
        return categoriaEntrada;
    }

    public void setCategoriaEntrada(String categoriaEntrada) {
        this.categoriaEntrada = categoriaEntrada;
    }

}