package net.yoojia.validate.support;

import net.yoojia.validate.internal.Rule;
import net.yoojia.validate.internal.TestResult;

/**
 * author : 桥下一粒砂 (chenyoca@gmail.com)
 * date   : 2013-5-16
 * 使用正则进行测试的抽象类
 */
public abstract class TesterWithRegex extends Tester<Void> {
	
	private final String regex;
	private final String messageT;
	
	TesterWithRegex(Rule rule,String regex,String messageT){
		super(rule);
		this.regex = regex;
		this.messageT = messageT;
	}

	@Override
	public TestResult test(Object input) {
		String inputS = String.valueOf(input);
	    boolean passed = inputS.matches(regex);
	    String message = passed ? null : customMessage != null ? customMessage : messageT;
	    return new TestResult(passed, message, rule);
	}

}
