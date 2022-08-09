package com.ll.exam.sbb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
public class TestController {
    public static int num;

    static {
        num = 0;
    }

    @GetMapping("/plus")
    @ResponseBody
    public int plusCalculator(int a, int b) {

        return a + b;
    }

    @GetMapping("/minus")
    @ResponseBody
    public int minusCalculator(int a, int b) {

        return a - b;
    }

    @GetMapping("/increase")
    @ResponseBody
    public int increase() {
        return num++;
    }

    //    @GetMapping("/gugudan")
//    @ResponseBody
//    public String gugudan(@RequestParam("dan") int dan, @RequestParam("limit") int limit) {
//        return IntStream.rangeClosed(1, limit)
//                .mapToObj(operand -> "%d * %d = %d".formatted(dan, operand, dan * operand))
//                .collect(Collectors.joining("<br>"));
//    }
//
    @GetMapping("/gugudan")
    @ResponseBody
    public String gugudan(@RequestParam("dan") int dan, @RequestParam("limit") int limit) {
        String result = "";
        for (int i = 1; i <= limit; i++) {
            result += """
                    %d * %d = %d<br>
                    """.formatted(dan, i, dan * i);
        }
        return result;
    }

    @GetMapping("/mbti")
    @ResponseBody
    public String gugudan(@RequestParam("name") String name) {
        switch (name) {
            case "홍길동":
                return "INFP";
            case "홍길순":
                return "ENFP";
            case "임꺽정":
                return "INFJ";
            case "도석영":
                return "ISTP";
        }
        return "";
    }

    @RequestMapping("/saveSessionAge/{num}")
    @ResponseBody
    public int saveSession(HttpServletRequest request, @PathVariable int num) throws Exception {
        HttpSession session = request.getSession();
        session.setAttribute("num", num);

        return num;
    }

    @RequestMapping("/getSessionAge")
    @ResponseBody
    public int getSession(HttpServletRequest request) throws Exception {
        HttpSession session = request.getSession();
        int num = (int) session.getAttribute("num");

        session.setAttribute("num", num);

        return num;
    }



}
