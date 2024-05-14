package inhatc.cse.spring.controller;

import inhatc.cse.spring.dto.MemberDto;
import inhatc.cse.spring.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@Slf4j
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    //@RequestMapping(value = "/member/save",method = RequestMethod.GET)
    @GetMapping("/save")
    public String save(){
        // System.out.println("===================회원 가입 처리중....");
        log.info("==================회원 가입 처리중");
        return "member/save";
    }

    @PostMapping("/save")
    public String memberInsert(@ModelAttribute MemberDto memberDto){
        System.out.println("========="+ memberDto);
        int result = memberService.save(memberDto);
        if(result > 0){
            return "member/login";
        } else {
            return "member/save";
        }
    }

    @GetMapping("/login")
    public String loginForm(){
        return "member/login";
    }
    @PostMapping("/login")
    public String login(@ModelAttribute MemberDto memberDto,
                        HttpSession session){
        //System.out.println("memberDto = "+ memberDto);
        boolean result = memberService.login(memberDto);
        if(result){
            session.setAttribute("loginEmail", memberDto.getEmail());
            return "main";
        }else{
            return "member/login";
        }
    }



}