package playground.abstracts.charge;

public interface ChargeInterface {

    default void preCharge() {

    }

    void charge();

    default void afterCharge() {

    }

    default void pay() {
        preCharge();
        charge();
        afterCharge();
    }
}
