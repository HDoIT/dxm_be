package com.dxm.dxmbe.controller;

import com.dxm.dxmbe.enums.ErrorCode;
import com.dxm.dxmbe.model.Bill;
import com.dxm.dxmbe.request.BillRequest;
import com.dxm.dxmbe.response.ResqBean;
import com.dxm.dxmbe.service.BillService;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/bill-spending")
@CrossOrigin(value = "*",maxAge = 3600)
public class BillController {

    @Autowired
    private BillService billService;

    @GetMapping("/getAll")
    public String get(){
        return "Bill Spending";
    }

    /**
     * Thêm hóa đơn chi tiêu
     * @param billSpending các thuộc tính của hóa đơn cần thêm
     * @return giá trị 1
     */
    @PostMapping("/create")
    public ResqBean<Integer> create(@RequestBody BillRequest.createBill billSpending){
        try {
            return ResqBean.ok("Success",billService.addBill(billSpending));
        }catch (Exception e){
            return ResqBean.error("Error", billService.addBill(billSpending),ErrorCode.ERROR_500);
        }
    }

    @GetMapping("/all")
    public ResqBean<List<Bill>> getAll(@RequestParam Long userId){
        try{
            return ResqBean.ok("Success",billService.getAllBill(userId));
        }catch (Exception e){
            return ResqBean.error("Error", ArrayUtils.toArray(),ErrorCode.ERROR_500);
        }
    }



}
