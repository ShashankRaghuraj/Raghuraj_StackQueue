import java.util.LinkedList;

// Shashank Raghuraj
// StackList.java
// Write your own Stack using a LinkedList as the private variable

public class StackList<E>
{ 
  //declare private instance variable
  private LinkedList<E> list;
  public StackList()
  {
    //intialization
    list = new LinkedList<E>();
  }
  public void push(E x)
  {
    //add
    list.addFirst(x);
  }
  public E pop()
  {
    //remove
    return list.removeFirst();
  }
  public E peek()
  {
    //see top
    return list.getFirst();
  }
  public boolean isEmpty()
  {
    //determines whether list is empty or not
    return list.size() == 0;
  }
}
