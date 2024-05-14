package inhatc.cse.spring.service;

import inhatc.cse.spring.dto.MemberDto;
import inhatc.cse.spring.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public int save(MemberDto memberDto) {
        return memberRepository.save(memberDto);
    }

    public boolean login(MemberDto memberDto) {
        MemberDto loginMember = memberRepository.login(memberDto);
        if(loginMember != null){
            return true;

        }else {
            return false;
        }

    }
}