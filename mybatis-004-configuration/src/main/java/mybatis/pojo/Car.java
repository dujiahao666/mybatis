package mybatis.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.annotations.Update;

/**
 * @author 杜嘉豪
 * @create 2024/4/1 21:41
 * @description:封装汽车相关信息的pojo类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Car {
 //数据库表当中的字段应该和POJO类的属性一一对应，建议使用包装类，这样可以防止null的问题
    private Long id;
    private String carNum;
    private String brand;
    private Double guidePrice;
    private String produceTime;
    private String carType;

}
