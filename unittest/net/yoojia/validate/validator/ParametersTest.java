package net.yoojia.validate.validator;

import junit.framework.Assert;
import org.junit.Test;

/**
 * author : 桥下一粒砂 (chenyoca@gmail.com)
 * date   : 2013-07-18
 * 参数测试
 */
public class ParametersTest extends BaseTest {

    {
        validator.enableLogging();
        validator.ruleConfigs().minLength(2).maxLength(5)
                .lengthInRange(2, 5)
        .minValue(10).maxValue(99999)
        .valueInRange(10,99999)
        ;
    }

    @Test
    public void passed() {
        Assert.assertTrue( validator.test("12") );
        Assert.assertTrue( validator.test("123") );
        Assert.assertTrue( validator.test("1234") );
        Assert.assertTrue( validator.test("12345") );

        Assert.assertTrue( validator.test(10) );
        Assert.assertTrue( validator.test(12) );
        Assert.assertTrue( validator.test(123) );
        Assert.assertTrue( validator.test(1234) );
        Assert.assertTrue( validator.test(12345) );
        Assert.assertTrue( validator.test(99999) );

        Assert.assertTrue( validator.test(12.1) );
        Assert.assertTrue( validator.test(123.2) );
        Assert.assertTrue( validator.test(123f) );
    }

    @Override
    public void notPassed() {
        Assert.assertFalse( validator.test(1) );
        Assert.assertFalse( validator.test(9) );
        Assert.assertFalse( validator.test(123456) );
        Assert.assertFalse( validator.test("1") );
        Assert.assertFalse( validator.test("123456") );
    }
}
