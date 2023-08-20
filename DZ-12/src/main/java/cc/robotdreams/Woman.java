package cc.robotdreams;

import java.util.ArrayList;
import java.util.List;

public class Woman extends Person {
    private String gender;
    private List<String> shoppingPreferences;
    private List<String> pets;
    private String occupation;
    private boolean hasChildren;
    Person partner;
    private String previousLastName;
    protected String lastNameBeforeMarriage;
    private String address;

    private static final int RETIREMENT_AGE_WOMAN = 60;

    public Woman(String firstName, String lastName, int age) {
        super(firstName, lastName, age);
        this.gender = "woman";
        this.shoppingPreferences = new ArrayList<>();
        this.pets = new ArrayList<>();
        this.occupation = "";
        this.hasChildren = false;
        this.partner = null;
        this.previousLastName = lastName;
        this.lastNameBeforeMarriage = null;
    }

    public String getLastNameBeforeMarriage() {
        return lastNameBeforeMarriage;
    }

    // Method to set the last name before marriage
    public void setLastNameBeforeMarriage(String lastNameBeforeMarriage) {
        this.lastNameBeforeMarriage = lastNameBeforeMarriage;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public void registerPartnership(Man man) {
        this.partner = man;
        man.partner = this;
        // If the wife takes the husband's surname
        this.lastNameBeforeMarriage = this.lastName; // Store the current last name before the marriage
        this.lastName = man.getLastName();
    }
    // Change private on protected for access in subclass
    public Person getPartner() {
        return partner;
    }


    public void deregisterPartnership(boolean revertLastName) {
        if (partner != null) {
            partner.partner = null;
            partner = null;
            if (revertLastName && lastNameBeforeMarriage != null) {
                lastName = lastNameBeforeMarriage; // Revert to the last name before marriage
                lastNameBeforeMarriage = null; // Reset the previous last name after reverting
            }
        }
    }


    private void revertLastName() {
        // Return to previous surname
        this.lastName = previousLastName;
    }


    public void addShoppingPreference(String preference) {
        shoppingPreferences.add(preference);
    }

    public List<String> getShoppingPreferences() {
        return shoppingPreferences;
    }

    public void addPet(String petName) {
        pets.add(petName);
    }

    public String getPreviousLastName() {
        return lastNameBeforeMarriage != null ? lastNameBeforeMarriage : "N/A";
    }

    @Override
    public String introduce() {
        String info = super.introduce();
        if (partner != null) {
            Man man = (Man) partner;
            info += " Married to " + man.firstName + " " + man.lastName + ".";
            if (!lastName.equals(man.lastName)) {
                info += " " + firstName + " takes " + man.lastName + " name.";
            }
        }
        return info + " Occupation: " + occupation + ", hasChildren: " + hasChildren + ".";
    }

    // Getter and Setter for age (including the field age inherited from Person)
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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

    // Getter and Setter for pets
    public List<String> getPets() {
        return pets;
    }

    public void setPets(List<String> pets) {
        this.pets = pets;
    }

    // Getter and Setter for address
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    // Method to update address
    public void updateAddress(String newAddress) {
        this.address = newAddress; // Method for address updating
    }

    // Method to check if a woman is a pensioner
    public boolean isRetired() {
        return age >= RETIREMENT_AGE_WOMAN;
    }

}
