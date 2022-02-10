package edu.eci.cvds.tdd.registry;

import java.util.ArrayList;

public class Registry {
    public ArrayList<Person> personsRegistered = new ArrayList<>();
    public RegisterResult registerVoter(Person p) {

        // TODO Validate person and return real result.

        //We are going to disqualify persons that aren't allow
        if ( !p.isAlive() ){
            return RegisterResult.DEAD;
        }
        else if(p.getAge() >= 0 && p.getAge() < 18){
            return RegisterResult.UNDERAGE;
        }
        else if ( p.getAge() < 0 ){
            return  RegisterResult.INVALID_AGE;
        }
        else if( p.getName().isEmpty() ){
            return RegisterResult.NOT_VOID_NAME;
        }
        for (Person person: personsRegistered) {
            if( person.getId() == p.getId() ){
                return RegisterResult.DUPLICATED;
            }
        }
        //the last option is that the person is registered
        personsRegistered.add(p);
        return RegisterResult.VALID;
    }
}