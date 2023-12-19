package nuc.edu.mapper;

import nuc.edu.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 洪军
 * @since 2020-12-09
 */
@Repository
public interface UserMapper extends BaseMapper<User> {
List<User> findUserAndOrder();
}
