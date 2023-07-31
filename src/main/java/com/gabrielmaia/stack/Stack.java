package com.gabrielmaia.stack;

public class Stack<T> {
    private Integer count = 0;
    private Object[] items;

    public Stack() {
        this.items = new Object[10];
    }

    public void push(T item) {
        if (this.count == this.items.length)
            grow();
        this.items[count] = item;
        this.count++;
    }

    public T pop() {
        if (this.isEmpty())
            return null;
        this.count--;
        T result = (T) this.items[this.count];
        this.items[this.count] = null;
        return result;
    }

    public T peek() {
        if (this.isEmpty())
            return null;
        return (T) this.items[this.count -1];
    }

    public Boolean isEmpty() {
        return this.count <= 0;
    }

    public Integer size() {
        return this.count;
    }

    public void clear() {
        this.items = new Object[10];
        this.count = 0;
    }

    public String toString(StringFormatter<T> callback) {
        if (this.isEmpty())
            return null;
        String objectString = callback.toString((T) this.items[0]);
        for (int i = 1; i < this.count; i++) {
            objectString = objectString.concat(callback.toString((T) this.items[i]));
        }
        return objectString;
    }

    private void grow() {
        Object[] newItems = new Object[items.length * 2];
        System.arraycopy(items, 0, newItems, 0, items.length);
        this.items = newItems;
    }
}
