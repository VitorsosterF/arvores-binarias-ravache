public class Arvore
{
    No raiz;

    public Arvore()
    {
        raiz = null;
    }

    public int contarNos()
    {
        return contarNosRecursivo(raiz);
    };

    public void preOrdem()
    {
        preOrdemRecursivo(raiz);
    }

    private int contarNosRecursivo(No no)
    {
        if (no == null)
        {
            return 0;
        }

        return 1 + contarNosRecursivo(no.esquerdo) + contarNosRecursivo(no.direito);
    }

    private void preOrdemRecursivo(No no)
    {
        if (no == null)
        {
            return;
        }

        System.out.println(no);
        preOrdemRecursivo(no.esquerdo);
        preOrdemRecursivo(no.direito);

    }

    private void emOrdemRecursivo (No no)
    {
        if (no == null)
        {
            return;
        }

        preOrdemRecursivo(no.esquerdo);
        System.out.println(no);
        preOrdemRecursivo(no.direito);
    }





}
