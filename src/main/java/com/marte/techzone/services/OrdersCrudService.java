package com.marte.techzone.services;

import com.marte.techzone.dtos.OrderDTO;

public interface OrdersCrudService {
    String create(OrderDTO order);
    OrderDTO read(Long id);
    OrderDTO update(OrderDTO order, Long id);
    void delete(Long id);
}
