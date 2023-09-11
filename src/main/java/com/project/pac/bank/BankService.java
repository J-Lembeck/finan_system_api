package com.project.pac.bank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.pac.bank.definition.BankBean;
import com.project.pac.bank.definition.BankModel;

import java.util.List;

@Service
public class BankService {

	@Autowired
	private BankRepository bankRepository;

	@Autowired
	private BankFactory bankFactory;

	public List<BankBean> findAll(Long userId) {
		List<BankModel> bankModels = bankRepository.findAllByIdUser(userId);
		return bankModels.stream().map(bankFactory::buildBean).toList();
	}

	public BankBean findById(Long id) {
		return bankRepository.findById(id).map(bankFactory::buildBean).orElse(null);
	}

	public List<BankBean> saveAll(List<BankBean> bankList) {
		return bankList.stream().map(this::save).toList();
	}

	public BankBean save(BankBean bankBean) {
		BankModel bankModel = bankFactory.buildModel(bankBean);
		BankModel savedModel = bankRepository.save(bankModel);
		return bankFactory.buildBean(savedModel);
	}

	public void deleteByIds(List<Long> bankIds) {
		bankRepository.deleteAllById(bankIds);
	}

	public BankBean update(BankBean bankBean) throws Exception {
		if (bankRepository.existsById(bankBean.getId())) {
			return save(bankBean);
		} else {
			throw new Exception("Bank not found");
		}
	}
}
