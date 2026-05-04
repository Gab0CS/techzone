package com.marte.techzone.controllers;

import com.marte.techzone.dtos.OrderDTO;
import com.marte.techzone.services.OrderCrudServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping(path = "order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderCrudServiceImpl orderCrudService;

    @GetMapping(path = "{id}")
    public ResponseEntity<OrderDTO> get(@PathVariable Long id){
        return ResponseEntity.ok(orderCrudService.read(id));

    }

    @PostMapping
    public ResponseEntity<Void> post(@RequestBody OrderDTO orderDTO){
        var path = "/" + this.orderCrudService.create(orderDTO);
        return ResponseEntity.created(URI.create(path)).build();
    }
}
