package com.project.pac.accountingrecord;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.pac.accountingrecord.definition.AccountingRecordBean;
import com.project.pac.accountingrecord.definition.AccountingRecordModel;
import com.project.pac.accountingrecord.definition.ChartValuesBean;
import com.project.pac.accountingrecord.definition.DashboardBean;

@Service
public class AccountingRecordService {
	@Autowired
	AccountingRecordRepository accountingRecordRepository;

	@Autowired
	AccountingRecordFactory accountingRecordFactory;

	public List<AccountingRecordBean> findAll() {
		List<AccountingRecordModel> records = accountingRecordRepository.findAll();
		return accountingRecordFactory.buildBeanList(records);
	}

	public AccountingRecordBean findById(Long id) {
		Optional<AccountingRecordModel> model = accountingRecordRepository.findById(id);
		return model.map(accountingRecordFactory::buildBean).orElse(null);
	}

	public List<AccountingRecordBean> saveAll(List<AccountingRecordBean> beans) {
		List<AccountingRecordBean> savedBeans = new ArrayList<>();

		beans.forEach(bean -> {
			try {
				savedBeans.add(save(bean));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		});

		return savedBeans;
	}

	public AccountingRecordBean save(AccountingRecordBean bean) throws ParseException {
		bean = accountingRecordFactory.buildBeanDates(bean);
		AccountingRecordModel model = accountingRecordFactory.buildModel(bean);
		return accountingRecordFactory.buildBean(accountingRecordRepository.save(model));
	}

	public AccountingRecordBean update(AccountingRecordBean accountingBean) throws Exception {
		Optional<AccountingRecordModel> existingRecord = accountingRecordRepository.findById(accountingBean.getId());
		if (existingRecord.isPresent()) {
			return save(accountingBean);
		} else {
			throw new Exception("Accounting not found");
		}
	}

	public void deleteByIds(List<Long> ids) {
		accountingRecordRepository.deleteAllById(ids);
	}

	public List<AccountingRecordBean> findByEmissionDateFilter(Long userId, Calendar initialDate, Calendar finalDate) {
		List<AccountingRecordModel> result = accountingRecordRepository.findByEmissionDate(userId, initialDate,
				finalDate);
		return accountingRecordFactory.buildBeanList(result);
	}

	public List<AccountingRecordBean> findAllByType(Long userId, Boolean type) {
		List<AccountingRecordModel> result = accountingRecordRepository.findAllByIdUserAndType(userId, type);
		return accountingRecordFactory.buildBeanList(result);
	}

	public DashboardBean findDashboardInfo(Long userId, String date) throws ParseException {
		DashboardBean dashboard = new DashboardBean();
		LocalDate paymentDate = convertDate(date);
		Float finalBalance = 0.00f;

		List<AccountingRecordModel> result = accountingRecordRepository.findByPaymentDate(userId, paymentDate);

		for (AccountingRecordModel accountingRecord : result) {
			if (accountingRecord.getType()) {
				finalBalance += accountingRecord.getValue();
				dashboard.setReceivedValue(dashboard.getReceivedValue() + accountingRecord.getValue());
			} else {
				finalBalance -= accountingRecord.getValue();
				dashboard.setPaidValue(dashboard.getPaidValue() + accountingRecord.getValue());
			}
		}

		dashboard.setFinalBalance(finalBalance);
		return dashboard;
	}

	public List<ChartValuesBean> findChartValues(Long userId, String year) throws ParseException {
		List<ChartValuesBean> chartList = new ArrayList<>();

		LocalDate startDate = LocalDate.of(Integer.parseInt(year), Month.JANUARY, 1);
		LocalDate endDate = LocalDate.of(Integer.parseInt(year), Month.DECEMBER, 31);

		LocalDate currentDate = startDate;
		while (!currentDate.isAfter(endDate)) {
			Float finalBalance = 0.00f;
			List<AccountingRecordModel> result = accountingRecordRepository.findByEmissionDate(userId, currentDate);

			for (AccountingRecordModel accountingRecord : result) {
				if (accountingRecord.getType()) {
					finalBalance += accountingRecord.getValue();
				} else {
					finalBalance -= accountingRecord.getValue();
				}
			}

			ChartValuesBean chartBean = new ChartValuesBean(formatDate(currentDate), finalBalance);
			chartList.add(chartBean);

			currentDate = currentDate.plusMonths(1);
		}

		return chartList;
	}

	private String formatDate(LocalDate date) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/yyyy");
		return date.format(formatter);
	}

	private LocalDate convertDate(String dateString) throws ParseException {
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		return LocalDate.parse(dateString, dateFormat);
	}

}
