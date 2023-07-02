package playground.abstracts;


import playground.abstracts.animal.Dog;
import playground.abstracts.charge.ChargeForAbstract;
import playground.abstracts.charge.ChargeForInterface;

public class AbstractPlayground {
    public static void main(String[] args) {
        Dog dog = Dog.builder()
                .name("dog")
                .build();

        dog.eat();
        dog.makeSound();

        ChargeForInterface chargeForInterface = new ChargeForInterface();
        chargeForInterface.pay();

        ChargeForAbstract chargeForAbstract = new ChargeForAbstract();
        chargeForAbstract.pay();
    }
}
