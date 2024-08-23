package DS;

import java.sql.Timestamp;

public class LinkedListPrac<T> {
    public class Node {
        public T val;
        public Node next;

        public Node(T val) {
            this.val = val;
        }
    }

    public Node head = null;

    public void addFirst(T x) {
        Node n1 = new Node(x);
        if (head == null) {
            head = n1;
        } else {
            n1.next = head;
            head = n1;
        }
    }

    public void viewAll() {
    }

    public void viewSent(String user) {
    }

    public void viewReciv(String user) {
    }

    public void searchByType(String type) {
    }

    public void searchToUser(String user) {
    }

    public void searchMaxAmnt(double x) {
    }

    public void searchMinAmnt(double x) {
    }

    public void searchXAmnt(double x) {
    }

    public void showBefore(Timestamp t) {
    }

    public void showAfter(Timestamp t) {
    }

    public void showOn(Timestamp t) {
    }

    public void display() {
        Node temp = head;
        if (head == null) {
            System.out.print("list is empty");
        }
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}
