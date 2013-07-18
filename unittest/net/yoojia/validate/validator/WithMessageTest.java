package net.yoojia.validate.validator;

import junit.framework.Assert;
import net.yoojia.validate.internal.TestResult;
import org.junit.Test;

/**
 * author : 桥下一粒砂 (chenyoca@gmail.com)
 * date   : 2013-07-18
 * 带消息返回
 */
public class WithMessageTest extends BaseTest{

    static final String customMessage_1 = "请输入数据";
    static final String customMessage_2 = "请输入有效IP地址";
    static final String customMessage_3 = "请输入小于%d长度的数据";

    static final int maxLength = 7;
    {
        validator.ruleConfigs().requiredWithMessage(customMessage_1)
                .IPv4WithMessage(customMessage_2)
                .maxLengthWithMessage(customMessage_3, maxLength);
    }

    @Test
    public void passed() {
        // 1
        TestResult result = validator.testResult("");
        System.out.println("Message = "+result.message);
        Assert.assertEquals(customMessage_1,result.message);

        // 2
        result = validator.testResult("1.2.3.4.5");
        System.out.println("Message = "+result.message);
        Assert.assertEquals(customMessage_2,result.message);

        // 3
        result = validator.testResult("1.2.3.25");
        System.out.println("Message = "+result.message);
        Assert.assertEquals(String.format(customMessage_3,maxLength),result.message);
    }

    @Override
    public void notPassed() {

    }
}
