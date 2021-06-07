package p11_stackQueue.baitap.daoChuSoNguoc;

import java.util.EmptyStackException;
import java.util.LinkedList;

public class MyGenericStack<T> {
    private LinkedList<T> stack;

    public MyGenericStack() {
        stack = new LinkedList();
    }
    /**
     * Phthuc push
     */
    public void push(T element) {
        stack.addFirst(element);
    }
    /**
     * Phthuc pop
     */
    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return stack.removeFirst();
    }
    /**
     * Phthuc size
     */
    public int size(){
        return stack.size();
    }
    /**
     * Phthuc isEmpty
     */
    public boolean isEmpty(){
        if(stack.size()==0){
            return true;
        }
        return false;
    }

}
