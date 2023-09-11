package com.project.pac;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.project.pac.accountingrecord.AccountingRecordFactory;
import com.project.pac.accountingrecord.AccountingRecordRepository;
import com.project.pac.accountingrecord.AccountingRecordService;
import com.project.pac.accountingrecord.definition.AccountingRecordBean;

@ExtendWith(MockitoExtension.class)
public class AccountingRecordControllerTest {

    @InjectMocks
    AccountingRecordService accountingRecordService;
    
    @Mock
    private AccountingRecordRepository accountingRecordRepository;
    
    @Mock
    private AccountingRecordFactory accountingRecordFactory;
    
    @Test
    public void findAll() {
    	List<AccountingRecordBean> result = accountingRecordService.findAll();
    	assertTrue(!result.isEmpty());
    }
}
