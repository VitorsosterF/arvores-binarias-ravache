import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Arvore
{
    No raiz;

    public Arvore()
    {
        raiz = null;
    };

    private int altura(No no)
    {
        if (no == null) return 0;

        return 1 + Math.max(altura(no.esquerdo), altura(no.direito));
    }

    public int contarNosRecursivo(No no)
    {
        if (no == null) return 0;

        return 1 + contarNosRecursivo(no.esquerdo) + contarNosRecursivo(no.direito);
    }

    public int contarNosNaoRecursivo() {
        if (raiz == null) return 0;

        Stack<No> pilha = new Stack<>();
        pilha.push(raiz);

        int contador = 0;

        while (!pilha.isEmpty()) {
            No atual = pilha.pop();
            contador++;

            if (atual.direito != null) {
                pilha.push(atual.direito);
            }
            if (atual.esquerdo != null) {
                pilha.push(atual.esquerdo);
            }
        }

        return contador;
    }

    public int contarNosComFila(No raiz)
    {
        if (raiz == null) return 0;

        LinkedList<No> fila = new LinkedList<>();
        fila.add(raiz);

        int contador = 0;

        while (!fila.isEmpty())
        {
            No atual = fila.pop();
            contador++;

            if(atual.esquerdo != null) fila.add(atual.esquerdo);
            if(atual.direito != null) fila.add(atual.direito);
        }

        return contador;
    }

    public int contarFolhaNaoRecursivo(No no)
    {
        if (no == null) return 0;

        Queue<No> fila = new LinkedList<>();
        fila.add(raiz);

        int folhas = 0;

        while(!fila.isEmpty())
        {
            No atual = fila.poll();
            if (atual.direito == null && atual.esquerdo == null) folhas++;

            if (atual.esquerdo != null) fila.add(atual.esquerdo);
            if (atual.direito != null) fila.add(atual.direito);
        }
        return 0;
    }

    public int contarFolhasRecursivo(No no) {
        if (no == null) return 0;

        if (no.esquerdo == null && no.direito == null) {
            return 1;
        }

        return contarFolhasRecursivo(no.esquerdo) + contarFolhasRecursivo(no.direito);
    }

    public int contarFolhasNaoRecursivo() {
        if (raiz == null) return 0;

        Stack<No> pilha = new Stack<>();
        pilha.push(raiz);

        int folhas = 0;

        while (!pilha.isEmpty()) {
            No atual = pilha.pop();

            if (atual.esquerdo == null && atual.direito == null) {
                folhas++;
            }

            if (atual.direito != null) {
                pilha.push(atual.direito);
            }
            if (atual.esquerdo != null) {
                pilha.push(atual.esquerdo);
            }
        }

        return folhas;
    }


    public void preOrdemRecursivo(No no)
    {
        if (no == null) return;

        System.out.print(no.valor + "");
        preOrdemRecursivo(no.esquerdo);
        preOrdemRecursivo(no.direito);

    };

    public void preOrdemNaoRecursivo ()
    {
        if (raiz == null) return;

        Stack<No> pilha = new Stack<No>();
        pilha.push(raiz);

        while(!pilha.isEmpty())
        {
            No atual = pilha.pop();
            System.out.print(atual.valor + " ");

            if (atual.direito != null) pilha.push(atual.direito);
            if (atual.esquerdo != null) pilha.push(atual.esquerdo);
        }


    };

    public void emOrdemRecursivo (No no)
    {
        if (no == null) return;

        preOrdemRecursivo(no.esquerdo);
        System.out.print(no.valor + "");
        preOrdemRecursivo(no.direito);
    };

    public void emOrdemNaoRecursivo ()
    {
        if (raiz == null) return;

        Stack<No> pilha = new Stack<>();
        No atual = raiz;

        while (atual != null || !pilha.isEmpty()) {
            while (atual != null) {
                pilha.push(atual);
                atual = atual.esquerdo;
            }

            atual = pilha.pop();
            System.out.print(atual.valor + " ");

            atual = atual.direito;
        }
    }

    public void posOrdemRecursivo (No no)
    {
        if (no == null) return;

        posOrdemRecursivo(no.esquerdo);
        posOrdemRecursivo(no.direito);
        System.out.print(no.valor + "");
    };

    public void posOrdemNaoRecursivo ()
    {
        if (raiz == null) return;

        Stack<No> pilha = new Stack<>();
        No atual = raiz;

        while (atual != null || !pilha.isEmpty())
        {
            while (atual != null) {
                pilha.push(atual);
                atual = atual.esquerdo;
            }
            atual = atual.direito;

            atual = pilha.pop();
            System.out.print(atual.valor + " ");
        }
    }


    public void emNivelRecursivo ()
    {
        int altura = altura(raiz);

        for (int i = 0; i < altura; i++)
        {
            percorrerNivel(raiz, i);
        }
    };

    public void emNivelSemRecursao ()
    {
        if (raiz == null) return;
    }


    private void percorrerNivel(No no, int nivel)
    {
        if (no == null) return;

        if (nivel == 0)
        {
            System.out.print(no.valor + " ");
        }
        else
        {
            percorrerNivel(no.esquerdo, nivel - 1);
            percorrerNivel(no.direito, nivel - 1);
        }
    }



    
}
