public class SortedLinkedList
{
    private Node head;
    
    /** Default Constructor */

    public SortedLinkedList()
    {
        head = new Node();
    }

    public boolean isEmpty()
    {
        return head.next == null;
    }

    public void insertSorted(StudentRecord a)
    {
        Node curr = head.next;
        Node prev = head;

        while(curr != null && a.compareTo(curr.data) > 0)
        {
            prev = curr;
            curr = curr.next;
        }

        curr = new Node(a, curr);
        prev.next = curr;
    }
    

    public void deleteSorted(StudentRecord x) throws Exception
		{
            if(head.next == null){throw new Exception("Empty List!");}
			
            Node curr = head.next;
			Node prev = head;
			
            while (curr != null && x.compareTo(curr.data) > 0)
		       {prev = curr; curr = curr.next;}
			if(curr == null){throw new Exception("Student NOT found");}

            if((x.compareTo(curr.data) > 0)){throw new Exception("Student NOT found");}

            if(x.compareTo(curr.data)==0){prev.next = curr.next;}
		    
		}

    public StudentRecord searchSorted(StudentRecord studentToFind) throws Exception
    {
        
        if(head.next == null){throw new Exception("Empty List!");}
        Node curr = head.next;

        while((curr != null) && (studentToFind.compareTo(curr.data) != 0))
        {
            curr = curr.next;
        }

        
        if(curr == null){throw new Exception("Student NOT found");}
        
        if((studentToFind.compareTo(curr.data) > 0)){throw new Exception("Student NOT found");}

        if(studentToFind.compareTo(curr.data)==0){return curr.data;}

        return studentToFind;
    }

    public StudentRecord searchSortedLastName(String lastname) throws Exception
    {
        if(head.next == null){throw new Exception("Empty List!");}

        Node curr = head.next;

        while((curr != null) && (curr.data.compareByLast(lastname) != 0))
        {
            curr = curr.next;
        }

        if(curr == null){throw new Exception("Student NOT found");}
        if((curr.data.compareByLast(lastname) > 0)){throw new Exception("Student NOT found");}
        if(curr.data.compareByLast(lastname)==0){return curr.data;}

        return curr.data;
    }

    public StudentRecord searchSortedFirstName(String firstname) throws Exception
    {
        if(head.next == null){throw new Exception("Empty List!");}

        Node curr = head.next;

        while((curr != null) && (curr.data.compareByFirst(firstname) != 0))
        {
            curr = curr.next;
        }

        if(curr == null){throw new Exception("Student NOT found");}
        if((curr.data.compareByFirst(firstname) > 0)){throw new Exception("Student NOT found");}
        if(curr.data.compareByFirst(firstname)==0){return curr.data;}

        return curr.data;
    }

    public StudentRecord searchSortedByID(String ID) throws Exception
    {
        if(head.next == null){throw new Exception("Empty List!");}

        Node curr = head.next;

        while((curr != null) && (curr.data.compareToByID(ID) != 0))
        {
            curr = curr.next;
        }
        if(curr == null){throw new Exception("Student NOT found");}
        if((curr.data.compareToByID(ID) > 0)){throw new Exception("Student NOT found");}
        if(curr.data.compareToByID(ID)==0){return curr.data;}

        return curr.data;
    }
    

    public String toString()
    {
        String s = "";
        Node curr = head.next;

        while(curr != null)
        {
            s += curr.data.toString();
            curr = curr.next;
        }

        return s;
    }

    public String printStudent()
    {
        String s = "";
        Node curr = head.next;

        while(curr != null)
        {
            s += curr.data.printStudent();
            curr = curr.next;
        }
        return s;
    }
}
