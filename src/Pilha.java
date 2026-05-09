import java.util.NoSuchElementException;

public class Pilha<E> {

    private Celula<E> topo;
    private Celula<E> fundo;

    public Pilha() {

        Celula<E> sentinela = new Celula<E>();

        fundo = sentinela;
        topo = sentinela;
    }

    public boolean vazia() {
        return fundo == topo;
    }

    public void empilhar(E item) {

        Celula<E> novaCelula = new Celula<>(item);

        novaCelula.setProximo(topo);

        topo = novaCelula;
    }

    public E desempilhar() {

        E desempilhado = consultarTopo();

        topo = topo.getProximo();

        return desempilhado;
    }

    public E consultarTopo() {

        if (vazia()) {
            throw new NoSuchElementException("Nao há nenhum item na pilha!");
        }

        return topo.getItem();
    }

    public Pilha<E> subPilha(int numItens) {

        Pilha<E> pilhaTemp = new Pilha<>();
        Pilha<E> subPilhaResultado = new Pilha<>();

        int contador = 0;

        Celula<E> atual = topo;

        while (atual != fundo) {
            contador++;
            atual = atual.getProximo();
        }

        if (numItens > contador) {
            throw new IllegalArgumentException(
                "A pilha não contém " + numItens + " elementos."
            );
        }

        atual = topo;

        for (int i = 0; i < numItens; i++) {
            pilhaTemp.empilhar(atual.getItem());
            atual = atual.getProximo();
        }

        while (!pilhaTemp.vazia()) {
            subPilhaResultado.empilhar(pilhaTemp.desempilhar());
        }

        return subPilhaResultado;
    }
}