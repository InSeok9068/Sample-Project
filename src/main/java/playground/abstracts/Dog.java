package playground.abstracts;

import lombok.experimental.SuperBuilder;

@SuperBuilder
public class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println(getName() + "은 멍하고 짖는다.");
    }
}
