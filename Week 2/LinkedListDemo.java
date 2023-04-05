// 1.2 Program to Implement LinkedList
// Need to implement custom linkedList !

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        next = null;
    }
}

class LinkedList {
    Node head;

    public LinkedList() {
        head = null;
    }

    public void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public void delete(int data) {
        if (head == null) {
            return;
        }

        if (head.data == data) {
            head = head.next;
            return;
        }

        Node current = head;
        Node previous = null;

        while (current != null && current.data != data) {
            previous = current;
            current = current.next;
        }

        if (current == null) {
            System.out.println("Node not found.");
            return;
        }

        previous.next = current.next;
    }

    public void display() {
        if (head == null) {
            System.out.println("Linked list is empty.");
        } else {
            Node current = head;
            while (current != null) {
                System.out.print(current.data + " ");
                current = current.next;
            }
            System.out.println("null");
        }
    }
}

public class LinkedListDemo {
    public static void main(String[] args) {
        /*LinkedList<String> list = new LinkedList<>();
        list.add("Criket");
        list.add("Hockey");
        list.add(1,"Football");
        System.out.println(list);
        if(list.contains("Football")){
            int x = list.indexOf("Football");
            list.set(x,"Volleyball");
            System.out.println(list);
            list.remove(x);
        }
        System.out.println(list);*/

        LinkedList linkedList = new LinkedList();


        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.display();

        linkedList.delete(2);
        System.out.println("Linked List after deletion:");
        linkedList.display();
    }
}
