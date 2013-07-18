package net.yoojia.validate.tester;

import junit.framework.Assert;
import net.yoojia.validate.support.ValueMinTester;
import org.junit.Test;

/**
 * author : 桥下一粒砂 (chenyoca@gmail.com)
 * date   : 2013-07-18
 * ValueMinTester 测试
 */
public class ValueMinTesterTest implements TesterTest {

    ValueMinTester tester = new ValueMinTester();

    @Test
    public void passed() {
        tester.setParameters(10.0);
        for(int i=0;i<10;i++){
            Assert.assertTrue( tester.test(10+i).passed );
        }
    }

    @Test
    public void notPass() {
        tester.setParameters(10.0);
        Assert.assertFalse(tester.test(9).passed);
        Assert.assertFalse(tester.test(9.99).passed);
        Assert.assertFalse(tester.test(0).passed);
        Assert.assertFalse(tester.test(3).passed);
    }
}
