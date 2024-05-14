package inhatc.cse.spring.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor      //기본 생성자
@AllArgsConstructor     //전체 필드를 다 채운 생성자
@Builder
public class MemberDto {
    private int id;
    private String email;
    private String password;
    private String name;
    private int age;
    private String phone;

}
