package linkedlist;

import org.junit.Assert;
import org.junit.Test;

public class LinkedListTest {

    @Test
    public void printList() {
        LinkedList<Integer> L = new LinkedList<>(9);
        L.add(1);
        L.printList();
    }

    @Test
    public void find() {
        LinkedList<Integer> L = new LinkedList<>(9);
        L.add(1);
        L.add(2);
        L.add(3);
        Assert.assertEquals(1,L.find(1));
        Assert.assertEquals(-1, L.find(8));
        Assert.assertEquals(0,L.find(9));
    }

    @Test
    public void add() {
        LinkedList<Integer> L = new LinkedList<>(9);
        L.add(1);
        L.add(2);
        L.add(3);
        Assert.assertEquals(1,L.find(1));
        Assert.assertEquals(-1, L.find(8));
        Assert.assertEquals(0,L.find(9));
        Assert.assertEquals(3,L.find(3));
    }

    @Test
    public void addFirst() {
        LinkedList<Integer> L = new LinkedList<>(9);
        L.addFirst(1);
        L.addFirst(2);
        L.addFirst(3);
        Assert.assertEquals(2,L.find(1));
        Assert.assertEquals(-1, L.find(8));
        Assert.assertEquals(3,L.find(9));
        Assert.assertEquals(0,L.find(3));
    }

    @Test
    public void addIndex() {
        LinkedList<Integer> L = new LinkedList<>(9);
        L.addFirst(1);
        L.addFirst(2);
        L.addFirst(3);
        L.addIndex(6,2);
        Assert.assertEquals(2,L.find(6));
    }

    @Test
    public void remove() {
        LinkedList<Integer> L = new LinkedList<>(9);
        L.addFirst(1);
        L.addFirst(2);
        L.addFirst(3);
        L.addIndex(6,2);
        int x = L.remove();
        Assert.assertEquals(-1,L.find(9));
        Assert.assertEquals(9,x);
    }

    @Test
    public void delFirst() {
        LinkedList<Integer> L = new LinkedList<>(9);
        L.addFirst(1);
        L.addFirst(2);
        L.addFirst(3);
        L.addIndex(6,2);
        int x = L.delFirst();
        Assert.assertEquals(-1,L.find(3));
        Assert.assertEquals(3,x);
    }

    @Test
    public void delIndex() {
        LinkedList<Integer> L = new LinkedList<>(9);
        L.addFirst(1);
        L.addFirst(2);
        L.addFirst(3);
        L.addIndex(6,2);
        L.delIndex(2);
        Assert.assertEquals(-1,L.find(6));
        int x = L.delIndex(2);
        Assert.assertEquals(1, x);
    }

    @Test
    public void concat() {
        LinkedList<Integer> L = new LinkedList<>(9);
        LinkedList<Integer> L1 = new LinkedList<>(11);
        L.addFirst(1);
        L.addFirst(2);
        L.addFirst(3);
        L.addIndex(6,2);
        L.concat(L1);
        Assert.assertEquals(5,L.find(11));
    }

    @Test
    public void size() {
        LinkedList<Integer> L = new LinkedList<>(9);
        L.addFirst(1);
        L.addFirst(2);
        L.addFirst(3);
        L.addIndex(6,2);
        L.remove();
        Assert.assertEquals(4,L.size());
    }
}