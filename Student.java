// Areefin 
public class Student{

    /** Private Fields */
    private String firstName;
    private String lastName;
    private String studentID;

    /** Default Constructors */

    public Student()
    {
        this.firstName = null;
        this.lastName = null;
        this.studentID = "0";
    }

    public Student(String firstName, String lastName, String studentID)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentID = studentID;
    }

    public Student(String firstName, String lastName)
    {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /** Setters or Mutators */

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public void setStudentID(String studentID)
    {
       this.studentID = studentID;   
    }

    /** Getters or Accessors */

    public String getFirstName()
    {
        return this.firstName;
    }

    public String getLastName()
    {
        return this.lastName;
    }

    public String getStudentID()
    {
        return this.studentID;
    }

    /** Sort by last names and first names if last names are the same */

    public int compareTo(Student other)
    {
        int val = this.lastName.compareTo(other.lastName);
        if(val == 0)
        {
            val = this.firstName.compareTo(other.firstName);
        }

        return val;
    }

    public int compareByLast(String last)
    {
        int val = this.lastName.compareTo(last);
        return val;
    }

    public int compareByFirst(String first)
    {
        int val = this.firstName.compareTo(first);
        return val;
    }

    /** Checking student ID */

    public boolean equals(Student other)
    {
        return this.studentID.equals(other.studentID);
    }

    /** Compare ID */

    public int compareToByID(String studentID)
    {
        int val = this.studentID.compareTo(studentID);
        return val;
    }

    public String toString()
    {
        String layout;

        layout = String.format("| %-10s | %-8s  | %-8s   |", this.firstName, this.lastName, this.studentID);

        return layout;
    }



    
}
