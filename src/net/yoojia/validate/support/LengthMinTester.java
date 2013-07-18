package net.yoojia.validate.support;

import net.yoojia.validate.internal.Rule;
import net.yoojia.validate.internal.TestResult;

/**
 * author : 桥下一粒砂 (chenyoca@gmail.com)
 * date   : 2013-5-15
 * 最小长度测试校验器
 */
public class LengthMinTester extends Tester<Integer>{
	
	final static String messageT = "Please enter at least %d characters.";

	public LengthMinTester() {
		super(Rule.LengthMin);
	}

	@Override
	public TestResult test(Object input) {
		final int minLength = args[0];
        final String inputS = String.valueOf(input);
		boolean passed = inputS.length() >= minLength;
        String message = passed ? null :
                customMessage != null ?
                String.format(customMessage, minLength) :
                        String.format(messageT, minLength);
		return new TestResult(passed, message,rule);
	}

}
