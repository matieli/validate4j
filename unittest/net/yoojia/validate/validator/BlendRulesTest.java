package net.yoojia.validate.validator;

import junit.framework.Assert;
import org.junit.Test;

/**
 * author : 桥下一粒砂 (chenyoca@gmail.com)
 * date   : 2013-07-17
 * 多条件混合测试
 */
public class BlendRulesTest extends BaseTest {

    {
        validator.ruleConfigs().required().email().equalTo("chenyoca@gmail.com");
    }

    @Test
    public void passed() {
        Assert.assertTrue( validator.test("chenyoca@gmail.com") );
    }

    @Test
    public void notPassed() {
        Assert.assertFalse(validator.test("admin@gmail.com"));
        Assert.assertFalse(validator.test("admin#gmail.com"));
        Assert.assertFalse(validator.test("admin@gmail"));
    }
}
