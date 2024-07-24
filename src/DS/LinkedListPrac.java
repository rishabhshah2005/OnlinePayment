package DS;

class List<T> {
    class Node {
        T val;
        Node next;

        public Node(T val) {
            this.val = val;
        }
    }

    Node head = null;

    public void addFirst(T x) {
        Node n1 = new Node(x);
        if (head == null) {
            head = n1;
        } else {
            n1.next = head;
            head = n1;
        }
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

    public void addLast(T x) {
        Node nxt = head;
        Node n1 = new Node(x);
        if (head == null) {
            head = n1;
        } else {

            while (nxt.next != null) {
                nxt = nxt.next;
            }
            nxt.next = n1;
        }
    }

    public void deleteFirst() {
        if (head == null) {
            System.out.println("list is empty");
        } else {
            Node temp = head;
            head = head.next;
            temp.next = null;
        }
    }

    public void deleteLast() {
        if (head == null) {
            System.out.println("list is empty");
        } else {
            Node nxt = head;
            Node prv = null;
            while (nxt.next != null) {
                prv = nxt;
                nxt = nxt.next;
            }
            if (prv == null) {
                head = null;
            } else {
                prv.next = null;
            }

        }
    }

    public void addBefore(T val, T n) {
        Node n1 = new Node(n);
        Node nxt = head;
        Node prv = null;
        if (head == null) {
            System.out.println("list empty");
        }

        else {

            while (nxt != null) {
                if (nxt.val == val) {
                    if (prv == null) {
                        n1.next = head;
                        head = n1;
                        break;
                    } else {
                        n1.next = nxt;
                        prv.next = n1;
                        break;
                    }
                } else {
                    prv = nxt;
                    nxt = nxt.next;
                }
            }
        }
    }

    public void addAfter(T val, T n) {
        Node n1 = new Node(n);
        Node nxt = head;
        if (head == null) {
            System.out.println("List empty");
        } else {

            while (nxt != null) {
                if (nxt.val == val) {
                    Node temp = nxt.next;
                    n1.next = temp;
                    nxt.next = n1;
                    break;
                } else {
                    nxt = nxt.next;
                }
            }
        }
    }

    public void delete(T val) {
        if (head == null) {
            System.out.println("list is empty");
        } else {
            Node nxt = head;
            Node prv = null;
            while (nxt != null) {
                if (nxt.val == val) {
                    if (prv == null) {
                        head = nxt.next;
                        nxt.next = null;
                        break;
                    } else {
                        prv.next = nxt.next;
                        nxt.next = null;
                        break;
                    }
                } else {
                    prv = nxt;
                    nxt = nxt.next;
                }
            }
        }
    }

    private void rev(Node h) {
        if (h == null) {

        } else {
            rev(h.next);
            System.out.print(h.val + " ");
        }
    }

    public void printRev() {
        Node temp = head;
        rev(temp);
        System.out.println();
    }

}

public class LinkedListPrac {
    public static void main(String[] args) {
        
    }
}
