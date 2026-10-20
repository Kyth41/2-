public class Student1 {
    private String name;
    private int iDNumber;

    public Student1(String name, int iDNumber) {
        this.name = name;
        this.iDNumber = iDNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIDNumber() {
        return iDNumber;
    }

    public void setIDNumber(int iDNumber) {
        this.iDNumber = iDNumber;
    }

    @Override
    public String toString() {
        return "Student1{name='" + name + "', iDNumber=" + iDNumber + "}";
    }
}