package kandratski.library.models;

public class Person {

    private int personId;

    private String fullName;

    private int birthYear;

    public Person() {
    }

    public Person(int personId, String fullName, int birthYear) {
        this.personId = personId;
        this.fullName = fullName;
        this.birthYear = birthYear;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
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
               "person_id=" + personId +
               ", fullName='" + fullName + '\'' +
               ", birthYear=" + birthYear +
               '}';
    }
}
