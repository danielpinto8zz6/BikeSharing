package estg.mtsd.bikeshare.payment.service.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "invoice")
public class Invoice {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "tax_number")
    private Integer taxNumber;

    @Column(name = "company")
    private String company;

    @Column(name = "timestamp")
    private Date timestamp;

    @OneToOne(mappedBy = "invoice")
    private Payment payment;

}