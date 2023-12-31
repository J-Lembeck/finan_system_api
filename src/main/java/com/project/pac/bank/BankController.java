package com.project.pac.bank;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.pac.bank.definition.BankBean;

@RestController
@RequestMapping(value = "/bank")
public class BankController {

	@Autowired
	BankService bankService;

	@GetMapping(path = "/findAll")
	public List<BankBean> findAll(@RequestParam("userId") Long userId) {
		return bankService.findAll(userId);
	}

	@GetMapping(path = "/find")
	public BankBean findById(@RequestParam("id") Long id) {
		return bankService.findById(id);
	}

	@PostMapping
	public List<BankBean> saveAll(@RequestBody List<BankBean> bankList) {
		return bankService.saveAll(bankList);
	}

	@PutMapping
	public BankBean update(@RequestBody BankBean bank) throws Exception {
		return bankService.update(bank);
	}

	@DeleteMapping
	public void delete(@RequestParam("ids") List<Long> bankIds) throws Exception {
		bankService.deleteByIds(bankIds);
	}
}
