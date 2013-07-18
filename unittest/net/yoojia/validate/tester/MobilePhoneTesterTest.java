package net.yoojia.validate.tester;

import junit.framework.Assert;
import net.yoojia.validate.support.MobilePhoneTester;
import org.junit.Test;

/**
 * author : 桥下一粒砂 (chenyoca@gmail.com)
 * date   : 2013-07-12
 * MobilePhoneTester 测试
 */
public class MobilePhoneTesterTest implements TesterTest{
	
	MobilePhoneTester tester = new MobilePhoneTester();

	@Test
	public void passed() {
		Assert.assertTrue(tester.test("13800138000").passed);
		Assert.assertTrue(tester.test("+86-13800138000").passed);
	}
	
	@Test
	public void notPass() {
		Assert.assertFalse(tester.test("+86-12800138000").passed);
		Assert.assertFalse(tester.test("15400138000").passed);
		Assert.assertFalse(tester.test("+86 15400138000").passed);
	}

}
