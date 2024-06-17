public class Node
{
    StudentRecord data;
    Node next;

    /** Default constructors */

    public Node()
    {
        data = null;
        next = null;
    }

    public Node(StudentRecord data)
    {
        this.data = data;
        next = null;
    }

    public Node(StudentRecord data, Node next)
    {
        this.data = data;
        this.next = next;
    }

    /** Setters or Mutators  */

    public void setData(StudentRecord data)
    {
        this.data = data;
    }

    public void setNext(Node next)
    {
        this.next = next;
    }

    /** Getters or Accessors */

    public StudentRecord getData()
    {
        return this.data;
    }

    public Node getNext()
    {
        return this.next;
    }

    
}
