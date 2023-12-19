package nuc.edu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private int id;
    private String clientName;
    private List<Orders> ordersList;
    private String sex;
    private Date birthday;
    private String address;

}
