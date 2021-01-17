package estg.mtsd.bikeshare.shared.library.vo;

import lombok.Data;

import java.util.Date;

@Data
public class InvoiceVo {

    private Integer id;

    private String name;

    private Integer taxNumber;

    private String company;

    private Date timestamp;

}