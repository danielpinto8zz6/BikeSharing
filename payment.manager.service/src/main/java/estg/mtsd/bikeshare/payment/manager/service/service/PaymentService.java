package estg.mtsd.bikeshare.payment.manager.service.service;

import java.util.List;

import estg.mtsd.bikeshare.payment.manager.service.vo.PaymentRequest;
import estg.mtsd.bikeshare.payment.manager.service.vo.PaymentVo;

public interface PaymentService {

	void generate(PaymentRequest paymentVo) ;
	void update(PaymentVo paymentVo) ;
	void delete(Integer id);
	PaymentVo get(Integer id);
	List<PaymentVo> getAll();

}

