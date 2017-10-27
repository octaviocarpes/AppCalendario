package helpers;

/**
 * Classe Auxiliar para montar os dias dos anos
 * Lista Encadeada feita com Singleton
 * @param <String>
 */

public class LoopingLinkedList<String> {


    /**
     * Classe auxiliar para ajuda na construção do TAD
     */
    private class Node{
        String element;
        private Node next;
        boolean initial = false;

        public Node(String element){
            this.element = element;
        }

        public void setInitial(){
            this.initial = true;
        }

        public boolean isInitial(){
            return initial;
        }
    }

    private Node head;
    private Node pointer;
    private int size;
    private static LoopingLinkedList lista;
    
    private LoopingLinkedList() {
        size = 0;
    }

    public static LoopingLinkedList getInstance(){
        if (lista == null){
            lista = new LoopingLinkedList();
        }
        return lista;
    }

    /**
     * Esta função adiciona um elemento na lista.
     * Todos os elementos são inseridos no final da lista.
     * @param element
     */
    public void add(String element){
        if (head == null){
            head = new Node(element);
            head.setInitial();
            head.next = head;
            pointer = head;
            size++;
            return;
        }

        if (size == 1){
            Node aux = new Node(element);
            head.next = null;
            head.next = aux;
            pointer = head.next;
            pointer.next = head;
            size++;
            return;
        }
        Node aux = new Node(element);
        pointer.next = aux;
        pointer = aux;
        pointer.next = head;
        size++;
    }


    /**
     * Modifica o Pointer para apontar para o elemento designado.
     * @param element
     */
    public void setPointer(String element){
        pointer = head;
        while(pointer.element != element){
            pointer = pointer.next;
        }
    }

    /**
     * Retorna o elemento atual da lista.
     * @return
     */
    public String get(){
        return pointer.element;
    }

    /**
     * Retorna o próximo elemento da lista.
     * @return
     */
    public String getNext(){
        pointer = pointer.next;
        return pointer.element;
    }


    /**
     * Retorna o tamanho da lista.
     * @return
     */
    public int size(){
        return size;
    }

    public boolean isEmpty(){
        if(size == 0)return  true;
        return false;
    }


    public java.lang.String toString() {

        System.out.println("LoopingLinkedList:\n\n" + head.element + "\n");
        pointer = head.next;
        while(!pointer.isInitial()){
            System.out.println(pointer.element + "\n");
            pointer = pointer.next;
        }
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LoopingLinkedList<?> that = (LoopingLinkedList<?>) o;

        if (size != that.size) return false;
        if (head != null ? !head.equals(that.head) : that.head != null) return false;
        return pointer != null ? pointer.equals(that.pointer) : that.pointer == null;
    }

    @Override
    public int hashCode() {
        int result = head != null ? head.hashCode() : 0;
        result = 31 * result + (pointer != null ? pointer.hashCode() : 0);
        result = 31 * result + size;
        return result;
    }
}
