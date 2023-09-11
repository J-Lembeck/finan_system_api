package com.project.pac.supplier.definition;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SupplierBean {

	private Long id;
	private Long idUser;
	private String cnpj;
	private String name;
	private String phone;
}
