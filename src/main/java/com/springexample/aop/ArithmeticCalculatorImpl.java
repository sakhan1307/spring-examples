package com.springexample.aop;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ArithmeticCalculatorImpl implements ArithmeticCalculator {

    private Log log = LogFactory.getLog(this.getClass());

    public double add(double a, double b) {
        double result = a + b;
        //log.info(a + " + " + b + " = " + result);
        return result;
    }

    public double sub(double a, double b) {
        double result = a - b;
       // log.info(a + " - " + b + " = " + result);
        return result;
    }

    public double mul(double a, double b) {
        double result = a * b;
      //log.info(a + " * " + b + " = " + result);
        return result;
    }

    public double div(double a, double b) {
        if (b == 0) {
            throw new IllegalArgumentException("Division by zero");
        }
        double result = a / b;
        //log.info(a + " / " + b + " = " + result);
        return result;
    }
}
