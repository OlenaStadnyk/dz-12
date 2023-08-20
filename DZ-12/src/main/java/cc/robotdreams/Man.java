package cc.robotdreams;

import java.util.ArrayList;
import java.util.List;

public class Man extends Person {
    private String gender;
    private List<String> sportsInterests;
    private List<String> hobbies;
    private String occupation;
    private boolean hasChildren;
    private List<String> pets;

    private static final int RETIREMENT_AGE_MALE = 65;

    public Man(String firstName, String lastName, int age) {
        super(firstName, lastName, age);
        this.gender = "man";
        this.sportsInterests = new ArrayList<>();
        this.hobbies = new ArrayList<>();
        this.occupation = "";
        this.hasChildren = false;
        this.pets = new ArrayList<>();
    }

    public void addHobbies(String hobby) {
        hobbies.add(hobby);
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public void printDetails() {
        System.out.println("Man:");
        System.out.println(getID() + ". " + getFullName() + ", Age: " + getAge() + ", hasRetirementAge: " + isRetired());
        System.out.println("  Hobbies: " + hobbies);
        System.out.println("  Sports Interests: " + sportsInterests);
        System.out.println("  Occupation: " + occupation);
        System.out.println("  Has Children: " + hasChildren);
        System.out.println("  Pets: " + pets);
    }

    // Getter and Setter for sports interests
    public void addSportsInterest(String interest) {
        sportsInterests.add(interest);
    }

    public List<String> getSportsInterests() {
        return sportsInterests;
    }

    // Getter and Setter for occupation
    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    // Getter and Setter for hasChildren
    public boolean hasChildren() {
        return hasChildren;
    }

    public void setHasChildren(boolean hasChildren) {
        this.hasChildren = hasChildren;
    }

    // Getter and Setter for Pets
    public List<String> getPets() {
        return pets;
    }

    public void addPet(String pet) {
        pets.add(pet);
    }

    // Method to check if a man is a pensioner
    public boolean isRetired() {
        return getAge() >= RETIREMENT_AGE_MALE;
    }

    @Override
    public String introduce() {
        String info = super.introduce();
        if (partner != null) {
            Woman woman = (Woman) partner;
            info += " Married to " + woman.getFirstName() + " " + woman.getLastName() + ".";
        }
        return info + " Occupation: " + occupation + ", hasChildren: " + hasChildren + ".";
    }
    public void registerPartnership(Woman woman) {
        this.partner = woman;
        woman.partner = this;
        // If the wife takes the husband's surname
        this.lastName = woman.lastName;
    }
}
