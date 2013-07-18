package net.yoojia.validate.validator;

import net.yoojia.validate.Validator;

/**
 * author : 桥下一粒砂 (chenyoca@gmail.com)
 * date   : 2013-07-17
 * 测试基类
 */
public abstract class BaseTest {

    protected Validator validator = new Validator();

    public abstract void passed();

    public abstract void notPassed();
}
