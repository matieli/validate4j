package net.yoojia.validate.tester;

import junit.framework.Assert;
import net.yoojia.validate.internal.TestResult;
import net.yoojia.validate.support.LengthInRangeTester;
import net.yoojia.validate.util.StringGenerator;
import org.junit.Test;

/**
 * author : 桥下一粒砂 (chenyoca@gmail.com)
 * date   : 2013-07-18
 * LengthInRangeTester 测试
 */
public class LengthInRangeTesterTest implements TesterTest {

    LengthInRangeTester tester = new LengthInRangeTester();

    @Test
    public void passed() {
        tester.setParameters(1,5);
        Assert.assertTrue(tester.test("1").passed);
        Assert.assertTrue(tester.test("123").passed);
        Assert.assertTrue(tester.test("12345").passed);
        Assert.assertTrue(tester.test(123).passed);
        Assert.assertTrue(tester.test(1234).passed);
        Assert.assertTrue(tester.test(12345).passed);
        Assert.assertTrue(tester.test(true).passed);
        Assert.assertTrue(tester.test(false).passed);
        Assert.assertTrue( tester.test(1.1).passed );
        Assert.assertTrue( tester.test(0.34).passed );
        Assert.assertTrue( tester.test(0.345).passed );

        for(int i=1;i<10;i++){
            tester.setParameters(0,i);
            TestResult result = tester.test(StringGenerator.genString(i));
            if(!result.passed){
                System.err.println(result.message);
            }
            Assert.assertTrue(result.passed);
        }

    }

    @Test
    public void notPass() {
        tester.setParameters(3,5);
        Assert.assertFalse(tester.test("1").passed);
        Assert.assertFalse(tester.test("12").passed);
        Assert.assertFalse(tester.test("123456").passed);
        Assert.assertFalse(tester.test(1).passed);
        Assert.assertFalse(tester.test(12).passed);
        Assert.assertFalse(tester.test(123456).passed);
        Assert.assertFalse(tester.test('a').passed);
        Assert.assertFalse(tester.test("A").passed);
        Assert.assertFalse(tester.test("AB").passed);
        Assert.assertFalse(tester.test("A12345").passed);

        tester.setParameters(0,5);
        Assert.assertFalse(tester.test(StringGenerator.genString(10)).passed);

        tester.setParameters( 6,100);
        Assert.assertFalse(tester.test(StringGenerator.genString(4)).passed);
    }
}
