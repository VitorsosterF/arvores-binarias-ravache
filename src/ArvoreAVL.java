public class ArvoreAVL
{
    public NoAVL raiz;

    public void inserir(int valor)
    {
        raiz = inserir (raiz, valor);
    }

    public void remover (int valor)
    {
        remover (raiz, valor);
    }

    public NoAVL inserir (NoAVL no, int valor)
    {
        if (no == null) return new NoAVL(valor);

        if (valor < no.valor)
        {
            no.esquerdo = inserir (no.esquerdo, valor);
        }
        else if (valor > no.valor)
        {
            no.direito = inserir(no.direito, valor);
        }
        else
        {
            return no;
        }

        no.altura = 1 + Math.max(altura(no.esquerdo), altura(no.direito));

        int balanceamento = fatorBalanceamento(no);

        if (balanceamento > 1 && valor < no.esquerdo.valor) return rotacaoDireita(no);

        if (balanceamento < -1 && valor > no.direito.valor) return rotacaoEsquerda(no);

        if (balanceamento > 1 && valor > no.esquerdo.valor)
        {
            no.esquerdo = rotacaoEsquerda(no.esquerdo);
            return rotacaoDireita(no);
        }
        if (balanceamento < -1 && valor < no.direito.valor)
        {
            no.direito = rotacaoDireita(no.direito);
            return rotacaoEsquerda(no);
        }

        return no;
    }

    private NoAVL remover(NoAVL no, int valor)
    {
        if (no == null) return null;

        if (valor < no.valor)
        {
            no.esquerdo = remover(no.esquerdo, valor);
        }
        else if (valor > no.valor)
        {
            no.direito = remover(no.direito, valor);
        }
        else {
            if (no.esquerdo == null || no.direito == null)
            {
                NoAVL temp = (no.esquerdo != null) ? no.esquerdo: no.direito;
                if (temp == null)
                {
                    temp = no;
                    no = null;
                }
                else
                {
                    no = temp;
                }
            }
            else
            {
                NoAVL sucessor = menorValor(no.direito);
                no.valor = sucessor.valor;
                no.direito = remover (no.direito, sucessor.valor);
            }
        }

        if (no == null) return null;

        no.altura = 1 + Math.max(altura(no.esquerdo), altura(no.direito));

        int balanceamento = fatorBalanceamento(no);

        if (balanceamento > 1 && fatorBalanceamento(no.esquerdo) >= 0)
            return rotacaoDireita(no);
        if (balanceamento > 1 && fatorBalanceamento(no.esquerdo) < 0) {
            no.esquerdo = rotacaoEsquerda(no.esquerdo);
            return rotacaoDireita(no);
        }
        if (balanceamento < -1 && fatorBalanceamento(no.direito) <= 0)
            return rotacaoEsquerda(no);
        if (balanceamento < -1 && fatorBalanceamento(no.direito) > 0) {
            no.direito = rotacaoDireita(no.direito);
            return rotacaoEsquerda(no);
        }

        return no;
    }

    private NoAVL menorValor (NoAVL no)
    {
        NoAVL atual = no;
        while(atual.esquerdo != null)
        {
            atual = atual.esquerdo;
        }

        return atual;
    }

    private NoAVL rotacaoDireita(NoAVL y)
    {
        NoAVL x = y.esquerdo;
        NoAVL t2 = x.direito;

        x.direito = y;
        y.esquerdo = t2;

        y.altura = Math.max(altura(y.esquerdo), altura(y.direito)) + 1;
        x.altura = Math.max(altura(x.esquerdo), altura(x.direito)) + 1;

        return x;
    };

    private NoAVL rotacaoEsquerda(NoAVL x) {
        NoAVL y = x.direito;
        NoAVL t2 = y.esquerdo;

        y.esquerdo = x;
        x.direito = t2;

        x.altura = Math.max(altura(x.esquerdo), altura(x.direito)) + 1;
        y.altura = Math.max(altura(y.esquerdo), altura(y.direito)) + 1;

        return y;
    }

    private int altura(NoAVL no)
    {
        return (no == null) ? 0 : no.altura;
    }

    private int fatorBalanceamento(NoAVL no)
    {
        return(no == null) ? 0 : altura(no.esquerdo) - altura(no.direito);
    }

    public void imprimir() {
        imprimirEmOrdem(raiz);
        System.out.println();
    }

    private void imprimirEmOrdem(NoAVL no) {
        if (no != null) {
            imprimirEmOrdem(no.esquerdo);
            System.out.print(no.valor + " ");
            imprimirEmOrdem(no.direito);
        }
    }



}
