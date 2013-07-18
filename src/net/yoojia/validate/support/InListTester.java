package net.yoojia.validate.support;

import net.yoojia.validate.internal.Rule;
import net.yoojia.validate.internal.TestResult;

/**
 * author : 桥下一粒砂 (chenyoca@gmail.com)
 * date   : 13-5-17
 * 在列表中验证器
 */
public class InListTester extends Tester<Object> {

    public static final String messageT = "This field not in accept list.";

    public InListTester() {
        super(Rule.InList);
    }

    @Override
    public TestResult test(Object input) {
        boolean passed = false;
        for(Object item : args){
            passed |= (item == input || item.equals(input));
        }
        String message = passed ? null : customMessage != null ? customMessage : messageT;
        return new TestResult(passed, message,rule);
    }

}
