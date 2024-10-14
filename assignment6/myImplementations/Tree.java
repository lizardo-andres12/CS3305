// Name: Lizardo Hernandez
// Class: CS 3305/Section 01
// Term: Fall 2024
// Instructor: Dr. Haddad
// Assignment: 6
// IDE Name: Intellij

package assignment6.myImplementations;

public interface Tree<E> {
    public boolean insert(E data);
    public boolean isEmpty();
    public boolean remove(E data);
    public boolean search(E data);
    public int size();
    public void inorder();
    public void preorder();
    public void postorder();
}
