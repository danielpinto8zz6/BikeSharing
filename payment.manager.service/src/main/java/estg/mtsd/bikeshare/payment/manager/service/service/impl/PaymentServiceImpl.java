package estg.mtsd.bikeshare.payment.manager.service.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import estg.mtsd.bikeshare.payment.manager.service.dao.PaymentDao;
import estg.mtsd.bikeshare.payment.manager.service.entity.Payment;
import estg.mtsd.bikeshare.payment.manager.service.service.PaymentCalculatorServiceProxy;
import estg.mtsd.bikeshare.payment.manager.service.service.PaymentService;
import estg.mtsd.bikeshare.payment.manager.service.vo.PaymentRequest;
import estg.mtsd.bikeshare.payment.manager.service.vo.PaymentVo;

@Service
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	PaymentDao paymentDao;

	@Autowired
	PaymentCalculatorServiceProxy paymentCalculator;

	@Override
	@Transactional
	public void generate(PaymentRequest paymentRequest) {
		double value = paymentCalculator.calculate(paymentRequest.getStartDate(), paymentRequest.getEndDate());

		Payment payment = new Payment();
		payment.setValue(value);
		payment.setTravelId(paymentRequest.getTravelId());
		payment.setIsPaid(false);

		paymentDao.save(payment);
	}

	@Override
	@Transactional
	public void update(PaymentVo paymentVo) {
		Integer id = paymentVo.getId();
		Boolean objectExists = paymentDao.existsById(id);
		if (objectExists) {
			Payment payment = new Payment();
			BeanUtils.copyProperties(paymentVo, payment);
			paymentDao.save(payment);
		} else {
			throw new EntityNotFoundException();
		}
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		Boolean objectExists = paymentDao.existsById(id);
		if (objectExists) {
			paymentDao.deleteById(id);
		} else {
			throw new EntityNotFoundException();
		}
	}

	@Override
	@Transactional
	public PaymentVo get(Integer id) {
		Optional<Payment> paymentOptional = paymentDao.findById(id);
		PaymentVo paymentVo = null;
		if (paymentOptional.isPresent()) {
			paymentVo = new PaymentVo();
			BeanUtils.copyProperties(paymentOptional.get(), paymentVo);
		} else {
			throw new EntityNotFoundException();
		}

		return paymentVo;
	}

	@Override
	@Transactional
	public List<PaymentVo> getAll() {
		List<Payment> paymentList = paymentDao.findAll();
		List<PaymentVo> paymentVoList = new ArrayList<>();
		if (paymentList != null && !paymentList.isEmpty()) {
			for (Payment payment : paymentList) {
				PaymentVo paymentVo = new PaymentVo();
				BeanUtils.copyProperties(payment, paymentVo);
				paymentVoList.add(paymentVo);
			}
		}
		return paymentVoList;
	}

}
