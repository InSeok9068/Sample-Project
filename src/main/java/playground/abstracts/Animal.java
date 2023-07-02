package playground.abstracts;

import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString
@SuperBuilder
public abstract class Animal {
    private final String name;

    public abstract void makeSound();

    public void eat() {
        System.out.println(name + "은 먹는다.");
    }
}