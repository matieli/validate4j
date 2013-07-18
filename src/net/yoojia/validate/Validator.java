package net.yoojia.validate;

import net.yoojia.validate.internal.Rule;
import net.yoojia.validate.internal.RuleConfigs;
import net.yoojia.validate.internal.TestResult;
import net.yoojia.validate.support.Tester;

import java.util.List;

/**
 * author : 桥下一粒砂 (chenyoca@gmail.com)
 * date   : 2013-5-14
 * Java校验器
 */
public class Validator {

    public static final String MESSAGE_INPUT_NOT_SUPPORT = "input_type_not_support";
    public static final String MESSAGE_NULL_INPUT = "null_input";
    public static final String MESSAGE_TEST_PASSED = "test_passed";

	private final RuleConfigs ruleConfigs;

    private boolean enableLogging = false;
	
	public Validator(){
		ruleConfigs = new RuleConfigs();
	}

	public RuleConfigs ruleConfigs(){
		return ruleConfigs;
	}

    public void enableLogging(){
        enableLogging = true;
    }

    /**
     * 根据给定数据进行校验
     * @param input 需要被校验的数据
     * @return 校验通过返回true，否则返回false。
     */
	public boolean test(Object input){
		return testResult(input).passed;
	}

    /**
     * 根据给定数据进行校验，并返回一个封装校验结果和消息的对象
     * @param input 需要被校验的数据
     * @return 封装校验结果和消息的对象
     */
	public TestResult testResult(Object input){
		TestResult result = new TestResult(true, MESSAGE_TEST_PASSED,Rule.TestPassed);
		if(input == null) {
            return new TestResult(false, MESSAGE_NULL_INPUT,Rule.NullInput);
        }
        Tester requiredTester = null;
		//最先校验Required
		if(ruleConfigs.containsTester(Rule.Required)){

            // 移除Required测试，在下面的Test避免二次校验
			requiredTester = ruleConfigs.removeTester(Rule.Required);
            requiredTester.setCustomMessage(ruleConfigs.getCustomMessage(Rule.Required));
			result = requiredTester.test(input);
            logging(Rule.Required,result);
		}
		//如果Required没有通过，则中断校验，返回结果。
		if( !result.passed ) return result;
		
		List<Tester> testers = ruleConfigs.getTesterChain();
        for(Tester tester : testers){

            try{
                tester.setCustomMessage(ruleConfigs.getCustomMessage(tester.rule));
                tester.setParameters(ruleConfigs.getParameterArgs(tester.rule));
                result = tester.test(input);
            }catch (Throwable exp){
                exp.printStackTrace();
                result = new TestResult(false,MESSAGE_INPUT_NOT_SUPPORT,Rule.NotSupport);
            }
            logging(tester.rule,result);
			if( !result.passed ) break;
        }
        // 如果存在RequestedTest,把它再添加。
        if(requiredTester != null) ruleConfigs.required();
		return result;
	}

    private void logging(Rule rule,TestResult result){
        if(enableLogging){
            System.err.println(":::: Validator :::: Rule = "+rule.name()+", Message = "
                    + ruleConfigs.getCustomMessage(rule));
            System.err.println(":::: Validator :::: "+result);
        }
    }

}
