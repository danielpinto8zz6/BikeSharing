package estg.mtsd.bikeshare.payment.service.service;

import estg.mtsd.bikeshare.shared.library.vo.PaymentDataVo;
import estg.mtsd.bikeshare.shared.library.vo.PaymentVo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PaymentService {

    void save(PaymentDataVo paymentDataVo);

    void update(PaymentVo paymentVo);

    void delete(Integer id);

    PaymentVo get(Integer id);

    Page<PaymentVo> getAll(Pageable pageable, String userEmail);

    PaymentVo getByRentalId(Integer rentalId);
}

