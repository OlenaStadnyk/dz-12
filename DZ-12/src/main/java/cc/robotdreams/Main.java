package cc.robotdreams;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Man johnDoe = new Man("John", "Doe", 30);
        johnDoe.addSportsInterest("football");
        johnDoe.addPet("dog");
        johnDoe.setOccupation("engineer");
        johnDoe.setHasChildren(false);
        johnDoe.addHobbies("reading");
        johnDoe.checkAndSetRetirementAge();

        Man robertSmith = new Man("Robert", "Smith", 45);
        robertSmith.addSportsInterest("volleyball");
        robertSmith.addPet("cat");
        robertSmith.setOccupation("doctor");
        robertSmith.setHasChildren(true);
        robertSmith.addHobbies("gaming");
        robertSmith.checkAndSetRetirementAge();

        Woman jassicaClapton = new Woman("Jessica", "Clapton", 35);
        jassicaClapton.addShoppingPreference("food");
        jassicaClapton.addPet("fish");
        jassicaClapton.setOccupation("doctor");
        jassicaClapton.setHasChildren(true);
        jassicaClapton.checkAndSetRetirementAge();

        Woman monicaCupper = new Woman("Monica", "Cupper", 25);
        monicaCupper.addShoppingPreference("juice & water");
        monicaCupper.addPet("cat");
        monicaCupper.setOccupation("seller");
        monicaCupper.setHasChildren(false);
        monicaCupper.checkAndSetRetirementAge();

        Man yanPresly = new Man("Yan", "Presly", 28);
        yanPresly.addSportsInterest("golf");
        yanPresly.addPet("");
        yanPresly.setOccupation("developer");
        yanPresly.setHasChildren(false);
        yanPresly.addHobbies("poker");
        yanPresly.checkAndSetRetirementAge();

        Woman rachelBradley = new Woman("Rachel", "Bradley", 40);
        rachelBradley.addShoppingPreference("care products");
        rachelBradley.addPet("yoga instructor");
        rachelBradley.setOccupation("true");
        rachelBradley.setHasChildren(true);
        rachelBradley.checkAndSetRetirementAge();

        Man mikeNikols = new Man("Mike", "Nikols", 65);
        mikeNikols.addSportsInterest("baseball");
        mikeNikols.addPet("parrot");
        mikeNikols.setOccupation("manager");
        mikeNikols.setHasChildren(true);
        mikeNikols.addHobbies("barbecue");
        mikeNikols.checkAndSetRetirementAge();

        Woman annGreen = new Woman("Ann", "Green", 61);
        annGreen.addShoppingPreference("makeup");
        annGreen.addPet("dog");
        annGreen.setOccupation("blogger");
        annGreen.setHasChildren(true);
        annGreen.checkAndSetRetirementAge();

        Man matthewGrey = new Man("Matthew", "Grey", 38);
        matthewGrey.addSportsInterest("tennis");
        matthewGrey.addPet("fish");
        matthewGrey.setOccupation("realtor");
        matthewGrey.setHasChildren(true);
        matthewGrey.addHobbies("cycling");
        matthewGrey.checkAndSetRetirementAge();

        Woman ashleyWilson = new Woman("Ashley", "Wilson", 31);
        ashleyWilson.addShoppingPreference("Shoes");
        ashleyWilson.addPet("hamster");
        ashleyWilson.setOccupation("project manager");
        ashleyWilson.setHasChildren(true);
        ashleyWilson.checkAndSetRetirementAge();

        // Automatically assigning IDs
        johnDoe.assignID();
        robertSmith.assignID();
        jassicaClapton.assignID();
        monicaCupper.assignID();
        yanPresly.assignID();
        rachelBradley.assignID();
        mikeNikols.assignID();
        annGreen.assignID();
        matthewGrey.assignID();
        ashleyWilson.assignID();

        // Printing details for each person
        System.out.println("Man:");
        printPersonDetails(johnDoe);
        printPersonDetails(robertSmith);
        printPersonDetails(yanPresly);
        printPersonDetails(mikeNikols);
        printPersonDetails(matthewGrey);

        System.out.println("\nWoman:");
        printPersonDetails(jassicaClapton);
        printPersonDetails(monicaCupper);
        printPersonDetails(rachelBradley);
        printPersonDetails(annGreen);
        printPersonDetails(ashleyWilson);

        // establish a partnership between Matthew Grey & Jassica Clapton
        matthewGrey.registerPartnership(jassicaClapton);

        // establish a partnership between Yan Presly & Monica Cupper
        yanPresly.deregisterPartnership(true);

        // establish a partnership between Mike Nikols & Ann Green
        mikeNikols.registerPartnership(annGreen);

        // Display partnerships
        System.out.println("\nRelationships:");
        System.out.println(jassicaClapton.getFullName() + " and " + matthewGrey.getFullName() + " are married.");

        // Display divorces
        //System.out.println("\nDivorces:");
        //System.out.println(monicaCupper.getFullName() + " and " + yanPresly.getFullName() + " got divorced. " +
        // monicaCupper.getFullName() + " reverted back to her previous last name " + monicaCupper.getPreviousLastName());
        //}

        // Display divorces
        System.out.println("\nDivorces:");
        String divorceInfo = monicaCupper.getFullName() + " and " + yanPresly.getFullName() + " got divorced. ";
        String previousLastName = monicaCupper.getLastNameBeforeMarriage();
        if (previousLastName != null) {
            System.out.println(divorceInfo + monicaCupper.getFullName() + " reverted back to her previous last name: " + previousLastName);
        } else {
            System.out.println(divorceInfo + monicaCupper.getFullName() + " reverted back to her previous last name: " + monicaCupper.getLastName());
        }
    }


    // Method to print details of a person
    private static void printPersonDetails(Person person) {
        String hasRetirementAge = person.hasRetirementAge ? "true" : "false";
        String partnerDetails = person.getPartner() != null ? ", Partner: " + person.getPartner().getFullName() : "";
        System.out.println(person.getFullName() + ", Age: " + person.getAge() + ", hasRetirementAge: " + hasRetirementAge + partnerDetails);

        // Gender-specific details
        if (person instanceof Man) {
            Man man = (Man) person;
            List<String> hobbies = man.getHobbies();
            System.out.println("  Hobbies: " + hobbies);
            List<String> sportsInterests = man.getSportsInterests();
            System.out.println("  Sports Interests: " + sportsInterests);
        } else if (person instanceof Woman) {
            Woman woman = (Woman) person;
            System.out.println("  ShoppingPreference: " + woman.getShoppingPreferences());
            Person partner = woman.getPartner();
            if (partner != null) {
                System.out.println("  Married to: " + partner.getFullName());
                if (!woman.getLastName().equals(partner.getLastName())) {
                    System.out.println("  " + woman.getFirstName() + " took " + partner.getLastName() + "'s name.");
                }
            } else {
                String lastNameBeforeMarriage = woman.getLastNameBeforeMarriage();
                if (lastNameBeforeMarriage == null) {
                    System.out.println("  Current Last Name: " + woman.getLastName());
                } else {
                    System.out.println("  Divorced, Current Last Name: " + lastNameBeforeMarriage);
                }
            }
        }

        System.out.println("  Pet: " + person.getPets());
        System.out.println("  Occupation: " + person.getOccupation());
        System.out.println("  hasChildren: " + person.hasChildren());
        System.out.println();
    }

}
