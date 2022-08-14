// Shashank Raghuraj
// RingBuffer.java
// Write this class LAST.  Use your RingBuffer FRQ to complete this class 


//I was ONLY able to do this by the power of grayskull, I mean youtube and google. It gave me a better understanding of how ring buffers(circular arrays) actually work. 
public class RingBuffer
{ 
  //initalize variables
	private char[] characters;
	private int front;
	private int rear;	

  //rhymes with funstructor
	public RingBuffer(int capacity)
	{ 
		characters = new char[capacity + 1];
		front = 0;
		rear = 0;
	}
	public boolean add(char ch)
  {
    //the first part of the or checks the not wrapped. The second part of or checks if it is wrapped
    if((rear - front == characters.length - 1) || front - rear == 1)
    {
      //returns false if it meets the requirements of rear - front == characters.length - 1 or front - rear == 1
      return false;
    }
    //sets the last charcacter to ch
    characters[rear] = ch;
    //increment rear because it's filled up
    rear++;
    //if rear becomes the length, then 
    if(rear == characters.length)
    {
      rear = 0;
    }
    return true;
  }	
  //Opposite of add
  public char remove()
  {
    char value;//initalize
    if(isEmpty())//if they da same
    {
      return ' ';//return this space
    }
    //This is the opposite of the add because it just uses front instead of rear
    value = characters[front];//values gets sent to the front value
    front++;//increment
    if(front == characters.length)//use of front to see if == to length
    {
      front = 0;//set 0
    }
    return value;//return
  }
  //Accessor methods below
  public int getFront()
  {
    return front;//returns front amount
  }
  public int getRear()
  {
    return rear;//return rear amount
  }
  public char peek()
  {
    if(isEmpty())//If is empty = true
    {
      return '!';//does this
    }
    else
    {
      return (char)characters[front];//else type case
    }
  }
  public boolean isEmpty()
  {
    return front == rear;//ye ye, front == rear ye
	}
	public void flush()
  {
    front = rear = 0;//set em to 0
	}
}
