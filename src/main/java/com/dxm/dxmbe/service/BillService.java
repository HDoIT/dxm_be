package com.dxm.dxmbe.service;

import com.dxm.dxmbe.model.Bill;
import com.dxm.dxmbe.request.BillRequest;

import java.util.List;

public interface BillService {
    int addBill(BillRequest.createBill billSpending);

    List<Bill> getAllBill(Long userId);
}
