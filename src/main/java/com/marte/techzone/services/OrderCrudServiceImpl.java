package com.marte.techzone.services;

import com.marte.techzone.dtos.OrderDTO;
import com.marte.techzone.repositories.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class OrderCrudServiceImpl implements OrdersCrudService {

    private OrderRepository orderRepository;

    @Override
    public String create(OrderDTO order) {
        return "";
    }

    @Override
    public OrderDTO read(Long id) {
        return null;
    }

    @Override
    public OrderDTO update(OrderDTO order, Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
