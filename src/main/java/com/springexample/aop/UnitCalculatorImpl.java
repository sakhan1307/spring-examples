package com.springexample.aop;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
public class UnitCalculatorImpl implements UnitCalculator {
    private Log log = LogFactory.getLog(this.getClass());
    public double kilogramToPound(double kilogram) {
        double pound = kilogram * 2.2;
        log.info(kilogram + " kilogram = " + pound + " pound");
        return pound;
    }

    public double kilometerToMile(double kilometer) {
        double mile = kilometer * 0.62;
        log.info(kilometer + " kilometer = " + mile + " mile");
        return mile;
    }
}
