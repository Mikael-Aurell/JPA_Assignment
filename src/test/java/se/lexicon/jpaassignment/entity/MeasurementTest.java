package se.lexicon.jpaassignment.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MeasurementTest {
    Measurement testObject;

    @BeforeEach
    public void setup(){
        testObject = Measurement.KG;
    }

    @Test
    @DisplayName("Test 1 Created Object")
    public void test_successfully_created(){
        assertEquals("kg",testObject.getTypeCode());
    }

}
