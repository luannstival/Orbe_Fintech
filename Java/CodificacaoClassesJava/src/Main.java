import java.time.LocalDateTime;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        Endereco endereco = new Endereco("Rua João Maria", "80", "Monte Mor","SP","11122233");

        Usuario usuario = new Usuario(1, "Luan", "11122233344", LocalDate.of(1995,5,24), LocalDateTime.now(), endereco);
        System.out.println("Os dados completos do usuário são: " + usuario.formatarDadosUsuario());

        ContaBancaria minhaConta = new ContaBancaria(364512, usuario, 1000.0, "Banco Orbe");

        Transacao entrada = new TransacaoEntrada(2405, minhaConta, 200.0, LocalDateTime.now());
        boolean resultadoEntrada = entrada.processarTransacao();
        if (resultadoEntrada){
            System.out.println(" Crédito realizado! Saldo após entrada: R$" +minhaConta.getSaldoAtual());
        }else{
            System.out.println(" Operação não realizada!");
        }

        Transacao saida = new TransacaoSaida(2406, minhaConta, 150.0, LocalDateTime.now());
        boolean resultadoSaida = saida.processarTransacao();
        if (resultadoSaida){
            System.out.println(" Débito realizado! Saldo após saída: R$" +minhaConta.getSaldoAtual());
        }else{
            System.out.println(" Operação não realizada!");
        }

    }
}

