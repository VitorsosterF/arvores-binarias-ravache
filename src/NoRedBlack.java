public class NoRedBlack
{
    int valor, altura;
    Cor cor;
    NoAVL esquerdo, direito;

    public NoRedBlack(int valor)
    {
        this.valor = valor;
        altura = 1;
    }
}

enum Cor {
    preto, vermelho;
}
