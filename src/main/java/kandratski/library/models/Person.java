package kandratski.library.models;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class Person {

    private int personId;
    @NotBlank(message = "Author cannot be blank")
    @Size(min = 2, max = 30, message = "Author name must be between 2 and 30 characters")
    private String fullName;
    @Min(value = 1910, message = "Year of publishing should not be less than 1910")
    @Max(value = 2020, message = "Year of publishing should not be more than 2020")
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
