package net.yoojia.validate.support;

import net.yoojia.validate.internal.Rule;
import net.yoojia.validate.internal.TestResult;

/**
 * author : 桥下一粒砂 (chenyoca@gmail.com)
 * date   : 2013-5-16
 * 最小值验证器
 */
public class ValueMinTester extends Tester<Double> {

    final static String messageT = "Please enter a value greater than or equal to %.2f .";

    public ValueMinTester() {
        super(Rule.ValueMin);
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
        boolean passed = inputD >= minValue;
        String message = passed ? null :
                customMessage != null ?
                        String.format(customMessage, minValue) :
                        String.format(messageT, minValue);
        return new TestResult(passed,message,rule);
    }
}
