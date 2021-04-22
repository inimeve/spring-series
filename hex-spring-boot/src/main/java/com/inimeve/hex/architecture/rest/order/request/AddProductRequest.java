package com.inimeve.hex.architecture.rest.order.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.inimeve.hex.architecture.core.order.domain.Product;

import javax.validation.constraints.NotNull;

public class AddProductRequest {
    @NotNull private Product product;

    @JsonCreator
    public AddProductRequest(@JsonProperty("product") final Product product) {
        this.product = product;
    }

    public Product getProduct() {
        return product;
    }
}
