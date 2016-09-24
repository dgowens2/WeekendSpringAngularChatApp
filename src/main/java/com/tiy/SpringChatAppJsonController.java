package com.tiy;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by DTG2 on 09/24/16.
 */
@RestController
public class SpringChatAppJsonController {
    @RequestMapping(path = "/chat.json", method = RequestMethod.GET)
    public Message jsonHome(String text, User user) {
        return new Message(text, user);
    }
}
