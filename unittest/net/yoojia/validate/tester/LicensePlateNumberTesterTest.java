package net.yoojia.validate.tester;

import net.yoojia.validate.support.LicensePlateNumberTester;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * author : 桥下一粒砂 (chenyoca@gmail.com)
 * date   : 2013-07-12
 * LicensePlateNumberTester 测试
 */
public class LicensePlateNumberTesterTest implements TesterTest{

    LicensePlateNumberTester tester = new LicensePlateNumberTester();

    @Test
    public void passed(){
        assertTrue(tester.test("H80399").passed);
        assertTrue(tester.test("H-12345").passed);
        assertTrue(tester.test("A10086").passed);
        assertTrue(tester.test("京A00008").passed);
        assertTrue(tester.test("甲A-12345").passed);
        assertTrue(tester.test("WJ18-12345").passed);
    }

    @Test
    public void notPass(){
        assertFalse(tester.test("A123456").passed);
        assertFalse(tester.test("H-123456").passed);
        assertFalse(tester.test("AB10086").passed);
        assertFalse(tester.test("北京A00008").passed);
        assertFalse(tester.test("甲A#-12345").passed);
        assertFalse(tester.test("WJ99-A12345").passed);

    }
}
