public class No
{
    int valor;
    No esquerdo, direito;

    public No(int item)
    {
        valor = item;
        esquerdo = direito = null;
    }

    public int contarNos(No raiz)
    {
        if (raiz == null)
        {
            return 0;
        }

        return 1 + contarNos(esquerdo) + contarNos(direito);
    }


}
