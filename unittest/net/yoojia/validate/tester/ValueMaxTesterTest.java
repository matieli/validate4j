package net.yoojia.validate.tester;

import junit.framework.Assert;
import net.yoojia.validate.support.ValueMaxTester;
import org.junit.Test;

/**
 * author : 桥下一粒砂 (chenyoca@gmail.com)
 * date   : 2013-07-18
 * ValueMaxTester 测试
 */
public class ValueMaxTesterTest implements TesterTest {

    ValueMaxTester tester = new ValueMaxTester();

    @Test
    public void passed() {
        tester.setParameters(10.0);
        for(int i=0;i<10;i++){
            Assert.assertTrue( tester.test(i).passed );
        }
    }

    @Test
    public void notPass() {
        tester.setParameters(10.0);
        Assert.assertFalse( tester.test(10.01).passed );
        Assert.assertFalse( tester.test(10.1).passed );
        Assert.assertFalse( tester.test(11.1).passed );
        Assert.assertFalse( tester.test(11).passed );
    }
}
