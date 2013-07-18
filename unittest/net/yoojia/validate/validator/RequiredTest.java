package net.yoojia.validate.validator;

import junit.framework.Assert;
import org.junit.Test;

/**
 * author : 桥下一粒砂 (chenyoca@gmail.com)
 * date   : 2013-07-17
 * Required 测试
 */
public class RequiredTest extends BaseTest{

    {
        validator.ruleConfigs().required();
    }

    @Test
    public void passed() {
        Assert.assertTrue( validator.test("value") );
    }

    @Test
    public void notPassed() {
        Assert.assertFalse(validator.test(""));
        Assert.assertFalse(validator.test(null));
    }
}
