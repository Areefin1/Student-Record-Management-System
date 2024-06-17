public class StudentRecord extends Student
{
    private double currGpa;
    private int currCredits;
    private double newGpa;
    private int newCredits;
    private int totalCredits = currCredits + newCredits;

    /** Default Constructors */

    public StudentRecord()
    {
        super();
        this.currGpa = 0.0;
        this.currCredits = 0;
        this.newGpa = 0.0;
        this.newCredits = 0;
        this.totalCredits = currCredits + newCredits;
    }

    public StudentRecord(double gpa, int credits)
    {
        this.currGpa = gpa;
        this.currCredits = credits;
        this.totalCredits = currCredits;
    }

    public StudentRecord(String f, String l)
    {
        super(f, l);
    }

    public StudentRecord(String f, String l, String st)
    {
        super(f, l, st);
    }

    public StudentRecord(String f, String l, String st, double gpa, int credits)
    {
        super(f, l, st);
        this.currGpa = gpa;
        this.currCredits = credits;
        this.totalCredits = currCredits;
    }

    public StudentRecord(String f, String l, String st, double gpa, int credits, double newGpa, int newCredits)
    {
        super(f, l, st);
        this.currGpa = gpa;
        this.currCredits = credits;
        this.newGpa = newGpa;
        this.newCredits = newCredits;
        this.totalCredits = currCredits + newCredits + totalCredits;
        
        currGpa = ((currCredits * currGpa) + (newGpa * newCredits));
        currGpa = currGpa / totalCredits;
    }


    /** Setters or Mutators  */

    public void setGPA(double gpa)
    {
        this.currGpa = gpa;
    }

    public void setCredits(int credits)
    {
        this.currCredits = credits;
        this.totalCredits = currCredits;
    }

    /** Getters or Accessors */

    public double getGPA()
    {
        return this.currGpa;
    }

    public int getCredits()
    {
        return this.totalCredits;
    }

    public void calcGPA(double newGpa, int newCredits)
    {
        this.newGpa = newGpa;
        this.newCredits = newCredits;
        totalCredits = totalCredits + newCredits;

        currGpa = ((currCredits * currGpa) + (newGpa * newCredits));
        currGpa = currGpa / totalCredits;
    }

    public String toString()
    {
        String layout;

        layout = String.format(" %-4.2f  | %-3s  |%n", this.currGpa, this.totalCredits);

        return super.toString() + layout;
    }



    public String printStudent()
    {
        String layout;

        layout = String.format(this.getFirstName() + " " + this.getLastName() + " " + this.getStudentID() + " " + "%-4.2f" + " " + this.getCredits() + "\n", this.getGPA());

        return layout;
    }
}
