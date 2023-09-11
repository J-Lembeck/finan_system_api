package com.project.pac.accountingrecord.definition;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ChartValuesBean {

	private String label;
	private Float value;

	public ChartValuesBean(String formatDate, Float finalBalance) {
		this.label = formatDate;
		this.value = finalBalance;
	}
}
