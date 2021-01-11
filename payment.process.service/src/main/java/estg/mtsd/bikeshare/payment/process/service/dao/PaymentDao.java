package estg.mtsd.bikeshare.payment.process.service.dao;

import estg.mtsd.bikeshare.payment.process.service.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentDao extends JpaRepository<Payment, Integer>{

}