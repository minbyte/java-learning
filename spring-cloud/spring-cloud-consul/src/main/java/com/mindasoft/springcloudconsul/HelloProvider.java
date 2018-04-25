package com.mindasoft.springcloudconsul;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Company：MGTV
 * User: huangmin
 * DateTime: 2018/4/25 16:26
 */
@RestController
public class HelloProvider {

    @RequestMapping("/hi")
    public String home() {
        return "hi ,i'm miya";
    }
}
