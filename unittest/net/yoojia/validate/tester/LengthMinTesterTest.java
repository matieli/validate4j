package net.yoojia.validate.tester;

import junit.framework.Assert;
import net.yoojia.validate.support.LengthMinTester;
import org.junit.Test;

/**
 * author : 桥下一粒砂 (chenyoca@gmail.com)
 * date   : 2013-07-18
 * LengthMinTester 测试
 */
public class LengthMinTesterTest implements TesterTest {

    LengthMinTester tester = new LengthMinTester();

    @Test
    public void passed() {
        tester.setParameters(3);
        Assert.assertTrue(tester.test("123").passed);
        Assert.assertTrue(tester.test(123).passed);
        Assert.assertTrue(tester.test(1234).passed);
        Assert.assertTrue(tester.test(123456790).passed);
        Assert.assertTrue( tester.test(1.1).passed );
        Assert.assertTrue( tester.test(0.3).passed );
        Assert.assertTrue( tester.test(0.345678).passed );

        tester.setParameters(5);
        Assert.assertTrue(tester.test("12345").passed);
        Assert.assertTrue(tester.test("123456789").passed);
        Assert.assertTrue(tester.test("false").passed);
        Assert.assertTrue(tester.test(false).passed);
    }

    @Test
    public void notPass() {
        tester.setParameters(3);
        Assert.assertFalse(tester.test("12").passed);
        Assert.assertFalse(tester.test(12).passed);
        Assert.assertFalse(tester.test(1).passed);
        Assert.assertFalse(tester.test('a').passed);
        Assert.assertFalse(tester.test("A").passed);
    }
}
