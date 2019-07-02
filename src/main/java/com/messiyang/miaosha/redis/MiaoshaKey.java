package com.messiyang.miaosha.redis;

public class MiaoshaKey extends BasePrefix {


    private MiaoshaKey(int expireSeconds, String prefix) {
        super(expireSeconds, prefix);
    }

    /**
     * 用于秒杀验证码的获取
     */
    public static MiaoshaKey miaoshaVerifyCodeRegister = new MiaoshaKey(300,"register");


}
