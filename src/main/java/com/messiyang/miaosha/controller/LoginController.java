package com.messiyang.miaosha.controller;

import com.messiyang.miaosha.model.vo.LoginVo;
import com.messiyang.miaosha.redis.RedisService;
import com.messiyang.miaosha.redis.redismanager.RedisLua;
import com.messiyang.miaosha.result.resultbean.Result;
import com.messiyang.miaosha.service.otherService.MiaoshaUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import static com.messiyang.miaosha.common.Constanst.COUNTLOGIN;


@Controller
@RequestMapping("/login")
public class LoginController {

    private static Logger log = LoggerFactory.getLogger(LoginController.class);


    @Autowired
    private MiaoshaUserService  miaoshaUserService;

    @Autowired
    RedisService redisService;

    @RequestMapping("/to_login")
    public String toLogin(LoginVo loginVo, Model model) {
        log.info(loginVo.toString());
        RedisLua.vistorCount(COUNTLOGIN);
        String count = RedisLua.getVistorCount(COUNTLOGIN).toString();//获取当前的登录人数
        log.info("访问网站的次数为:{}",count);
        model.addAttribute("count",count);
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
}
