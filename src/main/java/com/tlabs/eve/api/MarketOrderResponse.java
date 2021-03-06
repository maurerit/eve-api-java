package com.tlabs.eve.api;


import java.util.ArrayList;
import java.util.List;

public class MarketOrderResponse extends EveAPIResponse {

    private static final long serialVersionUID = -8260545530317659668L;

    private List<MarketOrder> buyOrders;
    private List<MarketOrder> sellOrders;

    public MarketOrderResponse() {
        super();
        this.buyOrders = new ArrayList<>();
        this.sellOrders = new ArrayList<>();
    }

    public List<MarketOrder> getBuyOrders() {
        return this.buyOrders;
    }

    public List<MarketOrder> getSellOrders() {
        return this.sellOrders;
    }

    public void addOrder(MarketOrder order) {
        if (order.getIsBuyOrder()) {
            this.buyOrders.add(order);
        }
        else {
            this.sellOrders.add(order);
        }
    }
}
