public class NoRedBlack
{
    int valor;
    Cor cor;
    NoRedBlack esquerdo, direito, pai;

    public NoRedBlack(int valor, Cor cor)
    {
        this.valor = valor;
        this.cor = cor;
    }
}

enum Cor {
    preto, vermelho;
}
