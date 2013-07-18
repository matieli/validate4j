package net.yoojia.validate.tester;

import junit.framework.Assert;
import net.yoojia.validate.support.DigitsTester;
import org.junit.Test;

/**
 * author : 桥下一粒砂 (chenyoca@gmail.com)
 * date   : 2013-5-17
 * DigitsTester 测试
 */
public class DigitsTesterTest implements TesterTest{

    DigitsTester tester = new DigitsTester();

    @Test
    public void passed(){
        Assert.assertTrue(tester.test(123).passed);
        Assert.assertTrue(tester.test(13800138000L).passed);
        Assert.assertTrue(tester.test(123343434).passed);
        Assert.assertTrue(tester.test(Integer.MAX_VALUE).passed);
		Assert.assertTrue(tester.test("123").passed);
		Assert.assertTrue(tester.test("123343434").passed);
		Assert.assertTrue(tester.test("00000").passed);
		Assert.assertTrue(tester.test("0123456789").passed);
		Assert.assertTrue(tester.test("13800138000").passed);
    }

    @Test
    public void notPass(){
		Assert.assertFalse(tester.test("aaa123").passed);
		Assert.assertFalse(tester.test("###123343434").passed);
		Assert.assertFalse(tester.test("abc").passed);
		Assert.assertFalse(tester.test("/**//%%").passed);
		Assert.assertFalse(tester.test("1.0123").passed);
		Assert.assertFalse(tester.test("0x0123").passed);
		Assert.assertFalse(tester.test("0xFFFF").passed);
    }
}
