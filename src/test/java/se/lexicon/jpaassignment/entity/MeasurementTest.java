package se.lexicon.jpaassignment.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

public class MeasurementTest {
    Measurement testObject;

    @BeforeEach
    public void setup(){
        testObject = Measurement.KG;
    }

    @Test
    @DisplayName("Test 1 Created Object")
    public void test_successfully_created(){
        assertEquals(9,testObject.getTypeCode());
    }

    @Test
    @DisplayName("Test 2 Setter")
    public void test_setter(){
        testObject.setTypeCode(4);
        assertEquals(4,testObject.getTypeCode());
    }
}
