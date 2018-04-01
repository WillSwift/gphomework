package pattern.template.tom;

import pattern.template.tom.dao.MemberDao;
import pattern.template.tom.entity.Member;

import java.util.List;

public class MemberDaoTest {

    public static void main(String[] args) {
        MemberDao memberDao = new MemberDao();
        List<Member> result = memberDao.query();
    }
}
