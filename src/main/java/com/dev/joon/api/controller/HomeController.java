package com.dev.joon.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/board")
public class HomeController {

    /**
     * @ResponseBody : Java Object -> JSON
     * @RequestBody : JSON -> Java Object
     */

    @RequestMapping(value = "/list/{id}", method=RequestMethod.GET)
    @ResponseBody() // JSON
    public Map<String, String> home(@PathVariable String id) {

        Map<String, String> list = new HashMap<>();

        list.put("id", id);
        list.put("pw", "codevang123");
        list.put("location", "SEOUL");

        return list;
    }

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> home(@RequestBody Map<String, String> list) {

        // 내용이 잘 들어왔는지 테스트
        String id = list.get("id");
        String pw = list.get("pw");
        System.out.println(id + " : " + pw);

        // 내용 변경해서 리턴
        list.replace("id", id + "response");
        list.replace("pw", pw + "response");

        return list;
    }

}

