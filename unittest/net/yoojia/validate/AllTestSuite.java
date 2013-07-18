package net.yoojia.validate;

import junit.framework.JUnit4TestAdapter;
import junit.framework.Test;
import junit.framework.TestSuite;
import net.yoojia.validate.tester.*;
import net.yoojia.validate.validator.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * author : 桥下一粒砂 (chenyoca@gmail.com)
 * date   : 2013-07-16
 * 测试全部
 */
public class AllTestSuite {

    @RunWith(Suite.class)
    @Suite.SuiteClasses({
            DigitsTesterTest.class,
            EmailTesterTest.class,
            EqualToTesterTest.class,
            InListTesterTest.class,
            IPv4TesterTest.class,
            LengthInRangeTesterTest.class,
            LengthMaxTesterTest.class,
            LengthMinTesterTest.class,
            LicensePlateNumberTesterTest.class,
            MobilePhoneTesterTest.class,
            NumericTesterTest.class,
            RegexTesterTest.class,
            RequiredTesterTest.class,
            URLTesterTest.class,
            ValueMaxTesterTest.class,
            ValueMinTesterTest.class,
            ValueInRangeTesterTest.class,
            // --------- Validator
            BlendRulesTest.class,
            DigitsTest.class,
            DoubleRuleTest.class,
            LongBlendRulesTest.class,
            ParametersTest.class,
            RequiredTest.class,
            TestOrderTest.class,
            WithMessageTest.class
    })
    public class AllTestsUsingAnnotation {

    }

    public static Test suite() {
        TestSuite suite = new TestSuite("Test all");
        suite.addTest(new JUnit4TestAdapter(AllTestsUsingAnnotation.class));
        return suite;
    }
}
