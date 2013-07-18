package net.yoojia.validate.tester;

import junit.framework.Assert;
import net.yoojia.validate.support.EmailTester;
import org.junit.Test;

/**
 * author : 桥下一粒砂 (chenyoca@gmail.com)
 * date   : 2013-07-18
 * EmailTester 测试
 */
public class EmailTesterTest implements TesterTest{

	EmailTester tester = new EmailTester();
	
	@Test
	public void passed() {
		Assert.assertTrue(tester.test("chenyoca@gmail.com").passed);
		Assert.assertTrue(tester.test("chen.yoca@gmail.com").passed);
		Assert.assertTrue(tester.test("chen.yo-ca@gmail.com").passed);
		Assert.assertTrue(tester.test("chen.yo-ca2013@gmail.com").passed);
		Assert.assertTrue(tester.test("228441083@qq.com").passed);
	}
	
	@Test
	public void notPass(){
		Assert.assertFalse(tester.test("").passed);
		Assert.assertFalse(tester.test("XXXX").passed);
		Assert.assertFalse(tester.test("电子邮件@qq.com").passed);
		Assert.assertFalse(tester.test("chenyoca#@gm@ail.com").passed);
	}

}
