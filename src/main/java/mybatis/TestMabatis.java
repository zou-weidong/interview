package mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;


public class TestMabatis {

    public static void main(String[] args) throws IOException {
        String resource = "mybatis.xml";
        InputStream resourceAsStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = factory.openSession();
        UserDomain userDomain = sqlSession.selectOne("mybatis.UserMapper.getById", 17);
        System.out.println(userDomain.toString());
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        UserDomain byId = mapper.getById(18);
        System.out.println(byId);

    }

}
