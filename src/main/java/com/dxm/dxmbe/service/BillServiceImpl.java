package com.dxm.dxmbe.service;

import com.dxm.dxmbe.model.Bill;
import com.dxm.dxmbe.repository.BillRepository;
import com.dxm.dxmbe.repository.UserRepository;
import com.dxm.dxmbe.request.BillRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.time.Instant;
import java.util.List;

@Service
public class BillServiceImpl implements BillService {

    @Autowired
    private BillRepository billRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EntityManager em;

    @Override
    public int addBill(BillRequest.createBill billSpending) {
        try {
//            Boolean isUser = userRepository.existsById(billSpending.getUserId());
            Bill bill = Bill.builder()
                    .name(billSpending.getName())
                    .description(billSpending.getDescription())
                    .amount(billSpending.getAmount())
                    .categoryId(billSpending.getCategoryId())
                    .userId(billSpending.getUserId())
                    .date(Instant.ofEpochMilli(billSpending.getDate()))
                    .createAt(Instant.now())
                    .build();
            billRepository.save(bill);
            return 1;
        } catch (Exception e) {
            System.out.println("Error" + e);
        }
        return -1;
    }

    @Override
    public List<Bill> getAllBill(Long userId){
        try{
            return billRepository.getBillByUserId(userId);
        }catch (Exception e){
            System.out.println("Error" + e);
        }
        return null;
    }
}
