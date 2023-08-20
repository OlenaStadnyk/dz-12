package cc.robotdreams;

import cc.robotdreams.automation.utils.CSVFileReader;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ManTest {

    @Test
    public void testAddHobbiesFromCSV() throws IOException {
        Man man = new Man("John", "Doe", 30);
        String csvPath = "src/main/resources/DZ-12/testdata.csv";
        CSVFileReader csvFileReader = new CSVFileReader(csvPath);

        try {
            List<String[]> csvData = csvFileReader.readCSV();

            for (String[] hobbies : csvData) {
                for (String hobby : hobbies) {
                    man.addHobbies(hobby);
                }
            }

            List<String> manHobbies = man.getHobbies();
            assertEquals(8, manHobbies.size());
            assertTrue(manHobbies.contains("Reading"));
            assertTrue(manHobbies.contains("Hiking"));
            assertTrue(manHobbies.contains("Football"));
            assertTrue(manHobbies.contains("Swimming"));
            assertTrue(manHobbies.contains("Fishing"));
            assertTrue(manHobbies.contains("Cycling"));
        } catch (IOException e) {
            fail("Exception thrown while reading CSV: " + e.getMessage());
        }
    }


        @ParameterizedTest
        @CsvSource({
                "Gaming, Swimming",
                "Basketball, Running",
                "Tennis, Soccer"
        })
        public void testAddSportsInterest (String interest1, String interest2){
            Man man = new Man("Robert", "Smith", 45);
            man.addSportsInterest(interest1);
            man.addSportsInterest(interest2);
            List<String> sportsInterests = man.getSportsInterests();

            assertEquals(2, sportsInterests.size());
            assertTrue(sportsInterests.contains(interest1));
            assertTrue(sportsInterests.contains(interest2));
        }

        @ParameterizedTest
        @CsvSource({
                "Developer",
                "Doctor",
                "Engineer"
        })
        public void testSetAndGetOccupation (String occupation){
            Man man = new Man("Yan", "Presly", 28);
            man.setOccupation(occupation);

            assertEquals(occupation, man.getOccupation());
        }

        @ParameterizedTest
        @CsvSource({
                "true",
                "false"
        })
        public void testSetAndHasChildren ( boolean hasChildren){
            Man man = new Man("Mike", "Nikols", 65);
            man.setHasChildren(hasChildren);

            assertEquals(hasChildren, man.hasChildren());
        }

        @ParameterizedTest
        @CsvSource({
                "Fish, Cat",
                "Dog, Parrot",
                "Hamster, Rabbit"
        })
        public void testAddPet (String pet1, String pet2){
            Man man = new Man("Matthew", "Grey", 38);
            man.addPet(pet1);
            man.addPet(pet2);
            List<String> pets = man.getPets();

            assertEquals(2, pets.size());
            assertTrue(pets.contains(pet1));
            assertTrue(pets.contains(pet2));
        }

        @ParameterizedTest
        @MethodSource("provideRetirementData")
        public void testIsRetired ( int age, boolean expectedRetirementStatus){
            Man man = new Man("Mike", "Nikols", age);
            assertEquals(expectedRetirementStatus, man.isRetired());
        }

        private static Stream<Object[]> provideRetirementData () {
            return Stream.of(
                    new Object[]{65, true},
                    new Object[]{64, false},
                    new Object[]{70, true},
                    new Object[]{30, false}
            );
        }

        @Test
        public void testIntroduceWithPartner () {
            Man man = new Man("Matthew", "Grey", 38);
            Woman woman = new Woman("Jassica", "Clapton", 35);
            man.registerPartnership(woman);
            woman.registerPartnership(man);

            man.setOccupation("Realtor");
            man.setHasChildren(true);

            String introduction = man.introduce();
            assertTrue(introduction.contains("Married to Jassica Clapton."));
            assertTrue(introduction.contains("Occupation: Realtor"));
            assertTrue(introduction.contains("hasChildren: true"));
        }
    }

