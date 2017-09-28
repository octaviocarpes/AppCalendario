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
    }

    public void add(E element){
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

    public void setPointer(E element){
        pointer = head;
        while(pointer.element != element){
            pointer = pointer.next;
        }
    }

    public E getNext(){
        pointer = pointer.next;
        return pointer.element;
    }

    public int size(){
        return size;
    }


    public String toString() {

        System.out.println("LoopingLinkedList:\n\n" + head.element + "\n");
        pointer = head.next;
        while(!pointer.isInitial()){
            System.out.println(pointer.element + "\n");
            pointer = pointer.next;
        }
        return null;
    }
}
