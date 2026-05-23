// 👉 Write an immutable class with:

// 2 fields (name, age)
// Constructor
// Getter methods

//Also add list 

import java.util.ArrayList;
import java.util.List;

final class ImmutableP{
    private final String name;
    private final int age;
    private final List<String> hobbies;
    
    public ImmutableP(String name,int age){
        this.name = name;
        this.age = age;
        this.hobbies = new ArrayList<>();
    }

    public String getName(){
        return name;
    }

    public int getAge(){
        return age;
    }

    // public List<String> getHobbies(){
    //     return hobbies; // This exposes the internal list, which can be modified by the caller, breaking immutability
    // }

    //Defensive copying to maintain immutability
    public List<String> getHobbies(){
        return new ArrayList<>(hobbies); // Return a copy to maintain immutability
    }
}