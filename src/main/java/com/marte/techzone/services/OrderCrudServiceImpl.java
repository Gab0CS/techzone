package com.marte.techzone.services;

import com.marte.techzone.dtos.BillDTO;
import com.marte.techzone.dtos.OrderDTO;
import com.marte.techzone.dtos.ProductsDTO;
import com.marte.techzone.entities.BillEntity;
import com.marte.techzone.entities.OrderEntity;
import com.marte.techzone.entities.ProductEntity;
import com.marte.techzone.repositories.OrderRepository;
import com.marte.techzone.repositories.ProductCatalogRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.query.Order;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class OrderCrudServiceImpl implements OrdersCrudService {

    private final OrderRepository orderRepository;

    private final ProductCatalogRepository productCatalogRepository;

    @Override
    public String create(OrderDTO order) {
        final var toInsert = this.mapOrderFromDto(order);
        return this.orderRepository.save(toInsert).getId().toString();
    }

    @Override
    public OrderDTO read(Long id) {

        return this.mapOrderFromEntity(this.orderRepository.findById(id).orElseThrow());
    }

    @Override
    public OrderDTO update(OrderDTO order, Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    private OrderDTO mapOrderFromEntity(OrderEntity orderEntity){

        final var modelMapper = new ModelMapper();
        modelMapper.typeMap(ProductEntity.class, ProductsDTO.class)
                .addMappings(mapper -> mapper.map(
                        entity -> entity.getCatalog().getName(),ProductsDTO::setName
                ));
        return modelMapper.map(orderEntity, OrderDTO.class);
    }

    private OrderEntity mapOrderFromDto(OrderDTO orderDTO){

        final var orderResponse = new OrderEntity();
        final var modelMapper = new ModelMapper();

        modelMapper.typeMap(BillDTO.class, BillEntity.class)
                        .addMappings(mapper -> mapper.map(
                                BillDTO::getIdBill, BillEntity::setId
                        ));
        log.info("Before {}" ,orderResponse);
        modelMapper.map(orderDTO, orderResponse);
        log.info("afet {}" ,orderResponse);

        this.getAndSetProducts(orderDTO.getProducts(), orderResponse);
        log.info("after products {}" ,orderResponse);

        return orderResponse;
    }

    private void getAndSetProducts(List<ProductsDTO> productsDto, OrderEntity orderEntity){
        productsDto.forEach(product -> {
            final var productsFromCatalog = this.productCatalogRepository.findByName(product.getName()).orElseThrow();

            final var productEntity = ProductEntity
                    .builder()
                    .quantity(product.getQuantity())
                    .catalog(productsFromCatalog)
                    .build();

            orderEntity.addProduct(productEntity);
            productEntity.setOrder(orderEntity);
        });
    }


}
