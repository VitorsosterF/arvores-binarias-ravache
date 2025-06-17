public class ArvoreBST
{
    //criação do nó raiz
    No raiz;

    //construtor da árvore
    public ArvoreBST()
    {
        raiz = null;
    }

    //método auxiliar para facilitar implementação
    public void inserir (int valor)
    {
        raiz = inserirRec(raiz, valor);
    }

    private No inserirRec(No no, int valor)
    {
        //verifica se o nó em questão está vazio, e se estiver cria o novo nó
        if (no == null)
        {
            return new No(valor);
        }

        /*
        verifica se o valor a ser inserido é menor ou maior do que o que já existe
        para assim saber se o novo nó vai para a subárvore à esquerda ou à direita
        do nó atual
        */
        if (valor < no.valor)
        {
            no.esquerdo = inserirRec(no.esquerdo, valor);
        }
        else if (valor > no.valor)
        {
            no.direito = inserirRec(no.direito, valor);
        }

        //caso ele não seja maior nem maior ele retorna o nó pois árvore binárias não aceitam valores duplicados
        return no;
    }

}
