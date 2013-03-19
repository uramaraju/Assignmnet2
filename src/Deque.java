import java.util.Iterator;


public class Deque<Item> implements Iterable<Item>
{

    private static class Node<Item>
    {
        private Item item;
        private Node<Item> next;
        private Node<Item> previous;

        private Node()
        {
        }

        public Node<Item> getPrevious()
        {
            return previous;
        }

        public void setPrevious(Node<Item> previous)
        {
            this.previous = previous;
        }

        public Item getItem()
        {
            return item;
        }

        public void setItem(Item item)
        {
            this.item = item;
        }

        public Node<Item> getNext()
        {
            return next;
        }

        public void setNext(Node<Item> next)
        {
            this.next = next;
        }
    }

    @Override
    public Iterator<Item> iterator()
    {
        return null;
    }

    private int size;
    private Node<Item> first;
    private Node<Item> last;

    public Deque()
    {
        first = last = null;
        size = 0;
    }

    public boolean isEmpty()
    {
        return size == 0;
    }

    public int size()
    {
        return size;
    }

    public void addFirst(Item i)
    {
        Node<Item> node = new Node<Item>();
        node.setItem(i);

        if (size == 0)
        {
            first = last = node;
        }
        else
        {
            first.previous = node;
            node.next = first;
            first = node;
        }
    }

    public void addLast(Item i)
    {
        Node<Item> node = new Node<Item>();
        node.setItem(i);

        if (size == 0)
        {
            first = last = node;
        }
        else
        {
            last.next = node;
            node.previous = last;
            last = node;
        }
    }

    public void removeFirst()
    {
        throw new UnsupportedOperationException();
    }
}
