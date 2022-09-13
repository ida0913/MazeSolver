import java.util.EmptyStackException;

public class MyStack {
    private Integer[] stack;
    private int size;

    public MyStack(int initCap) {
        stack = new Integer[initCap];
        size = this.getSize();
    }

    public MyStack() {

        stack = new Integer[2];
        size = this.getSize();
    }

    public Integer[] getStack() {
        return stack;
    }

    public int getSize() {
        size = 0;
        for (int i = 0; i < stack.length; i++) {
            if (stack[i] != null) {
                size++;
            }
        }
        return size;
    }

    @Override
    public String toString() {
        size = this.getSize();
        String string = "";
        for (int i = 0; i < size; i++) {
            if (string.length() == 0) {
                string += String.valueOf(stack[i]) + "      <----- TOP \n";
            }
            string += String.valueOf(stack[i]) + "\n";
        }

        return string + "\n--------";
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public Integer peek() {
        if (this.isEmpty())
            throw new EmptyStackException();

        return stack[size - 1];
    }

    public Integer pop() {
        if (this.isEmpty())
            throw new EmptyStackException();

        int temp = stack[size - 1];
        stack[size - 1] = null;
        size = this.getSize();
        return temp;

    }

    public void push(int num) {
        if (size == stack.length)
            doubleCapacity();
        stack[size] = num;
        size = this.getSize();
    }

    public void doubleCapacity() {
        Integer[] newStack = new Integer[stack.length * 2];
        size = this.getSize();
        for (int i = 0; i < size; i++) {
            newStack[i] = stack[i];
        }

        stack = newStack;
        size = this.getSize();
    }
}