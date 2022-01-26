package com.kodilla.patterns2.decorator.taxiportal;

import java.math.BigDecimal;

public class UberNetworkOrderDecorator extends AbstractTaxiOrderDecorator{

    public UberNetworkOrderDecorator(TaxiOrder taxiOrder) {
        super(taxiOrder);
    }

    @Override
    public BigDecimal getCost() {
        return super.getCost().add(new BigDecimal(20));
    }

    @Override
    public String getDiscription() {
        return super.getDiscription() + " by Uber Network";
    }
}
