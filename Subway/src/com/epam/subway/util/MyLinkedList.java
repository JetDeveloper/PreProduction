/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.subway.util;

/**
 * Own realization of linked list
 *
 * @author Dmytro_Svynarenko
 */
public class MyLinkedList<T> {

    private Node firstNode;
    private Node lastNode;
    private int length;

    /**
     * Inner class for each element
     */
    private class Node {

        private Node previous;
        private Node next;
        private T element;

        public Node(Node previous, Node next, T element) {
            this.previous = previous;
            this.next = next;
            this.element = element;
        }

        public Node getPrevious() {
            return previous;
        }

        public void setPrevious(Node previous) {
            this.previous = previous;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public T getElement() {
            return element;
        }

        public void setElement(T element) {
            this.element = element;
        }
    }

    public MyLinkedList() {
        firstNode = lastNode = null;
        length = 0;
    }

    private void addFirst(T element) {
        if(length==0) {
            firstNode = lastNode = new Node(lastNode, null, element);
        } else {
            firstNode = new Node(null, firstNode, element);
        }
        length++;
    }

    public void add(T element) {
        if (length == 0) {
            addFirst(element);
        } else {
            lastNode.setNext(new Node(lastNode, null, element));
            lastNode = lastNode.getNext();
            length++;
        }
    }

    public void add(T element, int pos) {
        if (pos < 0 || pos > length) {
            throw new IllegalArgumentException("pos may be in [0,length] range");
        }
        if (pos == 0) {
            addFirst(element);
        } else if (pos == length) {
            add(element);
        } else {
            Node current;
            if (!closerFromLeft(pos)) {
                current = lastNode;
                for (int i = 0; i < length - pos - 1; i++) {
                    current = current.getPrevious();
                }
                
            } else {
                current = firstNode;
                for (int i = 0; i < pos; i++) {
                    current = current.getNext();
                }
                
            }
            Node tempNode = new Node(current, current.getNext(), element);
            current.setNext(tempNode);
            length++;
        }
    }

    private boolean closerFromLeft(int pos) {
        return (pos < length - pos);
    }


    public T get(int pos) {
        if (pos < 0 || pos >= length) {
            throw new IllegalArgumentException("pos may be in [0,length) range");
        }
        Node current;
        if (!closerFromLeft(pos)) {
            current = lastNode;
            for (int i = 0; i < length - pos; i++) {
                current = current.getPrevious();
            }
        } else {
            current = firstNode;
            for (int i = 0; i < pos; i++) {
                current = current.getNext();
            }
        }
        return current.getElement();
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append("MyLinkedList{");
        for (int i = 0; i < length; i++) {
            output.append(get(i));
            if (i != length - 1) {
                output.append(", ");
            }
        }
        output.append("}");
        return output.toString();
    }
}