import java.util.LinkedList;

// Shashank Raghuraj
// QueueList.java
// Write your own Queue using a LinkedList as the private variable

public class QueueList<E>
{ 
  //declare private instance variables
  private LinkedList<E> list;
  public QueueList()
  {
    //intializes
    list = new LinkedList<E>();
  }
  public boolean add(E x)
  {
    //adds
    list.addFirst(x);
    return true;
  }
  public E remove()
  {
    //removes
    return list.removeLast();
  }
  public E peek()
  {
    //gets first value
    return list.getLast();
  }
  public boolean isEmpty()
  {
    //size == 0 then empty so true;
    return list.size() == 0;
  }
}
