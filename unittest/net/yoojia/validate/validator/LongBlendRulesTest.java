package net.yoojia.validate.validator;

import junit.framework.Assert;
import org.junit.Test;

/**
 * author : 桥下一粒砂 (chenyoca@gmail.com)
 * date   : 2013-07-18
 * 混合条件测试
 */
public class LongBlendRulesTest extends BaseTest{

    {
        validator.ruleConfigs()
                .required()
                .email()
                .maxLength(30)
                .minLength(6)
                .inList(new String[]{"chenyoca@gmail.com","admin@gmail.com","abcdef@gmail.com"})
                ;
    }

    @Test
    public void passed() {
        Assert.assertTrue( validator.test("chenyoca@gmail.com") );
        Assert.assertTrue( validator.test("admin@gmail.com") );
        Assert.assertTrue( validator.test("abcdef@gmail.com") );
        Assert.assertTrue( validator.test("chenyoca@gmail.com") );
    }

    @Test
    public void notPassed() {
        // Test NULL
        Assert.assertFalse( validator.test(null) );

        // Test required
        Assert.assertFalse( validator.test("") );

        // Test email
        Assert.assertFalse( validator.test("not a email") );

        // Max length
        Assert.assertFalse( validator.test("1234567890-1234567890-1234567890") );

        // Min length
        Assert.assertFalse( validator.test("12345") );
        Assert.assertFalse( validator.test("1") );

        // Not in list
        Assert.assertFalse( validator.test("a_chenyoca@gmail.com") );
        Assert.assertFalse( validator.test("b_chenyoca@gmail.com") );
        Assert.assertFalse(validator.test("c_admin@gmail.com"));
    }
}
