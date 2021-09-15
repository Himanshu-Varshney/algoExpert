package algoexpert.io.linkedlist;

public class RemoveDuplicates {

    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public LinkedList removeDuplicatesFromLinkedList(LinkedList linkedList) {

        //IMP: store in different variable so as not to modify the original variable.
        //Otherwise that will become null while coming out of loop
        LinkedList currentNode = linkedList;

        while (currentNode != null){
            //Assume next node is distinct.
            LinkedList nextDistinctNode = currentNode.next;
            while (nextDistinctNode!= null && currentNode.value == nextDistinctNode.value){
                nextDistinctNode = nextDistinctNode.next;
            }
            //finally here it will point to nextDistinctnode
            currentNode.next=nextDistinctNode;
            currentNode=nextDistinctNode;
        }

        return linkedList;
    }
}
