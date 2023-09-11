package com.project.pac.bank.definition;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BankBean {

	private Long id;
	private Long idUser;
	private Long bankCode;
	private String bankName;
	private Float balance;

}
