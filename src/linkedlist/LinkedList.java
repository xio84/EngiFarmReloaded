package linkedlist;

/**
 * Generic class LinkedList that implements a linked list.
 *
 * @author Oksidian Tafly
 * @since 2019-4-16
 * @version 1.1
 * @param <T> : Generic class
 */
public class LinkedList<T> {
    Part head; // head of list

    /**
     * Inner Class of LinkedList
     * that is the part of LinkedList.
     */
    class Part {

        T element;
        Part next;

        // Constructor
        Part(T d)
        {
            element = d;
            next = null;
        }
    }

    public LinkedList(Part head) {
        this.head = head;
    }

    public LinkedList(T element) {
        this.head = new Part(element);
    }

    public LinkedList() {
        head = null;
    }

    /**
     * Method to print LinkedList content.
     */
    public void printList()
    {
        Part currPart = head;

        System.out.print("LinkedList: ");

        // Traverse through the LinkedList
        while (currPart != null) {
            // Print the element at current node
            try {
                System.out.print(currPart.element + " ");
            } catch (Exception e) {
                e.printStackTrace();
            }

            // Go to next node
            currPart = currPart.next;
        }

        System.out.println();
    }

    /**
     * LinkedList getter.
     * @param index : index to get the element.
     * @return : element in generic class T.
     * @throws NullPointerException if index is out of bounds or there is no element
     * in index {@code element == null}, or LinkedList is empty.
     */
    public T get(int index) throws NullPointerException{
        Part currPart = head;

        if (head != null) {
            while(index > 0){
                if (currPart.next != null) {
                    index--;
                    currPart = currPart.next;
                }
                else{
                    throw new NullPointerException("Out of bounds");
                }
            }
            if (currPart.element == null){
                throw new NullPointerException("null element");
            }
            else{
                return currPart.element;
            }
        }
        else {
            throw new NullPointerException("Empty List");
        }
    }

    /**
     * <h1>LinkedList Setter.</h1>
     * @param _data : element input (in generic T class)
     * @param index : index of list to be set.
     * @throws NullPointerException if index is out of bounds or list is empty.
     */
    public void set(T _data, int index) throws NullPointerException{
        Part currPart = head;

        if (head != null) {
            while(index > 0){
                if (currPart.next != null) {
                    index--;
                    currPart = currPart.next;
                }
                else{
                    throw new NullPointerException("Out of bounds");
                }
            }
            currPart.element = _data;
        }
        else {
            throw new NullPointerException("Empty List");
        }
    }

    /**
     * LinkedList Element Finder.
     * @param _element : Element to be found.
     * @return : index of found element.
     */
    public int find(T _element){
        Part currPart = head;
        int i=0;

        if (head != null) {
            while(currPart.next != null && currPart.element !=_element){
                i++;
                currPart = currPart.next;
            }
            if(currPart.element ==_element){
                return i;
            }
            else{
                return -1;
            }
        }
        else {
            return -1;
        }
    }

    /**
     * Method to insert element.
     * @param _element : element of generic class T to be inserted.
     */
    public void add(T _element)
    {
        // Create a new node with given element
        Part new_part = new Part(_element);
        new_part.next = null;

        // If the Linked List is empty,
        // then make the new node as head
        if (head == null) {
            head = new_part;
        }
        else {
            // Else traverse till the last node
            // and insert the new_part there
            Part last = head;
            while (last.next != null) {
                last = last.next;
            }

            // Insert the new_part at last node
            last.next = new_part;
        }
    }

    /**
     * Method to add element to the front of list.
     * @param _element : element to be added.
     */
    public void addFirst(T _element){
        // Create a new node with given element
        Part new_part = new Part(_element);
        new_part.next = null;

        // If the Linked List is empty,
        // then make the new node as head
        if (head == null) {
            head = new_part;
        }
        else{
            new_part.next = head;
            head = new_part;
        }
    }

    /**
     * Adds element on certain index;
     * @param _element : element to be added.
     * @param index : index to be modified.
     * @throws NullPointerException if index is out of bounds.
     */
    public void addIndex(T _element, int index) throws NullPointerException{
        Part currPart = head;
        Part temp = null;
        Part tempNext = null;
        Part new_part = new Part(_element);
        new_part.next = null;

        if (head != null) {
            while(index > 0){
                if (currPart.next != null) {
                    if (temp != null){
                        temp.next = tempNext;
                    }
                    temp = currPart;
                    tempNext = currPart.next;
                    currPart.next = new_part;
                    index--;
                    currPart = tempNext;
                }
                else{
                    throw new NullPointerException("Out of bounds");
                }
            }
            new_part.next = currPart;
        }
        else {
            if (index == 0){
                head = new_part;
            }
            else {
                throw new NullPointerException("Out of bounds");
            }
        }
    }

    /**
     * Removes last element.
     * @throws NullPointerException if list is empty.
     * @return Deleted element.
     */
    public T remove() throws NullPointerException{
        Part output;
        if (isEmpty()){
            throw new NullPointerException("Empty List");
        }
        else{
            Part last = head;
            if (last.next == null){ //Only 1 element
                output = head;
                head = null;
            }
            else{
                while (last.next.next != null){
                    last = last.next;
                }
                output = last.next;
                last.next = null;
            }
            return output.element;
        }
    }

    /**
     * Removes first element.
     * @throws NullPointerException if is list empty.
     * @return Deleted element.
     */
    public T delFirst() throws NullPointerException{
        if (isEmpty()){
            throw new NullPointerException("Empty List");
        }
        else{
            Part temp = head;
            head = head.next;
            return temp.element;
        }
    }

    /**
     * Deletes element with index {@code index} on LinkedList.
     * @param index : the index to delete.
     * @return : element of index {@code index} in LinkedList
     * @throws NullPointerException if index is out of bounds or list is empty.
     */
    public T delIndex(int index) throws NullPointerException{
        Part currPart = head;
        Part temp = null;
        Part tempNext = null;

        if (head != null) {
            while(index > 0){
                if (currPart.next != null) {
                    if (temp != null){
                        temp.next = tempNext;
                    }
                    temp = currPart;
                    tempNext = currPart.next;
                    currPart.next = currPart.next.next;
                    index--;
                    currPart = tempNext;
                }
                else{
                    throw new NullPointerException("Out of bounds");
                }
            }
            return currPart.element;
        }
        else {
            if (index == 0){
                throw new NullPointerException("Empty List");
            }
            else {
                throw new NullPointerException("Out of bounds");
            }
        }
    }

    /**
     * Method to check if empty.
     * @return boolean isEmpty.
     */
    public boolean isEmpty(){
        return head==null;
    }

    /**
     * Shallow concatenation.
     * @param L : LinkedList to be concatenated
     */
    public void concat(LinkedList<T> L){
        Part last = head;
        if (last == null) {
            head = L.head;
        }
        else{
            while (last.next!=null){
                last = last.next; //Iterate to last element
            }
            last.next = L.head;
        }
    }

    /**
     * Method to return size of LinkedList.
     * @return : int size of LinkedList
     */
    public int size(){
        int i =0;
        Part last = head;
        while (last != null){
            last = last.next;
            i++;
        }
        return i;
    }

    // **************DELETION BY INDEX**************

    // **************MAIN METHOD**************

    // method to create a Singly linked list with n nodes
//    public static void main(String[] args)
//    {
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
//    }
}
