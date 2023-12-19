package mybatis.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;
import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Orders {
    private Integer id;
    private Integer userId;
    private User user;
    private String number;
    private Date createtime;
    private String note;
    private String orderName;
}
