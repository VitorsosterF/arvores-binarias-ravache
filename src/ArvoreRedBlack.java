public class ArvoreRedBlack {
    private NoRedBlack raiz;

    public void inserir(int valor) {
        NoRedBlack novo = new NoRedBlack(valor, Cor.vermelho);
        raiz = inserir(raiz, novo);
        corrigirInsercao(novo);
    }

    private NoRedBlack inserir(NoRedBlack atual, NoRedBlack novo) {
        if (atual == null) {
            return novo;
        }

        if (novo.valor < atual.valor) {
            atual.esquerdo = inserir(atual.esquerdo, novo);
            atual.esquerdo.pai = atual;
        } else if (novo.valor > atual.valor) {
            atual.direito = inserir(atual.direito, novo);
            atual.direito.pai = atual;
        }

        return atual;
    }

    private void corrigirInsercao(NoRedBlack no) {
        while (no != raiz && cor(no.pai) == Cor.vermelho) {
            NoRedBlack pai = no.pai;
            NoRedBlack avo = pai.pai;

            if (pai == avo.esquerdo) {
                NoRedBlack tio = avo.direito;
                if (cor(tio) == Cor.vermelho) {
                    pai.cor = Cor.preto;
                    tio.cor = Cor.preto;
                    avo.cor = Cor.vermelho;
                    no = avo;
                } else {
                    if (no == pai.direito) {
                        no = pai;
                        rotacaoEsquerda(no);
                    }
                    pai.cor = Cor.preto;
                    avo.cor = Cor.vermelho;
                    rotacaoDireita(avo);
                }
            } else {
                NoRedBlack tio = avo.esquerdo;
                if (cor(tio) == Cor.vermelho) {
                    pai.cor = Cor.preto;
                    tio.cor = Cor.preto;
                    avo.cor = Cor.vermelho;
                    no = avo;
                } else {
                    if (no == pai.esquerdo) {
                        no = pai;
                        rotacaoDireita(no);
                    }
                    pai.cor = Cor.preto;
                    avo.cor = Cor.vermelho;
                    rotacaoEsquerda(avo);
                }
            }
        }

        raiz.cor = Cor.preto;
    }

    private void rotacaoEsquerda(NoRedBlack x) {
        NoRedBlack y = x.direito;
        x.direito = y.esquerdo;
        if (y.esquerdo != null)
            y.esquerdo.pai = x;

        y.pai = x.pai;

        if (x.pai == null)
            raiz = y;
        else if (x == x.pai.esquerdo)
            x.pai.esquerdo = y;
        else
            x.pai.direito = y;

        y.esquerdo = x;
        x.pai = y;
    }

    private void rotacaoDireita(NoRedBlack x) {
        NoRedBlack y = x.esquerdo;
        x.esquerdo = y.direito;
        if (y.direito != null)
            y.direito.pai = x;

        y.pai = x.pai;

        if (x.pai == null)
            raiz = y;
        else if (x == x.pai.direito)
            x.pai.direito = y;
        else
            x.pai.esquerdo = y;

        y.direito = x;
        x.pai = y;
    }

    private Cor cor(NoRedBlack no) {
        return (no == null) ? Cor.preto : no.cor;
    }
}
