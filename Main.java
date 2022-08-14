import java.util.ArrayList;

//Shashank Raghuraj
//StackQueueTester
//In this file, you will write the methods that will thoroughly test your StackList and QueueList

// My recommendation:  Uncomment them ONE AT A TIME, write that method and test it in your Main.java runner before starting the next method
public class StackQueueTester
{
  //Funstructor
  public StackQueueTester(){}
  //returns a String containing all of the Strings in q in removal order each separated by a single space.  postcondition: q is empty
	public String stringDump(QueueList<String> q)	
  {
    //creates new sentence string
    String sentence = "";
    while(q.isEmpty() != true)
    {
      //sentence adds from the removed values
      sentence += q.remove() + " ";
    }
    if(sentence.length() > 0)
    {
      //deletes the last space if the sentence length is > 0
      sentence = sentence.substring(0, sentence.length()-1);
    }
    return sentence;
  }
  //returns a String containing all of the Strings in s in removal order each separated by a single space.  postcondition: s is empty
	public String stringDump(StackList<String> s)	
  {
    //creates the sentence string
    String sentence = "";
    while(s.isEmpty() != true)
    {
      //sentence gets added as StackList has removed
      sentence += s.pop() + " ";
    }
    if(sentence.length() > 0)
    {
      //deletes the space at the end
      sentence = sentence.substring(0, sentence.length()-1);
    }
    return sentence;
  }
  //removes all instances of name from q.  All remaining elements in q keep their original order.
	public void removeName(QueueList<String> q, String name)
  {
    //creates a temp queue list;
    QueueList<String> tempQueue = new QueueList<String>();
    while(q.isEmpty() != true)
    {
      //checks to see if the top value in the queue is the search value
      if(q.peek().equals(name))
      {
        //if it is, then it removes
        q.remove();
      }
      else
      {
        //else it'll add this to a temp queue
        tempQueue.add(q.remove());
      }
    }
    //it moves it all back to the q
    while(tempQueue.isEmpty() != true)
    {
      q.add(tempQueue.remove());
    }
  }
  //returns true if name is found in s and false otherwise.  The elements in s are in their original order. 
	public boolean stackSearch(StackList<String> s, String name)	
  {	
    //temp stack
    StackList<String> tempStack = new StackList<String>();
    boolean search = false;//boolean var
    while(s.isEmpty() != true)
    {
      if(s.peek().equals(name))
      {
        search = true;//if the first value = name
      }
      tempStack.push(s.pop());//adds
    }
    while(tempStack.isEmpty() != true)
    {
      s.push(tempStack.pop());//reverses order back to original
    }
    return search;
  }
  //This method returns the individual words in order (without any spaces or periods) in a QueueList. 
	public QueueList<String> splitString(String s)
  {
    //temp str to add to
    String addingStr = "";
    //used the string analysis to help
    QueueList<String> queue = new QueueList<String>();
    for(int i = 0; i < s.length(); i++)
    {
      //will check substring while its not equal to space or period
      if(! s.substring(i,i+1).equals(" ") && !s.substring(i, i+1).equals("."))
      {
        addingStr += s.substring(i,i+1);
      }
      //if it is a space, it adds
      else
      {
        queue.add(addingStr);
        addingStr = "";
      }
    }
    return queue;
  }
  //returns a QueueList containing the longest word(s) in q.  postcondition: q contains its original elements in their original order.
	public QueueList<String> longestWords(QueueList<String> q)
  {	
    int maxLength = 0;//calculates max length
    QueueList<String> queueTemp = new QueueList<String>();//temporary queue
    QueueList<String> queueFinal =  new QueueList<String>();//result queue
    while(q.isEmpty() != true)
    {
      //By using the properties of the linkedlist which is the length
      if(q.peek().length() > maxLength)
      {
        maxLength = q.peek().length(); // sets max length to q.peek().length();
      }
      queueTemp.add(q.remove());//traverses by pushing into temp list
    }
    while(queueTemp.isEmpty() != true)
    {
      //checks to see if the max length occurs
      if(queueTemp.peek().length() == maxLength)
      {
        queueFinal.add(queueTemp.peek());//if so, it adds to the final
      }
      //adds to q to get back to original
      q.add(queueTemp.remove());
    }
    return queueFinal;
  }
  public StackList<String> findDuplicates(StackList<String> s, QueueList<String> q)
  {
    StackList<String> finalStack = new StackList<String>();
    ArrayList<String> tempList = new ArrayList<String>();
    ArrayList<String> newList = new ArrayList<String>();
    while(s.isEmpty() != true){
      tempList.add(s.pop());
    }
    while(q.isEmpty() != true){
      tempList.add(q.remove());
    }
    for (String store : tempList) 
    { 
      if (!newList.contains(store)) 
      {
        newList.add(store); 
      } 
    }
    for(String store : newList)
    {
      finalStack.push(store);
    }
    return finalStack;
  }
}
