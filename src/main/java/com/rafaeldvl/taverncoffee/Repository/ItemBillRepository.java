package com.rafaeldvl.taverncoffee.Repository;

import com.rafaeldvl.taverncoffee.Domain.Models.ItemBill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ItemBillRepository extends JpaRepository<ItemBill,Integer> {

    @Query(value = "SELECT * FROM item_bill WHERE ordem_pedido_id =:id", nativeQuery = true)
    List<ItemBill> findByOrderId(Integer id);
}
