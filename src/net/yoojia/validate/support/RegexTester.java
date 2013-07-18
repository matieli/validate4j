package net.yoojia.validate.support;

import net.yoojia.validate.internal.InputUtility;
import net.yoojia.validate.internal.Rule;
import net.yoojia.validate.internal.TestResult;

import java.util.regex.Pattern;

/**
 * author : 桥下一粒砂 (chenyoca@gmail.com)
 * date   : 2013-5-16
 * 正则匹配校验器
 */
public class RegexTester extends Tester<String>{

	final static String messageT = "Not match the given regex.";
	
	public RegexTester() {
		super(Rule.Regex);
	}
	
	@Override
	public TestResult test(Object input) {
		
		if( !InputUtility.isPrimitiveType(input) ){
            return new TestResult(false, ONLY_STRING_INPUT, rule);
		}
		
		final String regex = args[0];
		final String inputS = String.valueOf(input);
		Pattern pattern = Pattern.compile(regex);
	    boolean passed = pattern.matcher(inputS).matches();
        String message = passed ? null : customMessage != null ? customMessage : messageT;
	    return new TestResult(passed, message,rule);
	}

}
