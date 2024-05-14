package inhatc.cse.spring.repository;


import inhatc.cse.spring.dto.MemberDto;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor //생성자 불러옴
public class MemberRepository {

    private final SqlSession sqlSession;

    public int save(MemberDto memberDto) {
        System.out.println("============>" + memberDto);
        int result =sqlSession.insert("Member.save",memberDto);
        System.out.println("result : "+result);
        return result;

    }

    public MemberDto login(MemberDto memberDto) {
        return sqlSession.selectOne("Member.login",memberDto);
    }

    public List<MemberDto> findAll() {
        return sqlSession.selectList("Member.findAll");
    }
}