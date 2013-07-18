package net.yoojia.validate.internal;

import net.yoojia.validate.support.*;

import java.util.*;

/**
 * author : 桥下一粒砂 (chenyoca@gmail.com)
 * date   : 2013-5-14
 * 规则配置。校验规则由各个规则接口的调用顺序决定，但是，如果使用Required规则，则Required不管顺序如何都最先被校验。
 */
public class RuleConfigs {
	
	private Map<Rule,Object[]> rulesParamArgs = new HashMap<Rule,Object[]>();
	private Map<Rule,String> rulesMessageArgs = new HashMap<Rule,String>();

	private LinkedHashMap<Object,Tester> testerMapping = new LinkedHashMap<Object,Tester>();

	public final List<Tester> getTesterChain(){
		return new ArrayList<Tester>(testerMapping.values());
	}
	
	public final Object[] getParameterArgs(Object tag){
		return rulesParamArgs.get(tag);
	}

    public final String getCustomMessage(Rule rule){
        return rulesMessageArgs.get(rule);
    }
	
	/**
	 * 移除一个Tester
	 * @param ruleOrTag Tester的Rule或者自定义的Tag名
	 * @return 返回被移除的Tester
	 */
	public Tester removeTester(Object ruleOrTag){
		return testerMapping.remove(ruleOrTag);
	}
	
	/**
	 * 是否配置了某个Tester
	 * @param ruleOrTag Tester的Rule或者自定义的Tag名
	 * @return 返回指定的Rule或者Tag已经配置
	 */
	public boolean containsTester(Object ruleOrTag){
        return testerMapping.containsKey(ruleOrTag);
	}

	/**
	 * 自定义校验规则接口，并指定这个接口的Tag
	 * @param tester 规则接口实现
	 * @param tag 标识这个Tester的Tag
	 * @return RuleConfigs对象，用于链式配置。
	 */
	public RuleConfigs custom(Tester<?> tester,String tag){
        if(!containsTester(tag)){
            testerMapping.put(tag,tester);
        }
		return this;
	}

    ////// Build in rules ///////

    /**
     * 自定义测试不通过的消息。必须的字段，不能为空。此规则首先被验证。
     * @param message 自定义消息
     * @return RuleConfigs对象，用于链式配置。
     */
    public RuleConfigs requiredWithMessage(String message){
        rulesMessageArgs.put(Rule.Required,message);
        return required();
    }

	/**
	 * 必须的字段，不能为空。此规则首先被验证。
	 * @return RuleConfigs对象，用于链式配置。
	 */
	public RuleConfigs required() {
        if(!containsTester(Rule.Required)){
            testerMapping.put(Rule.Required, new RequiredTester());
        }
		return this;
	}

    /**
     * 自定义测试不通过的消息。必须输入正确格式的电子邮件地址。
     * @param message 自定义消息
     * @return RuleConfigs对象，用于链式配置。
     */
    public RuleConfigs emailWithMessage(String message) {
        rulesMessageArgs.put(Rule.Email,message);
        return email();
    }

	/**
	 * 必须输入正确格式的电子邮件
	 * @return RuleConfigs对象，用于链式配置。
	 */
	public RuleConfigs email() {
        if(!containsTester(Rule.Email)){
		    testerMapping.put(Rule.Email, new EmailTester());
        }
		return this;
	}

    /**
     * 自定义测试不通过的消息。必须输入正确格式的移动电话号码
     * @param message 自定义消息
     * @return RuleConfigs对象，用于链式配置。
     */
    public RuleConfigs phoneWithMessage(String message){
        rulesMessageArgs.put(Rule.MobilePhone,message);
        return mobilePhone();
    }

	/**
	 * 必须输入正确格式的移动电话号码
	 * @return RuleConfigs对象，用于链式配置。
	 */
	public RuleConfigs mobilePhone(){
        if(!containsTester(Rule.MobilePhone)){
            testerMapping.put(Rule.MobilePhone, new MobilePhoneTester());
        }
		return this;
	}

    /**
     * 自定义测试不通过的消息。必须输入正确格式的网址
     * @param message 自定义消息
     * @return RuleConfigs对象，用于链式配置。
     */
    public RuleConfigs urlWithMessage(String message){
        rulesMessageArgs.put(Rule.URL,message);
        return url();
    }

	/**
	 * 必须输入正确格式的网址
	 * @return RuleConfigs对象，用于链式配置。
	 */
	public RuleConfigs url() {
        if(!containsTester(Rule.URL)){
            testerMapping.put(Rule.URL, new URLTester());
        }
		return this;
	}

    /**
     * 自定义测试不通过的消息。必须输入整数
     * @param message 自定义消息
     * @return RuleConfigs对象，用于链式配置。
     */
    public RuleConfigs digitsWithMessage(String message){
        rulesMessageArgs.put(Rule.Digits,message);
        return this;
    }

	/**
	 * 必须输入整数
	 * @return RuleConfigs对象，用于链式配置。
	 */
	public RuleConfigs digits() {
        if(!containsTester(Rule.Digits)){
            testerMapping.put(Rule.Digits, new DigitsTester());
        }
		return this;
	}

    /**
     * 自定义测试不通过的消息。必须输入合法的数字(负数，小数)
     * @param message 自定义消息
     * @return RuleConfigs对象，用于链式配置。
     */
    public RuleConfigs numericWithMessage(String message){
        rulesMessageArgs.put(Rule.Numeric,message);
        return numeric();
    }

	/**
	 * 必须输入合法的数字(负数，小数)
	 * @return RuleConfigs对象，用于链式配置。
	 */
	public RuleConfigs numeric() {
        testerMapping.put(Rule.Numeric, new NumericTester());
		return this;
	}

    /**
     * 自定义测试不通过的消息。必须输入合法的中国车牌号码
     * @param message 自定义消息
     * @return RuleConfigs对象，用于链式配置。
     */
    public RuleConfigs licensePlateNumberWithMessage(String message){
        rulesMessageArgs.put(Rule.LicensePlateNumber,message);
        return licensePlateNumber();
    }

    /**
     * 中国车牌号码
     * @return RuleConfigs对象，用于链式配置。
     */
    public RuleConfigs licensePlateNumber(){
        if(!containsTester(Rule.LicensePlateNumber)){
            testerMapping.put(Rule.LicensePlateNumber, new LicensePlateNumberTester());
        }
        return this;
    }

    /**
     * 自定义测试不通过的消息。IPv4地址校验
     * @param message 自定义消息
     * @return RuleConfigs对象，用于链式配置。
     */
    public RuleConfigs IPv4WithMessage(String message){
        rulesMessageArgs.put(Rule.IPv4,message);
        return IPv4();
    }

    /**
     * IPv4地址校验
     * @return RuleConfigs对象，用于链式配置。
     */
    public RuleConfigs IPv4(){
        if(!containsTester(Rule.IPv4)){
            testerMapping.put(Rule.IPv4, new IPv4Tester());
        }
        return this;
    }

    /**
     * 自定义测试不通过的消息。必须匹配指定正则表达式
     * @param message 自定义消息
     * @return RuleConfigs对象，用于链式配置。
     */
    public RuleConfigs regexWithMessage(String message,String regex){
        rulesMessageArgs.put(Rule.Regex,message);
        return regex(regex);
    }

	/**
	 * 必须匹配指定正则表达式
	 * @param regex 匹配的正则表达式
	 * @return RuleConfigs对象，用于链式配置。
	 */
	public RuleConfigs regex(String regex) {
        if(!containsTester(Rule.Regex)){
		    testerMapping.put(Rule.Regex,new RegexTester());
		    rulesParamArgs.put(Rule.Regex, new String[]{regex});
        }
		return this;
	}

    /**
     * 自定义测试不通过的消息。必须在此列表中
     * @param message 自定义消息
     * @return RuleConfigs对象，用于链式配置。
     */
    public RuleConfigs inListWithMessage(String message,Object ...list){
        rulesMessageArgs.put(Rule.InList,message);
        return inList(list);
    }

	/**
	 * 必须在此列表中
	 * @param list 列表参数
	 * @return RuleConfigs对象，用于链式配置。
	 */
	public RuleConfigs inList(Object... list) {
        if(!containsTester(Rule.InList)){
            testerMapping.put(Rule.InList,new InListTester());
            rulesParamArgs.put(Rule.InList, list);
        }
		return this;
	}

    /**
     * 自定义测试不通过的消息。输入值必须和#input相同
     * @param message 自定义消息
     * @return RuleConfigs对象，用于链式配置。
     */
    public RuleConfigs equalToWithMessage(String message,Object equalTo){
        rulesMessageArgs.put(Rule.EqualTo,message);
        return equalTo(equalTo);
    }

	/**
	 * 输入值必须和#input相同
	 * @param equalTo 需要被匹配的值
	 * @return RuleConfigs对象，用于链式配置。
	 */
	public RuleConfigs equalTo(Object equalTo) {
        if(!containsTester(Rule.EqualTo)){
            testerMapping.put(Rule.EqualTo,new EqualToTester());
            rulesParamArgs.put(Rule.EqualTo, new Object[]{equalTo});
        }
		return this;
	}

    /**
     * 自定义测试不通过的消息。输入字符串的最小长度
     * @param message 自定义消息
     * @return RuleConfigs对象，用于链式配置。
     */
    public RuleConfigs minLengthWithMessage(String message,int minLength){
        rulesMessageArgs.put(Rule.LengthMin,message);
        return minLength(minLength);
    }

	/**
	 * 输入字符串的最小长度
	 * @param minLength 最小长度
	 * @return RuleConfigs对象，用于链式配置。
	 */
	public RuleConfigs minLength(int minLength) {
        if(!containsTester(Rule.LengthMin)){
            testerMapping.put(Rule.LengthMin,new LengthMinTester());
            rulesParamArgs.put(Rule.LengthMin, new Integer[]{minLength});
        }
		return this;
	}

    /**
     * 自定义测试不通过的消息。输入字符串的最大长度
     * @param message 自定义消息
     * @return RuleConfigs对象，用于链式配置。
     */
    public RuleConfigs maxLengthWithMessage(String message,int maxLength){
        rulesMessageArgs.put(Rule.LengthMax,message);
        return maxLength(maxLength);
    }

	/**
	 * 输入字符串的最大长度
	 * @param maxLength 最大长度
	 * @return RuleConfigs对象，用于链式配置。
	 */
	public RuleConfigs maxLength(int maxLength) {
        if(!containsTester(Rule.LengthMax)){
            testerMapping.put(Rule.LengthMax,new LengthMaxTester());
            rulesParamArgs.put(Rule.LengthMax, new Integer[]{maxLength});
        }
		return this;
	}

    /**
     * 自定义测试不通过的消息。输入长度必须介于 minLength 和 maxLength 之间的字符串 (汉字算一个字符)
     * @param message 自定义消息
     * @return RuleConfigs对象，用于链式配置。
     */
    public RuleConfigs lengthInRangeWithMessage(String message,int minLength, int maxLength){
        rulesMessageArgs.put(Rule.LengthInRange,message);
        return lengthInRange(minLength, maxLength);
    }

	/**
	 * 输入长度必须介于 minLength 和 maxLength 之间的字符串 (汉字算一个字符)
	 * @param minLength 最小长度
	 * @param maxLength 最大长度
	 * @return RuleConfigs对象，用于链式配置。
	 */
	public RuleConfigs lengthInRange(int minLength, int maxLength) {
        if(!containsTester(Rule.LengthInRange)){
            testerMapping.put(Rule.LengthInRange,new LengthInRangeTester());
            rulesParamArgs.put(Rule.LengthInRange, new Integer[]{minLength,maxLength});
        }
		return this;
	}

    /**
     * 自定义测试不通过的消息。输入值不能大于maxValue
     * @param message 自定义消息
     * @return RuleConfigs对象，用于链式配置。
     */
    public RuleConfigs maxValueWithMessage(String message,double maxValue){
        rulesMessageArgs.put(Rule.ValueMax,message);
        return maxValue(maxValue);
    }

	/**
	 * 输入值不能大于maxValue
	 * @param maxValue 最大值
	 * @return RuleConfigs对象，用于链式配置。
	 */
	public RuleConfigs maxValue(double maxValue) {
        if(!containsTester(Rule.ValueMax)){
            testerMapping.put(Rule.ValueMax,new ValueMaxTester());
            rulesParamArgs.put(Rule.ValueMax, new Double[]{maxValue});
        }
		return this;
	}

    /**
     * 自定义测试不通过的消息。输入值不能大于maxValue
     * @param message 自定义消息
     * @return RuleConfigs对象，用于链式配置。
     */
    public RuleConfigs minValueWithMessage(String message,double minValue){
        rulesMessageArgs.put(Rule.ValueMin,message);
        return minValue(minValue);
    }

	/**
	 * 输入值不能小于minValue
	 * @param minValue 最小值
	 * @return RuleConfigs对象，用于链式配置。
	 */
	public RuleConfigs minValue(double minValue) {
        if(!containsTester(Rule.ValueMin)){
            testerMapping.put(Rule.ValueMin,new ValueMinTester());
            rulesParamArgs.put(Rule.ValueMin, new Double[]{minValue});
        }

		return this;
	}

    /**
     * 自定义测试不通过的消息。
     * @param message 自定义消息
     * @return RuleConfigs对象，用于链式配置。
     */
    public RuleConfigs valueInRangeWithMessage(String message,double minValue, double maxValue){
        rulesMessageArgs.put(Rule.ValueInRange,message);
        return valueInRange(minValue, maxValue);
    }

	/**
	 * 输入值在[minValue,maxValue]区间
	 * @param minValue 最小值
	 * @param maxValue 最大值
	 * @return RuleConfigs对象，用于链式配置。
	 */
	public RuleConfigs valueInRange(double minValue, double maxValue) {
        if(!containsTester(Rule.ValueMin)){
            testerMapping.put(Rule.ValueInRange,new ValueInRangeTester());
            rulesParamArgs.put(Rule.ValueInRange, new Double[]{minValue,maxValue});
        }
		return this;
	}

}
