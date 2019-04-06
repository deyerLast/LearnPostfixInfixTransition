import java.util.EmptyStackException;

public class Stack<T> {

    private static final int DEFAULT_CAPACITY = 15;
    private int top;       // Reference to the top element
    private T[] stack;

    /**
     * Creates a Stack of the size initialCapacity
     */
    public Stack(int initialCapacity)
    {
        if (initialCapacity > 0)
            stack = (T[]) new Object[initialCapacity];
        else
            stack =(T[]) new Object[DEFAULT_CAPACITY];

        top = -1;   //stack is empty
    }

    //************************************************************************

    public Stack() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * Tests if the stack is empty.
     */

    //************************************************************************

    public boolean isEmpty()
    {
        return top < 0;
    }

    //************************************************************************

    /**
     * Removes all items from the Stack.
     */
    public void clear()
    {
        for(int i = 0; i <= top; i++)
            stack[i] = null;

        top = -1;
    }

    //************************************************************************

    /**
     * Inserts an item onto the top of the stack.
     */
    public void push(T newEntry)
    {
        if (top == stack.length) throw new IllegalArgumentException(
                "Stack has overflowed");
        top++;
        stack[top] = newEntry;
    }

    //************************************************************************

    /**
     *Look at what the top holds.
     * @return top of stack
     */
    public T peek(){
        if(isEmpty()) {
            return null;
        }
        else{
            return stack[top];
        }
    }

    //************************************************************************

    /**
     * Get top of stack and take it out of the arrayStack
     * @return top of stack
     */
    public T pop(){
        if(isEmpty()){
            throw new EmptyStackException();
        }
        else{
            T topStack = stack[top];
            stack[top] = null;
            top--;
            return topStack;
        }
    }
}

