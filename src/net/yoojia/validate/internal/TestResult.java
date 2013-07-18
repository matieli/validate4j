package net.yoojia.validate.internal;

/**
 * author : 桥下一粒砂 (chenyoca@gmail.com)
 * date   : 2013-5-14
 * 测试结果
 */
public class TestResult {

    /* 测试通过标识 */
	public final boolean passed;

    /* 测试结果消息 */
	public final String message;

    /* 测试的规则 */
    public final Rule rule;
	
	public TestResult(boolean passed, String message, Rule rule){
		this.passed = passed;
		this.message = message;
        this.rule = rule;
	}

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("TestResult { ");
        builder.append("rule:").append(rule.name()).append(" ,");
        builder.append("passed:").append(passed).append(" ,");
        builder.append("message:").append(message).append(" ");
        return builder.append(" }").toString();
    }
}
