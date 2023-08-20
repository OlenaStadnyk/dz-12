package cc.robotdreams;

import java.util.Collections;
import java.util.List;

class Person {
    private static int ID = 1;
    private static int nextID = 1;
    protected String firstName;
    protected String lastName;
    protected int age;
    protected Person partner;
    protected String occupation;
    protected boolean hasChildren;
    protected String pets;
    protected boolean hasRetirementAge;

    public void printDetails() {
        System.out.println("Person:");
        System.out.println("ID: " + getID());
        System.out.println("Name: " + getFullName());
        System.out.println("Age: " + getAge());
        System.out.println("Occupation: " + getOccupation());
        System.out.println("Has Children: " + hasChildren());
        System.out.println("Pets: " + getPets());
        System.out.println("Has Retirement Age: " + hasRetirementAge);
        System.out.println();
    }

    // Constants for retirement age
    private static final int RETIREMENT_AGE_WOMAN = 60;
    private static final int RETIREMENT_AGE_MALE = 65;

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.partner = null;
        this.hasRetirementAge = false;
    }
    // Method to assign a unique ID to each person
    public void assignID() {
        this.ID = nextID;
        nextID++;
    }

    public int getID() {
        return ID;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public int getAge() {
        return age;
    }

    public List<String> getPets() {
        // Implement logic to return the list of pets for the person
        return Collections.singletonList(pets);
    }

    public String getOccupation() {
        return occupation;
    }

    public boolean hasChildren() {
        return hasChildren;
    }


    // Updated introduce method to remove the unnecessary greeting
    public String introduce() {
        return firstName + " " + lastName + ", age: " + age + ".";
    }

    public boolean isAdult() {
        return age >= 18;
    }

    // Setter for hasRetirementAge
    public void setHasRetirementAge(boolean hasRetirementAge) {
        this.hasRetirementAge = hasRetirementAge;
    }

    public void checkAndSetRetirementAge() {
        if (this instanceof Woman) {
            setHasRetirementAge(getAge() >= RETIREMENT_AGE_WOMAN);
        } else if (this instanceof Man) {
            setHasRetirementAge(getAge() >= RETIREMENT_AGE_MALE);
        }
    }
    public Person getPartner() {
        return partner;
    }

    public void registerPartnership(Person partner) {
        this.partner = partner;
        partner.partner = this;  // Set the partner for the given partner as well
    }

    // part for divorce
    public void deregisterPartnership(boolean unsetPartner) {
        if (partner != null) {
            if (this instanceof Woman) {
                Woman woman = (Woman) this;
                woman.lastNameBeforeMarriage = woman.lastName;
            }
            if (unsetPartner) {
                partner.partner = null;  // Unset the partner for the given partner as well
            }
            partner = null;
        }
    }
}
