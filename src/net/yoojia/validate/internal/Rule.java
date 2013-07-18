package net.yoojia.validate.internal;

/**
 * author : 桥下一粒砂 (chenyoca@gmail.com)
 * date   : 2013-5-14
 * 内建规则
 */
public enum Rule {

	/* 必填，不能为空 */
	Required,

	/* 邮件 */
	Email,

	/* 网址 */
	URL,

	/* 手机号码 */
	MobilePhone,

	/* 数字：负数，小数 */
    Numeric,

	/* 整数 */
	Digits,

	/* 与另一值相等 */
	EqualTo,

	/* 在此列表中  */
	InList,

    /* IP v4 */
    IPv4,

    /* 车牌号 */
    LicensePlateNumber,

	/* 字符最大长度 */
	LengthMax,

	/*  字符最小长度 */
	LengthMin,

	/* 字符长度范围 */
	LengthInRange,

	/* 最大值 */
	ValueMax,

	/*  最小值 */
	ValueMin,

	/* 数值范围  */
	ValueInRange,

	/* 匹配正则表达式 */
	Regex,
	
	/* 自定义规则 */
	Custom,

    /* 通过测试 */
    TestPassed,

    /* 参数为空 */
    NullInput,

    /* 不支持的数据类型*/
    NotSupport,

}
