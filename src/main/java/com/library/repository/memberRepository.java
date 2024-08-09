package main.java.com.library.repository;
import main.java.com.library.model.Book;
import main.java.com.library.model.Member;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class memberRepository {
    private Connection connection;

    public memberRepository(Connection connection) {
        this.connection = connection;
    }

    public void insertMember(Member member) throws SQLException  {
        String sql = "Insert into member (fullName,address) values(?,?)";
        try(PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setString(1,member.getFullName());
            stmt.setString(2,member.getAddress());
            stmt.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void updateMember(Member member) throws SQLException  {
        String sql = "Update member set fullName = ?, address = ? where id = ?";
        try(PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setString(1,member.getFullName());
            stmt.setString(2,member.getAddress());
            stmt.setInt(3,member.getId());
            stmt.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public void deleteMember(int id) throws SQLException  {
        String sql = "Delete from member where id = ?";
        try(PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setInt(1,id);
            stmt.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public Member getMember(int id) throws SQLException  {
        String sql = "select * from member where id = ?";
        try(PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setInt(1,id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Member(rs.getInt("id"), rs.getString("fullName"), rs.getString("address"));
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public List<Member> getAllMembers() throws SQLException  {
        String sql = "select * from member";
        try(PreparedStatement stmt = connection.prepareStatement(sql)){
            ResultSet rs = stmt.executeQuery();
            List<Member> members = new ArrayList<>();
            while (rs.next()) {
                members.add(new Member(rs.getInt("id"), rs.getString("fullName"), rs.getString("address")));
            }
            return members;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }


}
