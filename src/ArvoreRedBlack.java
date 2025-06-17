public class ArvoreRedBlack {
    private NoRedBlack raiz;

    public void inserirHelper (int valor)
    {
        inserir(valor);
    }

    private void inserir(int valor) {
        NoRedBlack no = new NoRedBlack(valor);

        NoRedBlack y = null;
        NoRedBlack x = raiz;

        while(x != null)
        {
            y = x;
            if(no.valor < x.valor) x = x.esquerdo;
            else x = x.direito;
        }

        no.pai = y;
        if(y == null) raiz = no;
        else if (no.valor< y.valor) y.esquerdo = no;
        else y.direito = no;

        no.esquerdo = null;
        no.direito = null;
        no.cor = Cor.vermelho;

        corrigirInsercao(no);
    }

    private void corrigirInsercao(NoRedBlack k) {
        while(k.pai != null && k.pai.cor == Cor.vermelho)
        {
            if (k.pai == k.pai.pai.esquerdo)
            {
                NoRedBlack u = k.pai.pai.direito;
                if(u.cor == Cor.vermelho)
                {
                    k.pai.cor = Cor.preto;
                    u.cor = Cor.preto;
                    k.pai.pai.cor = Cor.vermelho;
                    k = k.pai.pai;
                }
                else
                {
                    if (k == k.pai.direito)
                    {
                        k = k.pai;
                        rotacaoEsquerda(k);
                    }
                    k.pai.cor = Cor.preto;
                    k.pai.pai.cor = Cor.vermelho;
                    rotacaoDireita(k.pai.pai);
                }
            }
            else
            {
                NoRedBlack u = k.pai.pai.esquerdo;
                if (u.cor == Cor.vermelho)
                {
                    k.pai.cor = Cor.preto;
                    u.cor = Cor.preto;
                    k.pai.pai.cor = Cor.vermelho;
                    k = k.pai.pai;
                }
                else
                {
                    if (k == k.pai.esquerdo)
                    {
                        k = k.pai;
                        rotacaoDireita(k);
                    }
                    k.pai.cor = Cor.preto;
                    k.pai.pai.cor = Cor.vermelho;
                    rotacaoEsquerda(k.pai.pai);
                }
            }
            if (k == raiz) break;
        }
        raiz.cor = Cor.preto;
    }

    private void corrigirDelecao (NoRedBlack x)
    {
        NoRedBlack w;
        while (x != raiz && x.cor == Cor.preto)
        {
            if (x == x.pai.esquerdo)
            {
                w = x.pai.direito;

                if(w.cor == Cor.vermelho)
                {
                    w.cor = Cor.preto;
                    x.pai.cor = Cor.vermelho;
                    rotacaoEsquerda(x.pai);
                    w = x.pai.direito;
                }

                if (w.esquerdo.cor == Cor.preto && w.direito.cor == Cor.preto)
                {
                    w.cor = Cor.vermelho;
                    x = x.pai;
                }
                else
                {
                    if (w.direito.cor == Cor.preto)
                    {
                        w.esquerdo.cor = Cor.preto;
                        w.cor = Cor.vermelho;
                        rotacaoDireita(w);
                        w = x.pai.direito;
                    }

                    w.cor = x.pai.cor;
                    x.pai.cor = Cor.preto;
                    w.direito.cor = Cor.preto;
                    rotacaoEsquerda(x.pai);
                    x = raiz;
                }
            }
            else
            {
                w = x.pai.esquerdo;
                if (w.cor == Cor.vermelho)
                {
                    w.cor = Cor.preto;
                    x.pai.cor = Cor.vermelho;
                    rotacaoDireita(x.pai);
                    w = x.pai.esquerdo;
                }
                if(w.direito.cor == Cor.preto && w.esquerdo.cor == Cor.preto)
                {
                    w.cor = Cor.vermelho;
                    x = x.pai;
                }
                else
                {
                    if(w.esquerdo.cor == Cor.preto)
                    {
                        w.direito.cor = Cor.preto;
                        w.cor = Cor.vermelho;
                        rotacaoEsquerda(w);
                        w = x.pai.esquerdo;
                    }

                    w.cor = x.pai.cor;
                    x.pai.cor = Cor.preto;
                    w.esquerdo.cor = Cor.preto;
                    rotacaoDireita(x.pai);
                    x = raiz;
                }
            }
        }
        x.cor = Cor.preto;
    }

    private void transplant (NoRedBlack u, NoRedBlack v)
    {
        if (u.pai == null) raiz = v;
        else if ( u == u.pai.esquerdo) u.pai.esquerdo = v;
        else u.pai.direito = v;
        v.pai = u.pai;
    }

    private NoRedBlack minimo(NoRedBlack no)
    {
        while (no.esquerdo != null) no = no.esquerdo;
        return no;
    }

    private void rotacaoEsquerda(NoRedBlack x) {
        NoRedBlack y = x.direito;
        x.direito = y.esquerdo;
        if (y.esquerdo != null) y.esquerdo.pai = x;

        y.pai = x.pai;
        if (x.pai == null) raiz = y;
        else if (x == x.pai.esquerdo) x.pai.esquerdo = y;
        else x.pai.direito = y;

        y.esquerdo = x;
        x.pai = y;
    }

    public void delete (int valor)
    {
        NoRedBlack z = searchTree(raiz, valor);
        if (z == null) return;

        NoRedBlack y = z;
        Cor yOriginalColor = y.cor;
        NoRedBlack x;

        if (z.esquerdo == null)
        {
            x = z.direito;;
            transplant (z, z.direito);
        }
        else if (z.direito == null)
        {
            x = z.esquerdo;
            transplant(z, z.esquerdo);
        }
        else
        {
            y = minimo(z.direito);
            yOriginalColor = y.cor;
            x = y.direito;
            if(y.pai == z) x.pai = y;
            else
            {
                transplant(y, y.direito);
                y.direito = z.direito;
                y.direito.pai = y;
            }
            transplant(z, y);
            y.esquerdo = z.esquerdo;
            y.esquerdo.pai = y;
            y.cor = z.cor;

        }

        if (yOriginalColor == Cor.preto) corrigirDelecao(x);
    }

    private NoRedBlack searchTree (NoRedBlack no, int valor)
    {
        if (no == null || valor == no.valor) return no;
        if (valor < no.valor) return searchTree(no.esquerdo, valor);
        return searchTree(no.direito, valor);
    }

    public void emOrdem()
    {
        emOrdemHelper(raiz);
        System.out.println();
    }

    private void emOrdemHelper(NoRedBlack x)
    {
        if (x != null)
        {
            emOrdemHelper(x.esquerdo);
            String colorSuffix = (x.cor == Cor.vermelho) ? "R" : "B";
            System.out.println(x.valor + colorSuffix + " ");
            emOrdemHelper(x.direito);
        }
    }

    private void rotacaoDireita(NoRedBlack y) {
        NoRedBlack x = y.esquerdo;
        y.esquerdo = x.direito;
        if (x.direito != null) x.direito.pai = y;

        x.pai = y.pai;

        if (y.pai == null) raiz = x;
        else if (y == y.pai.direito) y.pai.direito = x;
        else y.pai.esquerdo = x;

        x.direito = y;
        y.pai = x;
    }

    private Cor cor(NoRedBlack no) {
        return (no == null) ? Cor.preto : no.cor;
    }
}
