package com.javarush.task.task20.task2028;

import java.io.IOException;
import java.io.Serializable;
import java.util.*;

/* 
Построй дерево(1)
*/
public class CustomTree<T> extends AbstractList<String> implements Cloneable, Serializable {
    Entry<T> root;
    private int size = 0;

    public CustomTree() {
        root = new Entry<T>("root");
        root.lineNumber = 0;
    }

    @Override
    public boolean remove(Object o) {
        String s;
        try {
            s = (String) o;
        } catch (Exception e) {
            throw new UnsupportedOperationException(e);
        }
        return removeByString(root, s);
    }

    private boolean removeByString(Entry<T> root, String s) {
        if (root.leftChild != null && root.leftChild.elementName.equals(s)) {
            root.leftChild = null;
           // root.availableToAddLeftChildren = true;
            return true;
        } else if (root.leftChild != null) {
            removeByString(root.leftChild, s);
        }

        if (root.rightChild != null && root.rightChild.elementName.equals(s)) {
            root.rightChild = null;
            //root.availableToAddRightChildren = true;
        } else if (root.rightChild != null) {
            removeByString(root.rightChild, s);
        }
        return true;
    }

    @Override
    public boolean add(String s) {
        if (!checkAdd(root)) {
            setAdd(root);
        }
        ArrayDeque<Entry<T>> arrayDeque = new ArrayDeque<>();
        arrayDeque.addLast(root);
        while (true) {
            Entry<T> check = arrayDeque.pollFirst();
            if (check.addChild(s)) {
                return true;
            } else {
                if (check.leftChild != null) arrayDeque.addLast(check.leftChild);
                if (check.rightChild != null) arrayDeque.addLast(check.rightChild);
            }
        }
    }

    private void setAdd(Entry<T> root) {
        if (root.leftChild == null) {
            root.availableToAddLeftChildren = true;
        } else {
            setAdd(root.leftChild);
        }

        if (root.rightChild == null) {
            root.availableToAddRightChildren = true;
        } else {
            setAdd(root.rightChild);
        }
    }

    public void displayTree() {
        Stack globalStack = new Stack();
        globalStack.push(root);
        int emptyLeaf = 32;
        boolean isRowEmpty = false;
        System.out.println("****......................................................****");
        while (!isRowEmpty) {

            Stack localStack = new Stack();
            isRowEmpty = true;
            for (int j = 0; j < emptyLeaf; j++)
                System.out.print(" ");
            while (globalStack.isEmpty() == false) {
                Entry<T> temp = (Entry<T>) globalStack.pop();
                if (temp != null) {
                    System.out.print(temp.elementName);
                    localStack.push(temp.leftChild);
                    localStack.push(temp.rightChild);
                    if (temp.leftChild != null || temp.rightChild != null)
                        isRowEmpty = false;
                } else {
                    System.out.print("--");
                    localStack.push(null);
                    localStack.push(null);
                }
                for (int j = 0; j < emptyLeaf * 2 - 2; j++)
                    System.out.print(" ");
            }
            System.out.println();
            emptyLeaf /= 2;
            while (localStack.isEmpty() == false)
                globalStack.push(localStack.pop());
        }
        System.out.println("****......................................................****");
    }


    @Override
    public int size() {
        size = 0;
        checkSize(root);
        return size;
    }

    private void checkSize(Entry<T> root) {
        if (root.leftChild != null) {
            size++;
            checkSize(root.leftChild);
        }

        if (root.rightChild != null) {
            size++;
            checkSize(root.rightChild);
        }
    }

    private boolean checkAdd(Entry<T> root) {
        if (root.availableToAddLeftChildren) {
            return true;
        } else if (root.leftChild != null)
            return checkAdd(root.leftChild);

        if (root.availableToAddRightChildren) {
            return true;
        } else if (root.rightChild != null)
            return checkAdd(root.rightChild);

        return false;
    }

    public String getParent(String s) {
        String name;
        if (root == null)
            return null;
        if (root.elementName.equals(s))
            return null;

        name = getParentName(root, s);

        return name;
    }

    private String getParentName(Entry<T> root, String name) {
        String parentName = null;
        if (root.leftChild != null && root.leftChild.elementName.equals(name))
            parentName = root.elementName;
        else if (root.rightChild != null && root.rightChild.elementName.equals(name))
            parentName = root.elementName;
        else {
            if (root.leftChild != null)
                parentName = getParentName(root.leftChild, name);
            if (parentName == null && root.rightChild != null)
                parentName = getParentName(root.rightChild, name);
        }
        return parentName;
    }

    public String get(int index) {
        throw new UnsupportedOperationException();
    }

    public String set(int index, String element) {
        throw new UnsupportedOperationException();
    }

    public void add(int index, String element) {
        throw new UnsupportedOperationException();
    }

    public String remove(int index) {
        throw new UnsupportedOperationException();
    }

    public List<String> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    protected void removeRange(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    public boolean addAll(int index, Collection<? extends String> c) {
        throw new UnsupportedOperationException();
    }

    static class Entry<T> implements Serializable {
        String elementName;
        T value;
        int lineNumber;
        boolean availableToAddLeftChildren, availableToAddRightChildren;
        Entry<T> parent, leftChild, rightChild;

        public Entry(String elementName) {
            this.elementName = elementName;
            availableToAddLeftChildren = true;
            availableToAddRightChildren = true;
        }

        public T getValue() {
            return value;
        }

        public void checkChildren() {
            if (leftChild != null)
                availableToAddLeftChildren = false;
            if (rightChild != null)
                availableToAddRightChildren = false;
        }

        public boolean isAvailableToAddChildren() {
            return (availableToAddLeftChildren || availableToAddRightChildren);
        }

        public boolean addChild(String s) {
            checkChildren();
            if (isAvailableToAddChildren()) {
                Entry<T> entry = new Entry<>(s);
                entry.parent = this;
                entry.lineNumber = this.lineNumber + 1;
                if (availableToAddLeftChildren) {
                    leftChild = entry;
                    return true;
                }
                if (availableToAddRightChildren) {
                    rightChild = entry;
                    return true;
                }
            }
            return false;

        }
    }
}
