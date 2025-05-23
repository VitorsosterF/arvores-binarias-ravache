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

    public void preOrdemRecursivo(No no)
    {
        if (no == null) return;

        System.out.println(no);
        preOrdemRecursivo(no.esquerdo);
        preOrdemRecursivo(no.direito);

    };

    public void preOrdemNaoRecursivo (No no)
    {
        if (no == null) return;

        while (no.esquerdo != null)
        {
            System.out.println(no);
        };
    };

    public void emOrdemRecursivo (No no)
    {
        if (no == null) return;

        preOrdemRecursivo(no.esquerdo);
        System.out.println(no);
        preOrdemRecursivo(no.direito);
    };

    public void posOrdemRecursivo (No no)
    {
        if (no == null) return;

        posOrdemRecursivo(no.esquerdo);
        posOrdemRecursivo(no.direito);
        System.out.println(no);
    };

    public void emNivelRecursivo ()
    {
        int altura = altura(raiz);

        for (int i = 0; i < altura; i++)
        {
            percorrerNivel(raiz, i);
        }



    };

    private void percorrerNivel(No no, int nivel)
    {
        if (no == null) return;

        if (nivel == 0)
        {
            System.out.println(no.valor + " ");
        }
        else
        {
            percorrerNivel(no.esquerdo, nivel - 1);
            percorrerNivel(no.direito, nivel - 1);
        }
    }

    
}
