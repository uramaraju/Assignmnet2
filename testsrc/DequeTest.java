import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;
public class DequeTest
{
    @Test
    public void defaultSizeIsZeroAndEmpty()
    {
        Deque<Integer> deque = new Deque<Integer>();
        assertEquals(0, deque.size());
        assertTrue(deque.isEmpty());
    }

    @Test
    public void addFirstWhenEmpty()
    {
        Deque<Integer> deque = new Deque<Integer>();
        deque.addFirst(2);
        assertEquals(1, deque.size());
        assertFalse(deque.isEmpty());
    }

    @Test
    public void addLastWhenEmpty()
    {
        Deque<Integer> deque = new Deque<Integer>();
        deque.addLast(2);
        assertEquals(1, deque.size());
        assertFalse(deque.isEmpty());
    }

    @Test
    public void iteratorTest()
    {
        Deque<Integer> deque = new Deque<Integer>();
        for (int i = 0; i < 10; i++)
        {
            deque.addFirst(i+1);
        }
        int expected = 10;
        for(int i: deque)
        {
            assertEquals(expected, i);
            expected--;
        }
        assertEquals(expected,0);
    }

    public  @Rule ExpectedException exception = ExpectedException.none();
    @Test
    public void cantAddNullItem()
    {
        Deque<String> deque = new Deque<String>();
        exception.expect(NullPointerException.class);
        exception.expectMessage("item is null.");
        deque.addFirst(null);
    }

    @Test
    public void remove()
    {
        Deque<Integer> deque = new Deque<Integer>();
        for (int i = 0; i < 10; i++)
        {
            deque.addFirst(i+1);
        }
        //added 10 .. 1, removed 10, 1
        deque.removeFirst();
        deque.removeLast();
        int expected = 9;
        for(int i: deque)
        {
            assertEquals(expected, i);
            expected--;
        }
        assertEquals(8,deque.size());
        assertEquals(expected,1);
    }

    @Test
    public void removeFromEmptyQueue()
    {
        Deque<String> deque = new Deque<String>();
        exception.expect(NoSuchElementException.class);
        deque.removeFirst();

    }
    @Test
    public void removeLastFromEmptyQueue()
    {
        Deque<String> deque = new Deque<String>();
        exception.expect(NoSuchElementException.class);
        deque.removeLast();

    }

    @Test
    public void removeFromIteratorThrowsException()
    {
        Deque<Integer> deque = new Deque<Integer>();
        for (int i = 0; i < 10; i++)
        {
            deque.addFirst(i+1);
        }
        exception.expect(UnsupportedOperationException.class);
        while (deque.iterator().hasNext())
        {
            deque.iterator().remove();

        }
    }
}
