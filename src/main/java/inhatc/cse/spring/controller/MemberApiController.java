package inhatc.cse.spring.controller;

import inhatc.cse.spring.dto.MemberDto;
import inhatc.cse.spring.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin
@Slf4j
public class MemberApiController {

    private final MemberService memberService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody MemberDto memberDto){
        System.out.println("============>"+ memberDto);
        boolean result = memberService.login(memberDto);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    @PostMapping("/save")
    public ResponseEntity<?> memberInsert(@RequestBody MemberDto memberDto){
        System.out.println("============="+ memberDto);
        int result = memberService.save(memberDto);
        System.out.println("============="+ result);

        return new ResponseEntity<>(memberDto, HttpStatus.OK);
    }

    @GetMapping("/memberlist")
    public ResponseEntity<?> memberList() {
        List<MemberDto> memberList = memberService.findAll();
        log.info("memberList: " + memberList);

        return new ResponseEntity<>(memberList, HttpStatus.OK);
    }

    @GetMapping("/memberdetail/{id}")
    public ResponseEntity<?> memberIdList(@PathVariable int id) {
        MemberDto memberDto = memberService.findById(id);

        return new ResponseEntity<>(memberDto, HttpStatus.OK);
    }

}