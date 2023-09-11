package com.project.pac;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.project.pac.bank.BankFactory;
import com.project.pac.bank.BankRepository;
import com.project.pac.bank.BankService;
import com.project.pac.bank.definition.BankBean;

public class BankControllerTest {

	@InjectMocks
    BankService bankService;
    
    @Mock
    private BankRepository bankRepository;
    
    @Mock
    private BankFactory bankFacotory;
    
    @Test
    public void findAll() {
    	List<BankBean> result = bankService.findAll(1L);
    	assertTrue(!result.isEmpty());
    }
}
