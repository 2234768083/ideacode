package nuc.edu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author hongjun
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrdersCustom extends Orders {
private String userName;
private String sex;
private String address;


}
