package edu.eci.cvds.tdd.registry;

import org.junit.Assert;
import org.junit.Test;

public class RegistryTest {

    private final Registry registry = new Registry();
    // @Test
    // public void validateRegistryResult() {
    //
    //     Person person = new Person();
    //
    //     RegisterResult result = registry.registerVoter(person);
    //
    //     Assert.assertEquals(RegisterResult.VALID, result);
    // }

    // TODO Complete with more test cases

    //Only valid voters will be registered
        //Person who is adult
    @Test
    public void validateUnderageVoterRegistry17() {
        Person person = new Person("Marcos Gonzalez", 1000000000, 17, Gender.MALE, true);

        RegisterResult result = registry.registerVoter(person);

        Assert.assertEquals(RegisterResult.UNDERAGE, result);
    }
    @Test
    public void validateUnderageVoterRegistry18() {
        Person person = new Person("Sofia Gonzalez", 1000000001, 18, Gender.FEMALE, true);

        RegisterResult result = registry.registerVoter(person);

        Assert.assertEquals(RegisterResult.VALID, result);
    }
    @Test
    public void validateUnderageVoterRegistry19() {
        Person person = new Person("Julia Velez", 1000000002, 19, Gender.FEMALE, true);

        RegisterResult result = registry.registerVoter(person);

        Assert.assertEquals(RegisterResult.VALID, result);
    }
        //Person who is alive
    @Test
    public void validateDeadVoterRegistry() {
        Person person = new Person("Marcos Ruiz", 1000000003, 18, Gender.MALE, false);

        RegisterResult result = registry.registerVoter(person);

        Assert.assertEquals(RegisterResult.DEAD, result);
    }
    @Test
    public void validateAliveVoterRegistry() {
        Person person = new Person("Diego Rey", 1000000004, 18, Gender.MALE, true);

        RegisterResult result = registry.registerVoter(person);

        Assert.assertEquals(RegisterResult.VALID, result);
    }
        //Person can't has negative age
    @Test
    public void validateNotNegativeAgeVoterRegistryNegative() {
        Person person = new Person("Daniela Rico", 1000000005, -1, Gender.FEMALE, true);

        RegisterResult result = registry.registerVoter(person);

        Assert.assertEquals(RegisterResult.INVALID_AGE, result);
    }
    @Test
    public void validateNotNegativeAgeVoterRegistry0() {
        Person person = new Person("DanieL Rico", 1000000006, 0, Gender.MALE, true);

        RegisterResult result = registry.registerVoter(person);

        Assert.assertEquals(RegisterResult.UNDERAGE, result);
    }
        //Person name can't be void
    @Test
    public void validateNotNegativeAgeVoterRegistryPositive() {
            Person person = new Person("", 1000000007, 18, Gender.FEMALE, true);

            RegisterResult result = registry.registerVoter(person);

            Assert.assertEquals(RegisterResult.NOT_VOID_NAME, result);
        }

    //Only one inscription per Identification Document
        //Person who has Unique Identification Document
    @Test
    public void validateDuplicatedVoterRegistryTrue() {
        Person person = new Person("Diego Rey", 1000000008, 18, Gender.MALE, true);

        RegisterResult result = registry.registerVoter(person);

        Person person1 = new Person("Diego Rey", 1000000008, 18, Gender.MALE, true);

        RegisterResult result1 = registry.registerVoter(person1);

        Assert.assertEquals(RegisterResult.DUPLICATED, result1);
    }
    @Test
    public void validateDuplicatedVoterRegistryFalse() {
        Person person = new Person("Daniela Rey", 1000000009, 18, Gender.FEMALE, true);

        RegisterResult result = registry.registerVoter(person);

        Assert.assertEquals(RegisterResult.VALID, result);
    }
}