public class Main {
    public static void main(String[] args) {
        //criação da árvore e definição de valores
        No raiz = new No(10);
        raiz.esquerdo = new No(1);
        raiz.direito = new No(12);

        //isso retornará falso
        System.out.println("Raiz é folha: " + raiz.ehfolha());

        //já isso retornará verdadeiro
        System.out.println("Filho esquerdo é folha: ");

        Arvore arvore = new Arvore();
        arvore.raiz = new No(1);
        arvore.raiz.esquerdo = new No(2);
        arvore.raiz.direito = new No(3);
        arvore.raiz.esquerdo.esquerdo = new No(4);
        arvore.raiz.esquerdo.direito = new No(5);
        arvore.raiz.direito.direito = new No(6);

        System.out.println("Percorrendo por nível:");
        arvore.emNivelRecursivo();
        System.out.println("\nPercorrendo pré-ordem:");
        arvore.preOrdemNaoRecursivo();
        System.out.println("\nPercorrendo em ordem:");
        arvore.emOrdemNaoRecursivo();
        System.out.println("\nPercorrendo pós-ordem:");
        arvore.preOrdemNaoRecursivo();
        System.out.println("\nContando os nós folha:");
        System.out.println(arvore.contarFolhasRecursivo(arvore.raiz));
        System.out.println(arvore.contarFolhasNaoRecursivo());

        ArvoreAVL arvoreavl = new ArvoreAVL();
        System.out.println("Agora com a árvoreAVL");

        int[] chaves = {10, 20, 30, 40, 50, 25};

        System.out.println("Inserindo elementos...");
        for (int chave : chaves)
        {
            arvoreavl.raiz = arvoreavl.inserir(arvoreavl.raiz, chave);
        }

        System.out.println("\nÁrvore em ordem (in-order):");
        arvoreavl.imprimir();

        System.out.println("\nRemovendo elemento 10...");
        arvoreavl.remover(10);

        System.out.println("Removendo elemento 30...");
        arvoreavl.remover(30);

        System.out.println("\nÁrvore após remoções:");
        arvoreavl.imprimir();

        ArvoreRedBlack arvoreRB = new ArvoreRedBlack();

        int[] valores = {10, 20, 30, 15, 5, 25};
        for (int valor : valores)
        {
            arvoreRB.inserirHelper(valor);
        }

        System.out.println("Árvore após inserções (in-order): ");
        arvoreRB.emOrdem();

        arvoreRB.delete(10);
        arvoreRB.delete(10);

        System.out.println("Árvore após remoções: ");
        arvoreRB.emOrdem();
    }
}
