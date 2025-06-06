public class Main {
    public static void main(String[] args) {
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
        arvore.preOrdemRecursivo(arvore.raiz);
        arvore.preOrdemNaoRecursivo();
        System.out.println("\nPercorrendo em ordem:");
        arvore.emOrdemRecursivo(arvore.raiz);
        arvore.emOrdemNaoRecursivo();
        System.out.println("\nPercorrendo pós-ordem:");
        arvore.preOrdemRecursivo(arvore.raiz);
        arvore.preOrdemNaoRecursivo();
        System.out.println("\nContando os nós folha:");
        System.out.println(arvore.contarFolhasRecursivo(arvore.raiz));
        System.out.println(arvore.contarFolhasNaoRecursivo());

        ArvoreAVL arvoreavl = new ArvoreAVL();

        System.out.println("Inserindo elementos...");
        arvoreavl.inserir(30);
        arvoreavl.inserir(20);
        arvoreavl.inserir(40);
        arvoreavl.inserir(10);
        arvoreavl.inserir(25);
        arvoreavl.inserir(50);
        arvoreavl.inserir(5);

        System.out.println("\nÁrvore em ordem (in-order):");
        arvoreavl.imprimir();

        System.out.println("\nRemovendo elemento 10...");
        arvoreavl.remover(10);

        System.out.println("Removendo elemento 30...");
        arvoreavl.remover(30);

        System.out.println("\nÁrvore após remoções:");
        arvoreavl.imprimir();
    }
}
