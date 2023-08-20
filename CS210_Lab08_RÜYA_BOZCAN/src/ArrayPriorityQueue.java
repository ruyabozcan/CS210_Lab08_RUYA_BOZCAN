

// RUYA BOZCAN
// 200201044
// COMPUTER ENGINEERING
// CS210
// LAB 08

import java.util.NoSuchElementException;

public class ArrayPriorityQueue<E extends Comparable<E>> implements PriorityQueue<E>
{
    private E[] elements;
    private final int MAX_SIZE = 10000;
    private int size;
    @SuppressWarnings("unchecked")
    public ArrayPriorityQueue()
    {
        elements = (E[]) new Comparable[MAX_SIZE];
        size = 0;
    }

    public void clear()
    {
        elements = (E[]) new Comparable[MAX_SIZE];
        size = 0;
    }

    public E dequeue()
    {
        if (isEmpty())
        {
            return null;
        }

        int minIndex = 0;
        for (int i = 1; i < size; i++)
        {
            if (elements[i].compareTo(elements[minIndex]) < 0)
            {
                minIndex = i;
            }
        }

        E minElement = elements[minIndex];
        elements[minIndex] = elements[size - 1];
        elements[size - 1] = null;
        size--;

        return minElement;
    }

    public void enqueue(E element)
    {
        if (size >= MAX_SIZE)
        {
            throw new IllegalStateException("Priority queue is full");
        }

        elements[size] = element;
        size++;
    }

    public boolean isEmpty()
    {
        return size == 0;
    }
    public E peek()
    {
        if (isEmpty())
        {
            return null;
        }

        E minElement = elements[0];
        for (int i = 1; i < size; i++)

        {
            if (elements[i].compareTo(minElement) < 0)

            {
                minElement = elements[i];
            }
        }

        return minElement;
    }
    public int size()
    {
        return size;
    }

    public static void main(String[] args)
    {
        ArrayPriorityQueue<String> queue = new ArrayPriorityQueue<>();

        // Enqueue elements
        queue.enqueue("c");
        queue.enqueue("a");
        queue.enqueue("b");
        queue.enqueue("d");

        // Print the queue
        System.out.println("Queue: " + queue);

        // Dequeue elements
        System.out.println("Dequeued: " + queue.dequeue());
        System.out.println("Dequeued: " + queue.dequeue());
        System.out.println("Dequeued: " + queue.dequeue());
        System.out.println("Dequeued: " + queue.dequeue());

        // Print the queue
        System.out.println("Queue: " + queue);
    }
}
