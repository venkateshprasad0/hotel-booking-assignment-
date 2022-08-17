package com.assignment.paymentservice.repository;

import com.assignment.paymentservice.entity.TransactionInfoEntity;
import org.springframework.data.repository.CrudRepository;

public interface TransactionRepository extends CrudRepository<TransactionInfoEntity,Integer> {
    TransactionInfoEntity findById(int Id);
    TransactionInfoEntity findBybookingId(int bookingId);

}
