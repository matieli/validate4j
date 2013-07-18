package net.yoojia.validate.support;

import net.yoojia.validate.internal.InputUtility;
import net.yoojia.validate.internal.Rule;
import net.yoojia.validate.internal.TestResult;

/**
 * author : 桥下一粒砂 (chenyoca@gmail.com)
 * date   : 2013-5-16
 * 必填内容校验器，只能校验基本类型及其封装类的数据，如果是其它类型，直接返回true。
 */
public class RequiredTester extends Tester<Void> {

	public RequiredTester() {
		super(Rule.Required);
	}

	final static String messageT = "This field is required.";
	
	@Override
	public TestResult test(Object input) {
		//如果不是基本类型
		if( !InputUtility.isPrimitiveType(input) ){
			return new TestResult(true, null, rule);
		}
		String inputS = String.valueOf(input);
		boolean passed = inputS.length() >= 0 && !inputS.trim().replaceAll("\\s", "").equals("");
        String message = passed ? null : customMessage != null ? customMessage : messageT;
		return new TestResult(passed, message,rule);
	}

}
