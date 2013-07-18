package net.yoojia.validate.tester;

import junit.framework.Assert;
import net.yoojia.validate.support.RegexTester;
import org.junit.Test;

/**
 * author : 桥下一粒砂 (chenyoca@gmail.com)
 * date   : 2013-5-18
 * RegexTester 测试
 */
public class RegexTesterTest implements TesterTest{
	
	RegexTester tester = new RegexTester();

	@Test
	public void passed() {
        tester.setParameters("\\d*");
		Assert.assertTrue(tester.test(0).passed);
		Assert.assertTrue(tester.test(10086).passed);

        tester.setParameters("[a-zA-Z]*");
		Assert.assertTrue(tester.test("A").passed);
		Assert.assertTrue(tester.test("Apple").passed);
	}
	
	@Test
	public void notPass(){
        tester.setParameters("[a-zA-Z]*");
		Assert.assertFalse(tester.test("10086").passed);

        tester.setParameters("\\d*");
		Assert.assertFalse(tester.test("false").passed);
	}

}
