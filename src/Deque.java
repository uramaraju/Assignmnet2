import java.util.Iterator;
import java.util.NoSuchElementException;


public class Deque<Item> implements Iterable<Item>
{

    private int size;
    private Node<Item> first;
    private Node<Item> last;

    public Deque()
    {
        first = last = null;
        size = 0;
    }

    public void removeLast()
    {
        assertIsNotEmpty();
        if (size > 1)
        {
            last.getPrevious().setNext(null);
            last = last.getPrevious();
        } else
        {
            last = first = null;

        }
        size--;
    }

    private void assertIsNotEmpty()
    {
        if (isEmpty())
        {
            throw new NoSuchElementException();
        }
    }

    @Override
    public Iterator<Item> iterator()
    {
        return new NodeIterator<Item>(first);

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
        assertItemIsNotNull(i);
        Node<Item> node = new Node<Item>();
        node.setItem(i);

        if (size == 0)
        {
            first = last = node;
        } else
        {
            first.previous = node;
            node.next = first;
            first = node;
        }
        size++;
    }

    private void assertItemIsNotNull(Item i)
    {
        if (null == i)
        {
            throw new NullPointerException("item is null.");
        }
    }

    public void addLast(Item i)
    {
        assertItemIsNotNull(i);
        Node<Item> node = new Node<Item>();
        node.setItem(i);

        if (size == 0)
        {
            first = last = node;
        } else
        {
            last.next = node;
            node.previous = last;
            last = node;
        }
        size++;
    }

    public void removeFirst()
    {
        assertIsNotEmpty();
        if (size > 1)
        {
            first.getNext().setPrevious(null);
            first = first.getNext();
        } else
        {
            last = first = null;

        }
        size--;
    }

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

    private static class NodeIterator<Item> implements Iterator<Item>
    {
        private Node<Item> current;

        private NodeIterator(Node<Item> node)
        {
            this.current = node;
        }

        @Override
        public boolean hasNext()
        {
            return current != null;
        }

        @Override
        public Item next()
        {
            Item i = current.getItem();
            current = current.next;
            return i;
        }

        @Override
        public void remove()
        {
            throw new UnsupportedOperationException();
        }
    }
}
