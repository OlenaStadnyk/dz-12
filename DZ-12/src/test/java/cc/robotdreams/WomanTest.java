package cc.robotdreams;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;
import org.testng.annotations.DataProvider;

import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;

public class WomanTest {

    @ParameterizedTest
    @CsvSource({
            "Jassica, Clapton, 35, Matthew, Grey, 38",
            "Monica, Cupper, 25, Yan, Presly, 28"
    })
    public void testRegisterPartnership(String womanFirstName, String womanLastName, int womanAge,
                                        String manFirstName, String manLastName, int manAge) {
        Woman woman = new Woman(womanFirstName, womanLastName, womanAge);
        Man man = new Man(manFirstName, manLastName, manAge);

        woman.registerPartnership(man);

        assertEquals(man, woman.getPartner());
        assertEquals(woman, man.getPartner());
        assertEquals(man.getLastName(), woman.getLastName());
    }

    @Test
    public void testDeregisterPartnership() {
        Woman woman = new Woman("Monica", "Cupper", 25);
        Man man = new Man("Yan", "Presly", 28);

        woman.registerPartnership(man);

        String previousLastName = woman.getLastNameBeforeMarriage(); // Store the previous last name

        woman.deregisterPartnership(true); // Deregister partnership and unset partner

        assertNull(woman.getPartner());
        assertNull(man.getPartner());
        assertEquals(previousLastName, woman.getLastName()); // LastName should be reverted
    }

    @ParameterizedTest
    @CsvSource({
            "shoes, clothing",
            "makeup, electronics"
    })
    public void testAddShoppingPreference(String preference1, String preference2) {
        Woman woman = new Woman("Ashley", "Wilson", 31);
        woman.addShoppingPreference(preference1);
        woman.addShoppingPreference(preference2);

        assertTrue(woman.getShoppingPreferences().contains(preference1));
        assertTrue(woman.getShoppingPreferences().contains(preference2));
        assertFalse(woman.getShoppingPreferences().contains("groceries"));
    }

    @ParameterizedTest
    @CsvSource({
            "makeup, electronics",
            "shoes, accessories"
    })
    public void testGetShoppingPreferences(String preference1, String preference2) {
        Woman woman = new Woman("Ann", "Green", 61);
        woman.addShoppingPreference(preference1);
        woman.addShoppingPreference(preference2);

        assertTrue(woman.getShoppingPreferences().contains(preference1));
        assertTrue(woman.getShoppingPreferences().contains(preference2));
        assertFalse(woman.getShoppingPreferences().contains("home staff"));
    }

    @ParameterizedTest
    @CsvSource({
            "Rachel, Bradley, 40",
            "Monica, Cupper, 25"
    })
    public void testGetFullName(String firstName, String lastName, int age) {
        Woman woman = new Woman(firstName, lastName, age);
        String fullName = woman.getFullName();

        assertEquals(firstName + " " + lastName, fullName);
    }


    @ParameterizedTest
    @MethodSource("provideAgeTestData")
    public void testGetAge(String firstName, String lastName, int age) {
        Woman woman = new Woman(firstName, lastName, age);
        assertEquals(age, woman.getAge());
    }

    private static Stream<Arguments> provideAgeTestData() {
        return Stream.of(
                Arguments.of("Ashley", "Wilson", 31),
                Arguments.of("Ann", "Green", 61)
        );
    }

    @ParameterizedTest
    @MethodSource("provideIntroduceTestData")
    public void testIntroduce(String womanFirstName, String womanLastName, int womanAge,
                              boolean hasPartner, String partnerFirstName, String partnerLastName,
                              String womanOccupation, boolean womanHasChildren) {
        Woman woman = new Woman(womanFirstName, womanLastName, womanAge);
        if (hasPartner) {
            Man partner = new Man(partnerFirstName, partnerLastName, 0);
            woman.registerPartnership(partner);
        }
        woman.setOccupation(womanOccupation);
        woman.setHasChildren(womanHasChildren);

        String introduction = woman.introduce();

        assertTrue(introduction.contains(womanFirstName + " " + womanLastName));
        if (hasPartner) {
            assertTrue(introduction.contains("Married to " + partnerFirstName + " " + partnerLastName));
        } else {
            assertFalse(introduction.contains("Married to"));
        }
        assertTrue(introduction.contains("Occupation: " + womanOccupation));
        assertTrue(introduction.contains("hasChildren: " + womanHasChildren));
    }

    private static Stream<Arguments> provideIntroduceTestData() {
        return Stream.of(
                Arguments.of("Jessica", "Clapton", 35, true, "Matthew", "Clapton", "Doctor", true),
                Arguments.of("Monica", "Cupper", 25, false, null, null, "Seller", false)
        );
    }


    @ParameterizedTest
    @CsvSource({
            "61, true",
            "40, false"
    })
    public void testIsRetired(int age, boolean expectedRetirementStatus) {
        Woman woman = new Woman("Ann", "Green", age);
        assertEquals(expectedRetirementStatus, woman.isRetired());
    }

    @ParameterizedTest
    @CsvSource({
            "Jassica, Clapton, 35",
            "Monica, Cupper, 25"
    })
    public void testGetAddress(String firstName, String lastName, int age) {
        Woman woman = new Woman(firstName, lastName, age);
        woman.setAddress("5th Avenue");
        assertEquals("5th Avenue", woman.getAddress());
    }

    @ParameterizedTest
    @CsvSource({
            "Monica, Cupper, 25",
            "Ann, Green, 61"
    })
    public void testSetAddress(String firstName, String lastName, int age) {
        Woman woman = new Woman(firstName, lastName, age);
        woman.setAddress("Main St");
        assertEquals("Main St", woman.getAddress());
    }

    @ParameterizedTest
    @CsvSource({
            "Ashley, Wilson, 31, hamster, cat",
            "Ann, Green, 61, dog, parrot"
    })
    public void testGetPets(String firstName, String lastName, int age, String pet1, String pet2) {
        Woman woman = new Woman(firstName, lastName, age);
        woman.addPet(pet1);
        woman.addPet(pet2);

        assertTrue(woman.getPets().contains(pet1));
        assertTrue(woman.getPets().contains(pet2));
    }
}

