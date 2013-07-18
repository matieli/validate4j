package net.yoojia.validate.support;

import net.yoojia.validate.internal.Rule;

/**
 * author : 桥下一粒砂 (chenyoca@gmail.com)
 * date   : 2013-07-15
 * IP v4校验器
 */
public class IPv4Tester extends TesterWithRegex {

    static final String IPV4_REGEX = "^((25[0-5]|2[0-4]\\d|1?\\d?\\d)\\.){3}(25[0-5]|2[0-4]\\d|1?\\d?\\d)$";
    static final String messageT = "Please enter a validate IP address.";

    public IPv4Tester() {
        super(Rule.IPv4, IPV4_REGEX, messageT);
    }
}
