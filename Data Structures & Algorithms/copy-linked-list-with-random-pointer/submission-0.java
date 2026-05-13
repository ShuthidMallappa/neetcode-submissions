/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null){
            return null;
        }

        Node current = head;
        while(current != null){
            Node newNode = new Node(current.val);
            newNode.next=current.next;
            current.next=newNode;
            current = newNode.next;
        }

        Node curr = head;
        while( curr != null){
            if(curr.random != null){
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        Node currentNode = head;
        Node newHead = head.next;
        Node newCurrent = newHead;
        while(currentNode != null){
            currentNode.next = newCurrent.next;
            currentNode = currentNode.next;
            if(currentNode != null){
                newCurrent.next = currentNode.next;
                newCurrent = newCurrent.next;
            }
        }
        return newHead;
    }
}
