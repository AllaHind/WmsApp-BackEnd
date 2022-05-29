package com.WMS.Project.repository;

import com.WMS.Project.models.OrderItem;
import org.hibernate.criterion.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem,Long> {


    OrderItem findByCode(String code);

}
