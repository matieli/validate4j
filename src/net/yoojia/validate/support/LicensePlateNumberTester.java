package net.yoojia.validate.support;

import net.yoojia.validate.internal.Rule;

/**
 * author : 桥下一粒砂 (chenyoca@gmail.com)
 * date   : 2013-07-12
 * 中国车牌号校验。支持民用军用警用车牌格式校验。
 */
public class LicensePlateNumberTester extends TesterWithRegex {

    static final String LPN_REGEX = "^[\\u4e00-\\u9fa5]?([A-Z]|WJ\\d{2})-?[A-Z0-9]{5}$";
    static final String messageT = "Please enter a validate License plate number.";

    public LicensePlateNumberTester() {
        super(Rule.LicensePlateNumber, LPN_REGEX, messageT);
    }
}
