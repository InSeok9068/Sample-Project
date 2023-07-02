package playground.abstracts.charge;

public class ChargeForInterface implements ChargeInterface {
    @Override
    public void preCharge() {
        System.out.println("Pre-Charging");
    }

    @Override
    public void charge() {
        System.out.println("Charging");
    }
}
