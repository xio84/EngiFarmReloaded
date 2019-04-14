package linkedlist;

public class LinkedList<T> {
    Part head; // head of list

    // Linked list Part.
    // This inner class is made static
    // so that main() can access it
    class Part {

        T data;
        Part next;

        // Constructor
        Part(T d)
        {
            data = d;
            next = null;
        }
    }

    // Method to insert a new node
    public LinkedList insert(LinkedList list, T data)
    {
        // Create a new node with given data
        Part new_part = new Part(data);
        new_part.next = null;

        // If the Linked List is empty,
        // then make the new node as head
        if (list.head == null) {
            list.head = new_part;
        }
        else {
            // Else traverse till the last node
            // and insert the new_part there
            Part last = list.head;
            while (last.next != null) {
                last = last.next;
            }

            // Insert the new_part at last node
            last.next = new_part;
        }

        // Return the list by head
        return list;
    }

    // Method to print the LinkedList.
    public void printList(LinkedList list)
    {
        Part currPart = list.head;

        System.out.print("LinkedList: ");

        // Traverse through the LinkedList
        while (currPart != null) {
            // Print the data at current node
            System.out.print(currPart.data + " ");

            // Go to next node
            currPart = currPart.next;
        }

        System.out.println();
    }

    // **************DELETION BY INDEX**************

    // **************MAIN METHOD**************

    // method to create a Singly linked list with n nodes
    public static void main(String[] args)
    {
        /* Start with the empty list. */
//        LinkedList list = new LinkedList();
//
//        //
//        // ******INSERTION******
//        //
//
//        // Insert the values
//        list = insert(list, 1);
//        list = insert(list, 2);
//        list = insert(list, 3);
//        list = insert(list, 4);
//        list = insert(list, 5);
//        list = insert(list, 6);
//        list = insert(list, 7);
//        list = insert(list, 8);
//
//        // Print the LinkedList
//        printList(list);
//
//        //
//        // ******DELETION BY KEY******
//        //
//
//        // Delete node with value 1
//        // In this case the key is ***at head***
//        deleteByKey(list, 1);
//
//        // Print the LinkedList
//        printList(list);
//
//        // Delete node with value 4
//        // In this case the key is present ***in the middle***
//        deleteByKey(list, 4);
//
//        // Print the LinkedList
//        printList(list);
//
//        // Delete node with value 10
//        // In this case the key is ***not present***
//        deleteByKey(list, 10);
//
//        // Print the LinkedList
//        printList(list);
    }
}
