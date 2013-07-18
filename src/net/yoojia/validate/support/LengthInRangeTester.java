package net.yoojia.validate.support;

import net.yoojia.validate.internal.Rule;
import net.yoojia.validate.internal.TestResult;

/**
 * author : 桥下一粒砂 (chenyoca@gmail.com)
 * date   : 2013-5-15
 * 长度区间校验器
 */
public class LengthInRangeTester extends Tester<Integer> {

	final static String messageT = "Please enter characters in [ %d, %d ].";
	
	public LengthInRangeTester() {
		super(Rule.LengthInRange);
	}
	
	@Override
	public TestResult test(Object input) {
        final String inputS = String.valueOf(input);
		final int length = inputS.length();
		final int minLength = args[0];
		final int maxLength = args[1];
		boolean passed = (length >= minLength && length <= maxLength);
        String message = passed ? null :
                customMessage != null ?
                String.format(customMessage, minLength,maxLength) :
                        String.format(messageT, minLength,maxLength);
		return new TestResult(passed, message,rule);
	}

}
