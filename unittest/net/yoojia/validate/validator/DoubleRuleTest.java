package net.yoojia.validate.validator;

import junit.framework.Assert;
import org.junit.Test;

/**
 * author : 桥下一粒砂 (chenyoca@gmail.com)
 * date   : 2013-07-17
 * 双条件测试
 */
public class DoubleRuleTest extends BaseTest {

    {
        validator.ruleConfigs().required().digits();
    }

    @Test
    public void passed() {
        Assert.assertTrue( validator.test("123") );
    }

    @Test
    public void notPassed() {
        Assert.assertFalse(validator.test("not digits"));
    }
}
