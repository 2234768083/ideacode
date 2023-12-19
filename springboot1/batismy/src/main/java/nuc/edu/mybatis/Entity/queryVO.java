package nuc.edu.mybatis.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author hongjun
 * @create 2020-11-06 7:27
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class queryVO {
    private List<Integer> ids;
    private User user;
}
