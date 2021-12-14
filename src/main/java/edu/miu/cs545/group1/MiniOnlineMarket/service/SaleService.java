package edu.miu.cs545.group1.MiniOnlineMarket.service;


import edu.miu.cs545.group1.MiniOnlineMarket.domain.Sale;

import java.util.List;

public interface SaleService {
    Sale getSale(Long id);
    void updateSale(Sale sale);
    List<Sale> getAllSales();
}
