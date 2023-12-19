package nuc.edu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Items {
    private Integer id;
    private String name;
    private float price;
    private String detail;
    private String pic;
    private Date datetime;
}
