package net.yoojia.validate.tester;

import junit.framework.Assert;
import net.yoojia.validate.support.ValueInRangeTester;
import org.junit.Test;

/**
 * author : 桥下一粒砂 (chenyoca@gmail.com)
 * date   : 2013-07-18
 * ValueInRangeTester 测试
 */
public class ValueInRangeTesterTest implements TesterTest {

    ValueInRangeTester tester = new ValueInRangeTester();

    @Test
    public void passed() {
        tester.setParameters(1.0,10.0);
        for(int i=1;i<=10;i++){
            Assert.assertTrue( tester.test(i).passed );
        }
    }

    @Test
    public void notPass() {
        tester.setParameters(1.0,10.0);
        Assert.assertFalse(tester.test(0.9).passed);
        Assert.assertFalse(tester.test(10.1).passed);
        Assert.assertFalse(tester.test(0).passed);
        Assert.assertFalse(tester.test(11).passed);
    }
}
