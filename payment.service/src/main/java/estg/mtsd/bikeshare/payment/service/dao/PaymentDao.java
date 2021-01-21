package estg.mtsd.bikeshare.payment.service.dao;

import estg.mtsd.bikeshare.payment.service.entity.Payment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentDao extends JpaRepository<Payment, Integer> {
    Page<Payment> findAllByUserEmail(Pageable pageable, String userEmail);
}