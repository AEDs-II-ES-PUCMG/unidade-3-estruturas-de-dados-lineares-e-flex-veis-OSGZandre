import java.time.LocalDateTime;

public class Aplicacao {

    public static void main(String[] args)
            throws InterruptedException {

        System.out.println("===== TAREFA 1 =====");

        Fila<Character> filaCaracteres = new Fila<>();

        String nomeCompleto = "Andre Almeida";

        for (int i = 0; i < nomeCompleto.length(); i++) {

            char caractere = nomeCompleto.charAt(i);

            if (caractere != ' ') {
                filaCaracteres.enfileirar(caractere);
            }
        }

        System.out.println("\nCaracteres na fila:");

        filaCaracteres.imprimir();

        char letra = 'a';

        int ocorrencias =
            filaCaracteres.contarOcorrencias(letra);

        System.out.println(
            "\nQuantidade de ocorrências de '" +
            letra +
            "': " +
            ocorrencias
        );

        System.out.println("\nDesenfileirando:");

        Character removido = filaCaracteres.desenfileirar();

        System.out.println(
            "Caractere removido: " + removido
        );

        System.out.println("\nFila atual:");

        filaCaracteres.imprimir();

        System.out.println("\n===== TAREFA 2 =====");

        Fila<Cliente> filaPedidos = new Fila<>();

        Cliente cli;

        cli = new Cliente(
            "John",
            LocalDateTime.now()
        );

        filaPedidos.enfileirar(cli);

        Thread.sleep(10);

        cli = new Cliente(
            "Charles",
            LocalDateTime.now()
        );

                filaPedidos.enfileirar(cli);

        Thread.sleep(10);

        cli = new Cliente(
            "André",
            LocalDateTime.now()
        );


                filaPedidos.enfileirar(cli);

        Thread.sleep(10);

        cli = new Cliente(
            "Almeida",
            LocalDateTime.now()
        );

        filaPedidos.enfileirar(cli);

        Thread.sleep(10);

        cli = new Cliente(
            "Mary",
            LocalDateTime.now()
        );

        filaPedidos.enfileirar(cli);

        Thread.sleep(10);

        cli = new Cliente(
            "Ana",
            LocalDateTime.now()
        );

        filaPedidos.enfileirar(cli);

        System.out.println("\nFila de pedidos:");

        filaPedidos.imprimir();

        System.out.println("\n===== TAREFA 3 =====");

        Fila<Cliente> lote = filaPedidos.extrairLote(2);

        System.out.println(
            "\nLote extraído da fila:"
        );

        lote.imprimir();

        System.out.println(
            "\nFila restante após extração:"
        );

        filaPedidos.imprimir();
    }
}