package net.yoojia.validate.support;

import net.yoojia.validate.internal.Rule;
import net.yoojia.validate.internal.TestResult;

/**
 * author : 桥下一粒砂 (chenyoca@gmail.com)
 * date   : 2013-5-15
 * 测试基类
 */
public abstract class Tester<P> {

    static final String ONLY_STRING_INPUT = "Parameter 'input' ONLY support primitive type.";

	public final Rule rule;

    protected P[] args;
    protected String customMessage;

    /**
     * 设置自定义消息，此消息在 TestResult 中返回
     * @param customMessage 消息
     */
    public void setCustomMessage(String customMessage) {
        this.customMessage = customMessage;
    }

    /**
	 * 使用公共接口实现的自定义Tester被标识为Custom规则类型
	 */
	public Tester(){
		this(Rule.Custom);
	}
	
	/**
	 * @param rule 内建Tester要标识其所属规则类型
	 */
	Tester(Rule rule){
		this.rule = rule;
	}
	
	/**
	 * 执行测试
	 * @param input 请求测试的数据。此参数首先被过滤，在被传入测试对象时，必定不为null。
	 * @return 如果测试通过，返回TestResult.passed为true的对象。否则，返回TestResult.passed为true的对象，并中TestResult.message中描述出错原因或者提示语。
	 *
	 */
	public abstract TestResult test(Object input);

    /**
     * 根据各个测试对象不同，其它测试参数由此对象数组传入。自定义测试类中，此参数为null。
     * @param args 参数
     */
    public void setParameters(P... args){
        this.args = args;
    }

}
