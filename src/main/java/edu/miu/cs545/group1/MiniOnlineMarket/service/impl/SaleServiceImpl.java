package edu.miu.cs545.group1.MiniOnlineMarket.service.impl;

import edu.miu.cs545.group1.MiniOnlineMarket.domain.Sale;
import edu.miu.cs545.group1.MiniOnlineMarket.repository.SaleRepo;
import edu.miu.cs545.group1.MiniOnlineMarket.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleServiceImpl implements SaleService {
    @Autowired
    SaleRepo saleRepo;
    @Override
    public Sale getSale(Long id) {
        return saleRepo.findById(id).get();
    }

    @Override
    public void updateSale(Sale sale) {
        saleRepo.save(sale);
    }

    @Override
    public List<Sale> getAllSales() {
        return saleRepo.findAll();
    }
}
