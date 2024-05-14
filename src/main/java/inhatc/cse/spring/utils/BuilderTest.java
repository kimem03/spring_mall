package inhatc.cse.spring.utils;

import inhatc.cse.spring.dto.MemberDto;

public class BuilderTest {
    public static void main(String[] args) {
        MemberDto memberDto = new MemberDto("aaa@test.com", "1111", "홍길동", 22, "010-1234-1234");
        // 순서를 반드시 맞추어야 함
//        MemberDto memberDto1 = new MemberDto("aaa@test.com", "1111", "홍길동", 22, "010-1234-1234");

//        MemberDto memberDto1 = MemberDto.builder().build(); //빈 생성자로 객체를 만든 것
        // 순서 맞출 필요 없음
        MemberDto memberDto1 = MemberDto.builder()
                .phone("010-1234-1234")
                .name("홍길순")
                .age(20)
                .build();
        System.out.println(memberDto);
        System.out.println(memberDto1);
    }
}
