public class NoRedBlack
{
    int valor;
    Cor cor;
    NoRedBlack esquerdo, direito, pai;

    public NoRedBlack(int valor)
    {
        this.valor = valor;
        this.cor = cor;
        this.esquerdo = null;
        this.direito = null;
        this.pai = null;
    }
}

enum Cor {
    preto, vermelho;
}
