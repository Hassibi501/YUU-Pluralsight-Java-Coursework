package com.pluralsight;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HelperTest {

    @Test
    void fullname() {
        // arrange
        String firstname = "Hassieb";
        String lastname = "Hassieb";
        String expectedFullName = "Hassieb Hassieb";

        // act
        String result = Helper.fullname(firstname, lastname);

        // assert
        assertEquals(expectedFullName, result);

    }
}