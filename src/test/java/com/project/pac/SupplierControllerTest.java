package com.project.pac;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.project.pac.supplier.SupplierFactory;
import com.project.pac.supplier.SupplierRepository;
import com.project.pac.supplier.SupplierService;
import com.project.pac.supplier.definition.SupplierBean;

public class SupplierControllerTest {

	@InjectMocks
    SupplierService supplierService;
    
    @Mock
    private SupplierRepository supplierRepository;
    
    @Mock
    private SupplierFactory supplierFactory;
    
    @Test
    public void findAll() {
    	List<SupplierBean> result = supplierService.findAll(1L);
    	assertTrue(!result.isEmpty());
    }
}
