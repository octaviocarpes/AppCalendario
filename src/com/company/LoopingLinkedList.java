package com.company;

public class LoopingLinkedList<E> {

    private class Node{
        E element;
        private Node next;
        boolean initial = false;

        public Node(E element){
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

    public LoopingLinkedList() {
        size = 0;
        head = new Node(null);
        head.setInitial();
        pointer = new Node(null);
    }

    public void add(E element){
        if (head.element == null){
            head.element = element;
            head.next = pointer;
            pointer = head;
            size++;
        }

        if (size == 1){
            Node aux = new Node(element);
            head.next = aux;
            pointer = head.next;
            pointer.next = head;
            size++;
        }
        Node aux = new Node(element);
        
    }

    public void setPointer(E element){
        pointer = head;
        while(pointer.element != element){
            pointer = pointer.next;
        }
    }
}
