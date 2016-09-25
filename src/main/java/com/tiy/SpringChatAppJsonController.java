package com.tiy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by DTG2 on 09/24/16.
 */
@RestController
public class SpringChatAppJsonController {

    @Autowired
    MessageRepo messages;

    @RequestMapping(path = "/chat.json", method = RequestMethod.GET)
    public Message jsonHome(String text, User user) {
        return new Message(text, user);
    }

    @RequestMapping(path = "/history.json", method = RequestMethod.GET)
    public List<Message> getMessages() {

        List<Message> messageHistory = new ArrayList<Message>();
        Iterable<Message> allMessages = messages.findAll();
        for (Message message : allMessages) {
            messageHistory.add(message);
        }

//        try {
//            System.out.println("Catching a nap!");
//            Thread.sleep(3000);
//            System.out.println("Power naps are the best!!!");
//        } catch (Exception exception) {
//            exception.printStackTrace();
//        }

        return messageHistory;
    }

    @RequestMapping(path = "/addMessage.json", method = RequestMethod.POST)
    public List<Message> addMessage(HttpSession session, @RequestBody Message message) throws Exception {
//        User user = (User)session.getAttribute("user");

//        if (user == null) {
//            throw new Exception("Unable to add message without an active user in the session");
//        }
//        message.user = user;

        messages.save(message);

        return getMessages();
    }
}
