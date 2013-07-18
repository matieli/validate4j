package net.yoojia.validate.support;

import net.yoojia.validate.internal.Rule;
import net.yoojia.validate.internal.TestResult;

/**
 * author : 桥下一粒砂 (chenyoca@gmail.com)
 * date   : 2013-5-16
 * 最大值验证器
 */
public class ValueMaxTester extends Tester<Double> {

    final static String messageT = "Please enter a value less than or equal to %.2f .";

    public ValueMaxTester() {
        super(Rule.ValueMax);
    }

    @Override
    public TestResult test(Object input) {
        double inputD ;
        try {
            inputD = Double.valueOf(String.valueOf(input));
        }catch (ClassCastException e){
            return new TestResult(false,"not_a_value_input",rule);
        }
        double maxValue = args[0];
        boolean passed = inputD <= maxValue;
        String message = passed ? null :
                customMessage != null ?
                        String.format(customMessage, maxValue) :
                        String.format(messageT, maxValue);
        return new TestResult(passed,message,rule);
    }
}
