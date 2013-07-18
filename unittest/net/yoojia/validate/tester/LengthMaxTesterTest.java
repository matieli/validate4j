package net.yoojia.validate.tester;

import junit.framework.Assert;
import net.yoojia.validate.support.LengthMaxTester;
import org.junit.Test;

/**
 * author : 桥下一粒砂 (chenyoca@gmail.com)
 * date   : 2013-07-18
 * LengthMaxTester 测试
 */
public class LengthMaxTesterTest implements TesterTest {

    LengthMaxTester tester = new LengthMaxTester();

    @Test
    public void passed() {
        tester.setParameters(3);
        Assert.assertTrue( tester.test("1").passed );
        Assert.assertTrue( tester.test("12").passed );
        Assert.assertTrue( tester.test("123").passed );
        Assert.assertTrue( tester.test(1).passed );
        Assert.assertTrue( tester.test(12).passed );
        Assert.assertTrue( tester.test(123).passed );
        Assert.assertTrue( tester.test(1.1).passed );
        Assert.assertTrue( tester.test(0.1).passed );

        tester.setParameters(5);
        Assert.assertTrue( tester.test("false").passed );
        Assert.assertTrue( tester.test("true").passed );
        Assert.assertTrue( tester.test(false).passed );
        Assert.assertTrue( tester.test(true).passed );
    }

    @Test
    public void notPass() {
        tester.setParameters(3);
        Assert.assertFalse( tester.test("1234").passed );
        Assert.assertFalse( tester.test(1234).passed );
        Assert.assertFalse( tester.test(1.34).passed );
        Assert.assertFalse( tester.test(true).passed );
        Assert.assertFalse( tester.test("true").passed );
        Assert.assertFalse( tester.test(LengthMaxTesterTest.class).passed );
    }
}
