package net.yoojia.validate.support;

import net.yoojia.validate.internal.Rule;
import net.yoojia.validate.internal.TestResult;

/**
 * author : 桥下一粒砂 (chenyoca@gmail.com)
 * date   : 2013-5-16
 * 最值区间验证器
 */
public class ValueInRangeTester extends Tester<Double> {

    final static String messageT = "Please enter value in [ %.0f, %.0f ].";

    public ValueInRangeTester() {
        super(Rule.ValueInRange);
    }

    @Override
    public TestResult test(Object input) {
        double inputD ;
        try {
            inputD = Double.valueOf(String.valueOf(input));
        }catch (ClassCastException e){
            return new TestResult(false,"not_a_value_input",rule);
        }
        double minValue = args[0];
        double maxValue = args[1];
        boolean passed = (inputD >= minValue && inputD <= maxValue);
        String message = passed ? null :
                customMessage != null ?
                        String.format(messageT, minValue,maxValue) :
                        String.format(messageT, minValue,maxValue);
        return new TestResult(passed,message,rule);
    }
}
