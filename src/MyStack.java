import java.util.EmptyStackException;

public class MyStack implements StackADT {
    private Square[] stack;
    private int size;

    public MyStack(int initCap) {
        stack = new Square[initCap];
        size = this.getSize();
    }

    public MyStack() {

        stack = new Square[2];
        size = this.getSize();
    }

    public Square[] getStack() {
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
        for (int i = size-1; i >= 0; i--) {
            if (string.length() == 0) {
                string += String.valueOf(stack[i]) + "      <----- TOP \n";
            }else{
                string += String.valueOf(stack[i]) + "\n";
            }
        }

        return string + "\n--------";
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public Square peek() {
        if (this.isEmpty())
            throw new EmptyStackException();

        return stack[size - 1];
    }

    public Square pop() {
        if (this.isEmpty())
            throw new EmptyStackException();

        Square temp = stack[size - 1];
        stack[size - 1] = null;
        size = this.getSize();
        return temp;

    }

    public void push(Square num) {
        if (size == stack.length)
            doubleCapacity();
        stack[size] = num;
        size = this.getSize();
    }

    public void doubleCapacity() {
        Square[] newStack = new Square[stack.length * 2];
        size = this.getSize();
        for (int i = 0; i < size; i++) {
            newStack[i] = stack[i];
        }

        stack = newStack;
        size = this.getSize();
    }

    public void clear(){
        stack = new Square[2];
    }
}