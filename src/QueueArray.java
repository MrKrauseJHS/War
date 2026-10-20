/* QueueArray<Item>  (array-based, iterable)
 *
 * Methods
 * =======
 * boolean isEmpty()             : returns true if the queue is empty, false otherwise
 * int size()                    : returns the number of elements in the queue
 * void enqueue(Item item)       : adds item to the end of the queue
 * Item dequeue()                : removes the front-most item from the queue and returns it
 * Iterator<Item> iterator()     : returns a head-to-tail iterator for the queue
 */

import java.util.Iterator;
import java.util.Scanner;

public class QueueArray<Item> implements Iterable<Item>, Queue<Item>{

    private Item[] items;
    private int    head;
    private int    tail;
    private int    size;

    public QueueArray() {
        items = (Item[]) (new Object[10]);
        head = 0;
        tail = 0;
        size = 0;
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public int size() {
        return size;
    }

    public void enqueue(Item item) {

        items[tail++] = item;

        if (tail == items.length) {
            tail = 0;
        }

        size++;
    }

    public Item dequeue() {
        if (this.isEmpty()) {
            throw new RuntimeException("Tried to dequeue an empty queue");
        }
        else {
            Item itemToReturn = items[head];
            items[head++] = null; //prevents loitering
            size--;
            if (head == items.length) {
                head = 0;
            }


            return itemToReturn;
        }
    }

    private void resize(int capacity) {
        //TODO : Implement the resize method and use it in the correct spots in QueueArray
    }

    public Iterator<Item> iterator() {
        return (new Iterator<Item>() {

            private int pos = head;
            private int count = 0;

            public boolean hasNext() {
                return (count < size);
            }

            public Item next() {
                Item item = items[pos++];
                if (pos == items.length)
                    pos = 0;
                count++;
                return item;
            }
        });
    }
}
