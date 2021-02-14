package estg.mtsd.bikeshare.payment.process.service.service;

import estg.mtsd.bikeshare.shared.library.vo.PaymentVo;

import java.util.List;

public interface PaymentService {

    PaymentVo save(PaymentVo paymentVo);

    void update(PaymentVo paymentVo);

    void delete(Integer id);

    PaymentVo get(Integer id);

    List<PaymentVo> getAll();

}

