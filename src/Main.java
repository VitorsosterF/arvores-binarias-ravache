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
        System.out.println("Percorrendo pré-ordem:");
        arvore.preOrdemRecursivo(arvore.raiz);
        arvore.preOrdemNaoRecursivo();

    }
}
