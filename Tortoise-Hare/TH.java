
import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int data2) {
        this.data = data2;
        this.next = null;
    }
}

public class TH {

    // To detect the Loop and return the Starting point of the Loop
    private static Node detectCycle(Node head) {

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            // Loop Detected
            if (slow == fast) {
                slow = head;

                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }

                // Start of the Loop
                return slow;
            }
        }
        // No Loop Detected
        return null;
    }

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        // Creating a Loop
        head.next.next.next.next = head.next;

        Node loopStart = detectCycle(head);

        if (loopStart != null) {
            System.out.println("Loop detected at node with value: " + loopStart.data);
        } else {
            System.out.println("No loop detected.");
        }

        sc.close();

    }

}
