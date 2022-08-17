package com.assignment.bookingservice.repository;

import com.assignment.bookingservice.entity.BookingInfoEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends CrudRepository<BookingInfoEntity,Integer> {

    BookingInfoEntity findById(int id);
}
