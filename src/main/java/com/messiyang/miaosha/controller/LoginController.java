package com.messiyang.miaosha.controller;

import com.messiyang.miaosha.model.vo.LoginVo;
import com.messiyang.miaosha.redis.RedisService;
import com.messiyang.miaosha.redis.redismanager.RedisLua;
import com.messiyang.miaosha.result.resultbean.Result;
import com.messiyang.miaosha.service.otherService.MiaoshaUserService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import java.util.Map;

import static com.messiyang.miaosha.common.Constanst.COUNTLOGIN;
import static com.messiyang.miaosha.result.enums.ResultStatus.MOBILE_EMPTY;
import static com.messiyang.miaosha.result.enums.ResultStatus.RESIGETER_FAIL;


@Controller
@RequestMapping("/login")
public class LoginController {

    private static Logger log = LoggerFactory.getLogger(LoginController.class);


    @Autowired
    private MiaoshaUserService miaoshaUserService;

    @Autowired
    RedisService redisService;

    @RequestMapping("/to_login")
    public String toLogin(LoginVo loginVo, Model model) {
        log.info(loginVo.toString());
        RedisLua.vistorCount(COUNTLOGIN);
        String count = RedisLua.getVistorCount(COUNTLOGIN).toString();//获取当前的登录人数
        log.info("访问网站的次数为:{}", count);
        model.addAttribute("count", count);
        return "login";
    }

    @RequestMapping("/do_login")
    @ResponseBody
    public Result<Boolean> doLogin(HttpServletResponse response, @Valid LoginVo loginVo) {
        Result<Boolean> result = Result.build();
        log.info(loginVo.toString());
        miaoshaUserService.login(response, loginVo);
        return result;
    }


    @RequestMapping("/create_token")
    @ResponseBody
    public String createToken(HttpServletResponse response, @Valid LoginVo loginVo) {
        log.info(loginVo.toString());
        String token = miaoshaUserService.login(response, loginVo);
        return token;
    }

    @RequestMapping("/register")
    public Result<String> register(@RequestParam("username") String userName,
                                   @RequestParam("password") String passWord,
                                   @RequestParam("verifyCode") String verifyCode,
                                   @RequestParam("salt") String salt, HttpServletResponse response) {

        Result<String> result = Result.build();
        /**
         * 校验验证码
         */
//        boolean check = miaoshaUserService.checkVerifyCodeRegister(Integer.valueOf(verifyCode));
//        if(!check){
//            result.withError(CODE_FAIL.getCode(),CODE_FAIL.getMessage());
//            return result;
//
//        }
//        boolean registerInfo  = miaoShaUserService.register(response , userName,passWord,salt);
//        if(!registerInfo){
//            result.withError(RESIGETER_FAIL.getCode(),RESIGETER_FAIL.getMessage());
//            return result;
//        }
//        return result;
        return null;
    }


    /**
     * 获取验证码
     */
    @RequestMapping(value = "/getCheckCode")
    public Result<String> getCheckCode(@RequestParam("telphone") String telphone) {

        Result<String> result = Result.build();
        if (!StringUtils.isEmpty(telphone)) {
            result.withError(MOBILE_EMPTY.getCode(), MOBILE_EMPTY.getMessage());
            return result;
        }

        String vcode = miaoshaUserService.getCheckCode(telphone);
        result.setData(vcode);
        return result;


    }

}
