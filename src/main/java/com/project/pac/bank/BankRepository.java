package com.project.pac.bank;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.pac.bank.definition.BankModel;

public interface BankRepository extends JpaRepository<BankModel, Long> {

	List<BankModel> findAllByIdUser(Long userId);
}
