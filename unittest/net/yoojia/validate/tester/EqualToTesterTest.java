package net.yoojia.validate.tester;

import junit.framework.Assert;
import net.yoojia.validate.support.EqualToTester;
import org.junit.Test;

/**
 * author : 桥下一粒砂 (chenyoca@gmail.com)
 * date   : 2013-07-18
 * EqualToTester 测试
 */
public class EqualToTesterTest implements TesterTest{

    EqualToTester tester = new EqualToTester();

    @Test
    public void passed() {
        tester.setParameters(1);
		Assert.assertTrue(tester.test(1).passed);

        tester.setParameters(1f);
		Assert.assertTrue(tester.test(1).passed);

        tester.setParameters(1L);
		Assert.assertTrue(tester.test(1).passed);

        tester.setParameters(1.0f);
		Assert.assertTrue(tester.test(1.0).passed);

        tester.setParameters(0.00000f);
		Assert.assertTrue(tester.test(0).passed);
		Assert.assertTrue(tester.test(0.00000).passed);

        tester.setParameters(10086);
		Assert.assertTrue(tester.test(10086).passed);

        tester.setParameters(1987.987);
		Assert.assertTrue(tester.test(1987.987).passed);

        tester.setParameters(1.9f);
		Assert.assertTrue(tester.test(1.9f).passed);

        tester.setParameters("abc");
		Assert.assertTrue(tester.test("abc").passed);

		String sameObj = "foobar";
        tester.setParameters(sameObj);
		Assert.assertTrue(tester.test(sameObj).passed);

        tester.setParameters('a');
		Assert.assertTrue(tester.test('a').passed);

        tester.setParameters('X');
		Assert.assertTrue(tester.test('X').passed);

        tester.setParameters(true);
		Assert.assertTrue(tester.test(true).passed);

        tester.setParameters(false);
		Assert.assertTrue(tester.test(false).passed);

        tester.setParameters(Integer.MAX_VALUE);
		Assert.assertTrue(tester.test(Integer.MAX_VALUE).passed);

        tester.setParameters(Long.MAX_VALUE);
        Assert.assertTrue(tester.test(Long.MAX_VALUE).passed);

        tester.setParameters( Double.MAX_VALUE);
		Assert.assertTrue(tester.test(Double.MAX_VALUE).passed);

        tester.setParameters( Byte.MAX_VALUE );
		Assert.assertTrue(tester.test(Byte.MAX_VALUE).passed);

        tester.setParameters( Short.MAX_VALUE );
		Assert.assertTrue(tester.test(Short.MAX_VALUE).passed);

        tester.setParameters( Boolean.FALSE );
		Assert.assertTrue(tester.test(Boolean.FALSE ).passed);

        tester.setParameters(String.valueOf("abc"));
		Assert.assertTrue(tester.test(String.valueOf("abc")).passed);

        tester.setParameters(Integer.valueOf("10098"));
		Assert.assertTrue(tester.test(Integer.valueOf("10098")).passed);
    }

    @Test
    public void notPass() {
        tester.setParameters(12345);
		Assert.assertFalse(tester.test("a").passed);

        tester.setParameters('a');
		Assert.assertFalse(tester.test(97).passed);

        tester.setParameters('A');
		Assert.assertFalse(tester.test(97).passed);

        tester.setParameters('A');
		Assert.assertFalse(tester.test('a').passed);

        tester.setParameters( "A");
		Assert.assertFalse(tester.test('A').passed);

        tester.setParameters(198.f);
		Assert.assertFalse(tester.test("a").passed);

        tester.setParameters( "d");
		Assert.assertFalse(tester.test("a").passed);

        tester.setParameters(false);
		Assert.assertFalse(tester.test("a").passed);

        tester.setParameters(false);
		Assert.assertFalse(tester.test(true).passed);

        tester.setParameters(false);
		Assert.assertFalse(tester.test(1).passed);

        tester.setParameters( String.valueOf("abc"));
		Assert.assertFalse(tester.test(String.valueOf("ddd")).passed);
    }
}
