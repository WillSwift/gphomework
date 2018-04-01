package pattern.template.tom.dao;

import pattern.template.tom.JDBCTemplate;
import pattern.template.tom.RowMapper;
import pattern.template.tom.entity.Member;

import java.sql.ResultSet;
import java.util.List;

public class MemberDao {
    private JDBCTemplate jdbcTemplate = new JDBCTemplate(null);

    public List<Member> query() {
        String sql = "select * from t_member";
        return jdbcTemplate.executeQuery(sql, new RowMapper<Member>() {
            @Override
            public Member mapRow(ResultSet resultSet) throws Exception {
                Member member = new Member();
                member.setName(resultSet.getString("name"));
                member.setAge(resultSet.getInt("age"));
                member.setSex(resultSet.getString("sex"));
                return member;
            }
        }, null);
    }
}
