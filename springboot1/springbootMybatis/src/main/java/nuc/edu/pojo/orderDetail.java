package nuc.edu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class orderDetail {
    private Integer id;
    private Integer orders_id;
    private Integer items_id;
    private Integer items_num;
    private Items items;
}
