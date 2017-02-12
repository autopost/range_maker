package com.example;

import com.example.entity.Range;
import com.example.util.Validator;
import org.junit.Assert;
import org.junit.Test;

public class ValidatorTest {

    @Test
    public void testIsValidRange() throws Exception {
        Assert.assertTrue(Validator.isValidRange("4,4,5-6"));
        Assert.assertFalse(Validator.isValidRange("sdfegfregre"));
        Assert.assertFalse(Validator.isValidRange("A4,A,5-6"));
        Assert.assertFalse(Validator.isValidRange("A,A,5-6"));
        Assert.assertTrue(Validator.isValidRange("1-2"));
        Assert.assertTrue(Validator.isValidRange("432423423"));
        Assert.assertFalse(Validator.isValidRange("1-"));
        Assert.assertFalse(Validator.isValidRange(""));
        Assert.assertFalse(Validator.isValidRange("1,2,5-A"));
        Assert.assertFalse(Validator.isValidRange("2,3-7,y"));

    }

    @Test
    public void testIsValid() throws Exception {
        Range r = new Range();
        r.setDiapasonMin("2");
        r.setDiapasonMax("50");
        r.setRange("4,4,5-6");
        Assert.assertFalse(Validator.isValid(r));
        r.setRange("3,4,5-6");
        Assert.assertTrue(Validator.isValid(r));
        r.setRange("3,4,,5-6");
        Assert.assertFalse(Validator.isValid(r));
        r.setRange("3,4,-5-6");
        Assert.assertFalse(Validator.isValid(r));
        r.setRange("3,4,65-6");
        Assert.assertFalse(Validator.isValid(r));
        r.setRange("3,4,65-66");
        Assert.assertFalse(Validator.isValid(r));
        r.setRange("3,4,5");
        Assert.assertTrue(Validator.isValid(r));
        r.setDiapasonMax("5");
        Assert.assertFalse(Validator.isValid(r));
    }
}
