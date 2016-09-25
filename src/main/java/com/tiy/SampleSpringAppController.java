package com.tiy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by DTG2 on 09/23/16.
 */
@Controller
public class SampleSpringAppController {

    @Autowired
    MessageRepo messages;

    @Autowired
    UserRepo users;

    @RequestMapping(path = "/", method = RequestMethod.GET)
//    public String home(Model model, HttpSession session) {
//        model.addAttribute("name", session.getAttribute("userName"));
//        return "home";
    public String home(Model model, HttpSession session, String text) {

//        if (session.getAttribute("user") != null) {
//            model.addAttribute("user", session.getAttribute("user"));
//        }

        List<Message> messageList = new ArrayList<>();
        if (text != null) {
            messageList = messages.findByText(text);
        } else {
            User savedUser = (User)session.getAttribute("user");
            if (savedUser != null) {
                messageList = messages.findByUser(savedUser);
            } else {
                Iterable<Message> allMessages = messages.findAll();
                for (Message message : allMessages) {
                    messageList.add(message);
                }
            }
        }
        model.addAttribute("games", messageList);
        System.out.println("message added to db from home in controller");
        return "home";
    }

    @RequestMapping(path = "/logout", method = RequestMethod.GET)
    public String logout(HttpSession session) {
        session.removeAttribute("userName");
        return "redirect:/";
    }
    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public String login(HttpSession session, String userName) {
        session.setAttribute("userName", userName);
        return "redirect:/";
    }

    @RequestMapping(path = "/chat", method = RequestMethod.GET)
    public String chat() {
        return "chat";
    }

    @RequestMapping(path = "/inputText", method = RequestMethod.POST)
    public String inputText(HttpSession session, String message) {
        WebChatClient myChatClient = new WebChatClient();
        myChatClient.sendMessage(message);
        System.out.println("Message sent from /inputtext");
        session.getAttribute(message);
        System.out.println("message added to session");
        return "redirect:/";
    }

}
