package estg.mtsd.bikeshare.payment.manager.service.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import estg.mtsd.bikeshare.payment.manager.service.entity.Payment;

@Repository
public interface PaymentDao extends JpaRepository<Payment, Integer>{

}