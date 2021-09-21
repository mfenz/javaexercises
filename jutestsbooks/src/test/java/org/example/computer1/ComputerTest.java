package org.example.computer1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ComputerTest {
    Computer computer;
    @BeforeEach
    public void initForEach(){
        computer = new Computer();
    }

    // Ein Test-Case
    @Test
    public void newComputerMustBeTurnedOff(){
        boolean turnedOff = !computer.isPoweredOn();
        assertTrue(turnedOff,
                "Neuer Computer muss ausgeschaltet sein.");
    }

    @Test
    @DisplayName("Neue Computer müssen 0 Betriebsstunden haben")
    public void newComputerMustHave0OperatingHours(){
        int hours = computer.getOperatingHours();
        assertEquals(0, hours);
    }

    @Test
    public void newComputerMustBeSwitchedOff(){
        Computer computer = new Computer();
        assertFalse(computer.isPoweredOn());
    }
}