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

    public int getLength() {
        return length;
    }

    /**
     * Insert first element
     *
     * @param element element to insert
     */
    public void addFirst(T element) {
        if (length == 0) {
            firstNode = lastNode = new Node(lastNode, null, element);
        } else {
            firstNode = new Node(null, firstNode, element);
        }
        length++;
    }

    /**
     * Add last element to list
     *
     * @param element element to add
     */
    public void addLast(T element) {
        if (length == 0) {
            addFirst(element);
        } else {
            lastNode.setNext(new Node(lastNode, null, element));
            lastNode = lastNode.getNext();
            length++;
        }
    }

    /**
     * Add element to position
     *
     * @param element element to add
     * @param pos position of element
     */
    public void add(T element, int pos) {
        if (pos < 0 || pos > length) {
            throw new IllegalArgumentException("pos may be in [0,length] range");
        }
        if (pos == 0) {
            addFirst(element);
        } else if (pos == length) {
            addLast(element);
        } else {
            Node current;
            if (!closerFromLeft(pos)) {
                current = lastNode;
                for (int i = 0; i < length - pos; i++) {
                    current = current.getPrevious();
                }

            } else {
                current = firstNode;
                for (int i = 0; i < pos - 1; i++) {
                    current = current.getNext();
                }

            }
            Node tempNode = new Node(current, current.getNext(), element);
            current.setNext(tempNode);
            tempNode.getNext().setPrevious(tempNode);

            length++;
        }
    }

    /**
     * Check direction to move in list by closest distance to current position
     *
     * @param pos position
     * @return true - direction left->right, false - right->left
     */
    private boolean closerFromLeft(int pos) {
        return (pos < length - pos);
    }

    /**
     * Get element on position
     *
     * @param pos position of element
     * @return element
     */
    public T get(int pos) {
        if (pos < 0 || pos >= length) {
            throw new IllegalArgumentException("pos may be in [0,length) range");
        }
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
        return current.getElement();
    }

    /**
     * Delete first element
     */
    private void deleteFirst() {
        firstNode.element = null;
        firstNode = firstNode.getNext();
        length--;
    }

    /**
     * Delete last element
     */
    private void deleteLast() {
        lastNode.element = null;
        lastNode = lastNode.getPrevious();
        length--;
    }

    /**
     * Delete element on position
     *
     * @param pos position
     */
    public void delete(int pos) {
        if (pos < 0 || pos >= length) {
            throw new IllegalArgumentException("pos may be in [0,length) range");
        }
        if (pos == 0) {
            deleteFirst();
        } else if (pos == length - 1) {
            deleteLast();
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
            current.getPrevious().setNext(current.getNext());
            length--;
        }
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