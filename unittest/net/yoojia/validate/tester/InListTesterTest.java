package net.yoojia.validate.tester;

import junit.framework.Assert;
import net.yoojia.validate.support.InListTester;
import org.junit.Test;

/**
 * author : 桥下一粒砂 (chenyoca@gmail.com)
 * date   : 2013-07-18
 * InListTester 测试
 */
public class InListTesterTest implements TesterTest{

    InListTester tester = new InListTester();

    String[] aList = new String[]{"A","B","C"};
    Integer[] bList = new Integer[]{1,3,5};
    Double[] cList = new Double[]{1.01,3.03,5.05};
    Object[] dList = new Object[]{true,Integer.valueOf(9),String.valueOf("A")};

    @Test
    public void passed() {
        tester.setParameters(aList);
        Assert.assertTrue(tester.test("A").passed);
        Assert.assertTrue(tester.test("B").passed);
        Assert.assertTrue(tester.test("C").passed);

        tester.setParameters(bList);
        Assert.assertTrue(tester.test(1).passed);
        Assert.assertTrue(tester.test(3).passed);
        Assert.assertTrue(tester.test(5).passed);

        tester.setParameters(cList);
        Assert.assertTrue(tester.test(1.01).passed);
        Assert.assertTrue(tester.test(3.03).passed);
        Assert.assertTrue(tester.test(5.05).passed);

        tester.setParameters(dList);
        Assert.assertTrue(tester.test(9).passed);
        Assert.assertTrue(tester.test("A").passed);
        Assert.assertTrue(tester.test(true).passed);

    }

    @Test
    public void notPass() {

        tester.setParameters(aList);
        Assert.assertFalse(tester.test("D").passed);
        Assert.assertFalse(tester.test("E").passed);
        Assert.assertFalse(tester.test("F").passed);
        Assert.assertFalse(tester.test(1).passed);
        Assert.assertFalse(tester.test(1.0).passed);
        Assert.assertFalse(tester.test(true).passed);
        Assert.assertFalse(tester.test(1.002).passed);
        Assert.assertFalse(tester.test('a').passed);

        tester.setParameters(bList);
        Assert.assertFalse(tester.test(2).passed);
        Assert.assertFalse(tester.test(4).passed);
        Assert.assertFalse(tester.test(6).passed);

        tester.setParameters(cList);
        Assert.assertFalse(tester.test(1.0111).passed);
        Assert.assertFalse(tester.test(3.033).passed);
        Assert.assertFalse(tester.test(5.0555).passed);

        tester.setParameters(dList);
        Assert.assertFalse(tester.test(false).passed);
        Assert.assertFalse(tester.test("BB").passed);
        Assert.assertFalse(tester.test(9.0).passed);

    }
}
