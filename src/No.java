//classe que representa um nó da árvore
public class No
{
    //definição das variáveis relacionadas ao nó
    int valor;
    No esquerdo, direito;

    //construtor do nó, função para definir um novo nó
    public No(int item)
    {
        valor = item;
        esquerdo = direito = null;
    }

    //função que retorna verdadeiro caso um nó seja um nó folha
    public boolean ehfolha()
    {
        return esquerdo == null & direito == null;
    }

}
