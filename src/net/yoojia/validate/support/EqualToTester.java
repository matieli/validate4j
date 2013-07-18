package net.yoojia.validate.support;

import net.yoojia.validate.internal.InputUtility;
import net.yoojia.validate.internal.Rule;
import net.yoojia.validate.internal.TestResult;

/**
 * author : 桥下一粒砂 (chenyoca@gmail.com)
 * date   : 2013-5-16
 * 判断两个参数是否相等
 */
public class EqualToTester extends Tester<Object> {

    final static String messageT = "Please enter the same value again.";

    public EqualToTester() {
        super(Rule.EqualTo);
    }

    @Override
    public TestResult test(Object input) {
        Object equalsTo = args[0];
		boolean passed;
		if( equalsTo.getClass() != input.getClass() ){
			passed = (InputUtility.isValueType(input) && InputUtility.isValueType(equalsTo)) &&
					Double.valueOf(String.valueOf(input)).equals(Double.valueOf(String.valueOf(equalsTo)));
		}else{
			passed = equalsTo == input || equalsTo.equals(input);
		}
        String message = passed ? null : customMessage != null ? customMessage : messageT;
        return new TestResult(passed,message,rule);
    }
}
