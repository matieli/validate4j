package net.yoojia.validate.tester;

import net.yoojia.validate.support.IPv4Tester;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * author : 桥下一粒砂 (chenyoca@gmail.com)
 * date   : 2013-07-15
 * IPv4Tester 测试
 */
public class IPv4TesterTest implements TesterTest{

    IPv4Tester tester = new IPv4Tester();

    @Test
    public void passed(){
        assertTrue(tester.test("0.0.0.0").passed);
        assertTrue(tester.test("0.0.0.1").passed);
        assertTrue(tester.test("127.0.0.1").passed);
        assertTrue(tester.test("127.0.0.0").passed);
        assertTrue(tester.test("127.0.0.255").passed);

        assertTrue(tester.test("255.255.255.0").passed);
        assertTrue(tester.test("255.255.255.255").passed);

        assertTrue(tester.test("192.168.0.1").passed);
        assertTrue(tester.test("192.168.0.199").passed);
        assertTrue(tester.test("192.168.0.255").passed);

        assertTrue(tester.test("199.154.37.214").passed);
        assertTrue(tester.test("97.67.44.20").passed);
        assertTrue(tester.test("97.67.44.255").passed);
        assertTrue(tester.test("254.67.44.255").passed);

        assertTrue(tester.test("1.67.44.255").passed);
        assertTrue(tester.test("1.2.3.4").passed);
        assertTrue(tester.test("8.8.8.8").passed);
    }

    @Test
    public void notPass(){
        assertFalse(tester.test("a.b.e.d").passed);
        assertFalse(tester.test("1.2.3.4.5").passed);
        assertFalse(tester.test("256.256.256.256").passed);
        assertFalse(tester.test("192.168.1.256").passed);
        assertFalse(tester.test("192.168.1.256").passed);
    }
}
