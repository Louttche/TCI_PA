package tci.demo.week1.schoolassignment;

/**
 * A Course is an IMMUTABLE object with a given name, code and ec.
 * It's uniquely identified by it's course code (a string).
 * the name of the course (a string) should not be null
 * code should be 3 or 4 characters long and is in upper case
 * the number of EC's (ec) is a positive whole number.
 * If above parametes are wrong, an IllegalArgumentException should be thrown during construction.
 */

public class Course {
    // TODO: create code which complies with the specification above,
    // and uses the method calls below (add methods if you think they
    // are necessary (they are!).

    private final String Name;
    private final Integer Ec;
    private final String Code;

    /**
     *
     * @should only take in valid values
     * @should throw IllegalArgumentException if name is null
     * @should throw IllegalArgumentException if code is shorter or longer
     * @should throw IllegalArgumentException if code is not in uppercase
     * @should throw IllegalArgumentException if ec is negative
     */
    public Course(String name, Integer ec, String code) throws IllegalArgumentException{
        if (name == null)
            throw new IllegalArgumentException("Name can't be null");
        if ((code.length() < 3) || (code.length() > 4))
            throw new IllegalArgumentException("Code needs to be between 3 and 4 characters");
        if (!code.toUpperCase().equals(code))
            throw new IllegalArgumentException("Code needs to be between 3 and 4 characters");
        if (ec < 0)
            throw  new IllegalArgumentException("EC can't be a negative number");

        Name = name;
        Ec = ec;
        Code = code;
    }

    public Integer getEc() {
        return this.Ec;
    }

    public String getName() {
        return this.Name;
    }

    public String getCode() {
        return this.Code;
    }

  /******************************************************
   *
   *   GETTERS/SETTERS CODE CAN BE GENERATED BY INTELLIJ,
   *   AND UNTOUCHED BY PEOPLE.
   *   THE BEHAVIOUR OF THIS CODE DOES NOT HAVE TO BE TESTED.
   *
   ********************************************************/
}

/*
*
* Note: An IMMUTABLE object is mostly used for transfering data between layers in your software
* , so it only has a constructor which sets ALL attributes, and it has getters (generated by the IDE)
* for all of the attributes.
* (this is a so called DTO: Data Transfer Object)
* 
*
 */

