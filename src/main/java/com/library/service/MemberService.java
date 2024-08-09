package main.java.com.library.service;
import main.java.com.library.model.Member;
import main.java.com.library.repository.memberRepository;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
public class MemberService {
    private memberRepository memberRepository;

    public MemberService(Connection connection){
        this.memberRepository = new memberRepository(connection);

    }

    public void addMember(Member member)throws SQLException {
        memberRepository.insertMember(member);
    }

    public List<Member> getAllMembers()throws SQLException {
        return memberRepository.getAllMembers();
    }
    public Member getMemberById(int id) throws SQLException {
        return memberRepository.getMember(id);
    }
    public void updateMember(Member member)throws SQLException {
        memberRepository.updateMember(member);
    }
    public void deleteMember(int id)throws SQLException {
        memberRepository.deleteMember(id);
    }
}
