package playground.abstracts.charge;

public class ChargeForAbstract extends ChargeAbstract {
    @Override
    public void preCharge() {
        System.out.println("Pre-Charging");
    }

    @Override
    public void charge() {
        System.out.println("Charging");
    }
}
