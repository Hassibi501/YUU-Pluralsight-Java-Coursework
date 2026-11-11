package com.Pluralsight;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoomTest {
    /*
        isOccupied = false
        isDirty = false
        checkIn makes isOccupied and isDirty true.
     */

    // Naming Convention: MethodName_StateUnderTest_ExpectedBehavior
    @Test
    void checkIn_availableRoom_marksOccupiedAndDirty() {
        // arrange
        Room room = new Room(2, 124, false, false);

        // act
        room.checkIn();

        // assert
        assertTrue(room.isOccupied(), "The room should be occupied");
        assertTrue(room.isDirty(), "The room should be dirty");
    }


    @Test
    void checkIn_roomOccupiedNotDirty_checkInNotAllowed() {
        // arrangechec
        Room room = new Room(2, 124, true, false);

        // act
        room.checkIn();

        // assert
        /*
            if a room is occupied it should have room.isOccupied() = true and room.isDirty() = true
            Since the room started off being occupied but not dirty
            This is an illegal state because if the room is occpied its expected that it will be dirty
            so the expected result should be that it doesnt let you checkIn
            because the internale state of room.isDirty() is false when it should have true
        */
        assertTrue(room.isOccupied(), "The room should be occupied");
        assertFalse(room.isDirty(), "The room should NOT be dirty");
    }



}