package com.project.pac.supplier;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.pac.supplier.definition.SupplierModel;

public interface SupplierRepository extends JpaRepository<SupplierModel, Long> {

	List<SupplierModel> findAllByIdUser(Long userId);

}
