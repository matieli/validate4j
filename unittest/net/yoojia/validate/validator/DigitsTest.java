package net.yoojia.validate.validator;

import junit.framework.Assert;
import org.junit.Test;

/**
 * author : 桥下一粒砂 (chenyoca@gmail.com)
 * date   : 2013-07-16
 * 整数测试
 */
public class DigitsTest extends BaseTest{

    {
        validator.ruleConfigs().digits();
    }

    @Test
    public void passed(){
        Assert.assertTrue(validator.testResult("123").passed);
        Assert.assertTrue(validator.testResult("123343434").passed);
        Assert.assertTrue(validator.testResult("00000").passed);
        Assert.assertTrue(validator.testResult("0123456789").passed);
        Assert.assertTrue(validator.testResult("13800138000").passed);
    }

    @Test
    public void notPassed() {
        Assert.assertFalse(validator.testResult("abc123").passed);
        Assert.assertFalse(validator.testResult("###123343434").passed);
        Assert.assertFalse(validator.testResult("abc").passed);
        Assert.assertFalse(validator.testResult("/**//%%").passed);
        Assert.assertFalse(validator.testResult("1.0123").passed);
        Assert.assertFalse(validator.testResult("0x0123").passed);
        Assert.assertFalse(validator.testResult("0xFFFF").passed);
    }

}
