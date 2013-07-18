package net.yoojia.validate.validator;

import org.junit.Test;

/**
 * author : 桥下一粒砂 (chenyoca@gmail.com)
 * date   : 2013-07-18
 * 执行顺序测试
 */
public class TestOrderTest extends BaseTest {

    {
        validator.enableLogging();
        validator.ruleConfigs().
                required()
                .digits()
                .minLength(2)
                .maxLength(5);
    }

    @Test
    public void passed() {

        // See log , order in :
        // Required
        // Digits
        // LengthMin
        // LengthMax

        // digits
        validator.test("123");

        System.out.println("==============");
        // max length
        validator.test("123456");
    }

    @Override
    public void notPassed() { }
}
