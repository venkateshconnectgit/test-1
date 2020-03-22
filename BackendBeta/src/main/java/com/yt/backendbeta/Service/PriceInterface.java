package com.yt.backendbeta.Service;

import com.yt.backendbeta.Entity.Price;

public interface PriceInterface {
    public void addPrice(Price price);
    public void updateTax(int tax);
    public Price getPrice(String course);
}
