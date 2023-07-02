package playground.abstracts.charge;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class ChargeAbstract implements ChargeInterface {

    @Override
    public void pay() {
        log.info("Paying");
        ChargeInterface.super.pay();
    }
}
