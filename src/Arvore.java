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

    private int contarNosRecursivo(No no)
    {
        if (no == null)
        {
            return 0;
        }

        return 1 + contarNosRecursivo(no.esquerdo) + contarNosRecursivo(no.direito);
    }



}
