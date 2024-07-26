package ds;

import com.jiajia.mylogger.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * @author 杜嘉豪
 * @create 2024/4/1 20:30
 * @description:
 */
public class CarMapperTest {
    @Test
    public void testInsertCarByUtil(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        int insertCar = sqlSession.insert("insertCar");
        System.out.println("插入了"+insertCar+"条数据");
        sqlSession.commit();
        sqlSession.close();
    }
}
