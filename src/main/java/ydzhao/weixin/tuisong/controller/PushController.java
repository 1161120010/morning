package ydzhao.weixin.tuisong.controller;

/**
 *@ClassName PushController
 *@Description TODO
 *@Author ydzhao
 *@Date 2022/8/2 15:48
 */
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import ydzhao.weixin.tuisong.util.Pusher;

@RestController
public class PushController {
    //要推送的用户openid
    private static String lzn = "oAqrp6ajFDwQsEtU_Jrl99XKU-Jc";
    private static String zys = "oAqrp6RXUdXmPO-SO89U16TgKZxc";


    /**
     * 微信测试账号推送
     *
     */
    @GetMapping("/push")
    public void push() {
        Pusher.push(lzn);
    }

    /**
     * 微信测试账号推送
     * */
    @GetMapping("/push/zys")
    public void pushZyd() {
        Pusher.push(zys);
    }


    /**
     * 微信测试账号推送
     * */
    @GetMapping("/push/{id}")
    public void pushId(@PathVariable("id") String id) {
        Pusher.push(id);
    }
}