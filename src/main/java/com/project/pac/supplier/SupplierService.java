package com.project.pac.supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.pac.supplier.definition.SupplierBean;
import com.project.pac.supplier.definition.SupplierModel;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SupplierService {

	@Autowired
	private SupplierRepository supplierRepository;

	@Autowired
	private SupplierFactory supplierFactory;

	public List<SupplierBean> findAll(Long userId) {
		List<SupplierModel> supplierModels = supplierRepository.findAllByIdUser(userId);
		return supplierModels.stream().map(supplierFactory::buildBean).collect(Collectors.toList());
	}

	public SupplierBean findById(Long id) {
		return supplierRepository.findById(id).map(supplierFactory::buildBean).orElse(null);
	}

	public List<SupplierBean> saveAll(List<SupplierBean> supplierList) {
		return supplierList.stream().map(this::save).collect(Collectors.toList());
	}

	public SupplierBean save(SupplierBean supplierBean) {
		SupplierModel supplierModel = supplierFactory.buildModel(supplierBean);
		SupplierModel savedModel = supplierRepository.save(supplierModel);
		return supplierFactory.buildBean(savedModel);
	}

	public SupplierBean update(SupplierBean supplierBean) throws Exception {
		if (supplierRepository.existsById(supplierBean.getId())) {
			return save(supplierBean);
		} else {
			throw new Exception("Supplier not found");
		}
	}

	public void deleteByIds(List<Long> supplierIds) {
		supplierRepository.deleteAllById(supplierIds);
	}
}
