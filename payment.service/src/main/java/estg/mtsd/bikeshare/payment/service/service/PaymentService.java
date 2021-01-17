package estg.mtsd.bikeshare.payment.service.service;

import estg.mtsd.bikeshare.shared.library.vo.PaymentDataVo;
import estg.mtsd.bikeshare.shared.library.vo.PaymentVo;

import java.util.List;

public interface PaymentService {

    void save(PaymentDataVo paymentDataVo);

    void update(PaymentVo paymentVo);

    void delete(Integer id);

    PaymentVo get(Integer id);

    List<PaymentVo> getAll(String userEmail);

}

