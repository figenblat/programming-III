interface StudentDataInterface {

    public String getName();

    public int getID();

    public double getGPA();

    public String getBirthday();

    public String getYear();

}

// public class (implemented primarilly in final app week)

public class StudentData implements StudentDataInterface {
    private String Name;
    private int Id;
    private double GPA;
    public String Birthday;
    public String Year;


    public StudentData(String name, int id, double gpa, String birthday, String year) {
        Name = name;
        Id = id;
        GPA = gpa;
        Birthday = birthday;
        Year = year;
    }
    @Override
    public String getName() { return Name;}

    @Override
    public int getID() {return Id;}

    @Override
    public double getGPA() {return GPA;}

    @Override
    public String getBirthday() {return Birthday;}

    @Override
    public String getYear() {return Year;}

}
