package com.blog.controller;

import com.blog.Enums.SeckillStateEnum;
import com.blog.Exception.RepeatKillException;
import com.blog.Exception.SeckillCloseException;
import com.blog.JedisDao.impl.JedisClientSingle;
import com.blog.pojo.Exposer;
import com.blog.pojo.SeckillExecution;
import com.blog.pojo.SeckillResult;
import com.blog.service.SeckillService;
import com.blog.utils.AuthUtil;
import com.blog.utils.CookieUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.Date;
import java.util.Map;


/**
 * author bebetter159
 * date  2018/6/3 20:22
 */
@Controller
@RequestMapping("/seckill")
public class SeckillController {
    @Autowired
    JedisClientSingle jedisClientSingle;
    @Autowired
    SeckillService seckillService;

    @RequestMapping("/home")
    public String seckill(HttpServletRequest request, Model model) {
        Long time = jedisClientSingle.getSeckillTime();
        model.addAttribute("seckillTime", time);
        return "CommonUser";
    }

    @RequestMapping("/exposer")
    @ResponseBody
    public SeckillResult<Exposer> exposer() {
        SeckillResult<Exposer> result;
        try {
            Exposer exposer = seckillService.exportSeckillUrl();
            result = new SeckillResult<Exposer>(true, exposer);
        } catch (Exception e) {
            e.printStackTrace();
            result = new SeckillResult<Exposer>(false, e.getMessage());
        }
        return result;
    }

    @RequestMapping("/time")
    @ResponseBody
    public SeckillResult<Long> getTime() throws ParseException {

        Date date = new Date();
        //System.out.println(new SeckillResult<Long>(true,now.getTime()).toString());
        return new SeckillResult<Long>(true, date.getTime());

    }


    @RequestMapping(value = "{userId}/{md5}/execution")
    @ResponseBody
    public SeckillResult<SeckillExecution> execute(
            @PathVariable("md5") String md5,
            @PathVariable("userId") int userId) {

        try {
            SeckillExecution execution = seckillService.executeSeckill(userId, md5);
            return new SeckillResult<SeckillExecution>(true, execution);

        } catch (RepeatKillException e1) {
            SeckillExecution execution = new SeckillExecution(SeckillStateEnum.REPEAT_KILL);
            return new SeckillResult<SeckillExecution>(true, execution);
        } catch (SeckillCloseException e2) {
            SeckillExecution execution = new SeckillExecution(SeckillStateEnum.END);
            return new SeckillResult<SeckillExecution>(true, execution);
        } catch (Exception e) {
            SeckillExecution execution = new SeckillExecution(SeckillStateEnum.INNER_ERROR);
            return new SeckillResult<SeckillExecution>(true, execution);
        }

    }


    @RequestMapping(value = "/{md5}/execution")
    @ResponseBody
    public SeckillResult<SeckillExecution> execute(HttpServletRequest request,
                                                   @PathVariable("md5") String md5) {
        String sessionid = CookieUtil.getByName(request, "login");
        Map<String, Object> map = AuthUtil.decodeSession(sessionid);
        int userId = (int) map.get("userId");
        try {
            SeckillExecution execution = seckillService.executeSeckill(userId, md5);
            return new SeckillResult<SeckillExecution>(true, execution);

        } catch (RepeatKillException e1) {
            SeckillExecution execution = new SeckillExecution(SeckillStateEnum.REPEAT_KILL);
            return new SeckillResult<SeckillExecution>(true, execution);
        } catch (SeckillCloseException e2) {
            SeckillExecution execution = new SeckillExecution(SeckillStateEnum.END);
            return new SeckillResult<SeckillExecution>(true, execution);
        } catch (Exception e) {
            SeckillExecution execution = new SeckillExecution(SeckillStateEnum.INNER_ERROR);
            return new SeckillResult<SeckillExecution>(true, execution);
        }

    }


}
