package kandratski.library.models;

public class Person {

    private int person_id;

    private String fullName;

    private int birthYear;

    public Person() {
    }

    public Person(int person_id, String fullName, int birthYear) {
        this.person_id = person_id;
        this.fullName = fullName;
        this.birthYear = birthYear;
    }

    public int getPerson_id() {
        return person_id;
    }

    public void setPerson_id(int person_id) {
        this.person_id = person_id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    @Override
    public String toString() {
        return "Person{" +
               "person_id=" + person_id +
               ", fullName='" + fullName + '\'' +
               ", birthYear=" + birthYear +
               '}';
    }
}
