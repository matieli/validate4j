package net.yoojia.validate.tester;

import junit.framework.Assert;
import net.yoojia.validate.support.RequiredTester;
import net.yoojia.validate.util.StringGenerator;
import org.junit.Test;

/**
 * author : 桥下一粒砂 (chenyoca@gmail.com)
 * date   : 2013-5-18
 * RequiredTester 测试
 */
public class RequiredTesterTest implements TesterTest{

	RequiredTester tester = new RequiredTester();
	
	@Test
	public void passed() {
		Assert.assertTrue(tester.test(123).passed);
		Assert.assertTrue(tester.test(1200.13f).passed);
		Assert.assertTrue(tester.test(1200.1314).passed);
		Assert.assertTrue(tester.test(StringGenerator.genString(10)).passed);

		Assert.assertTrue(tester.test(new Object()).passed);
		Assert.assertTrue(tester.test(new RequiredTesterTest()).passed);
	}

	@Test
	public void notPass(){
		Assert.assertFalse(tester.test("").passed);
	}

}
