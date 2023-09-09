package com.trendyol.shipment;

import java.util.Arrays;
import java.util.List;

public enum ShipmentSize {

    SMALL,
    MEDIUM,
    LARGE,
    X_LARGE;
    
    public ShipmentSize returnNextBiggerSize() {
        List<ShipmentSize> list = Arrays.stream(ShipmentSize.values()).toList();
        ShipmentSize biggestSize = list.get(list.size() - 1);
        return list.stream().skip(list.indexOf(this) + 1).findFirst().orElse(biggestSize);
    }
    
    public boolean isBigger(ShipmentSize shipmentSize){
        return this.compareTo(shipmentSize) > 0;
    }
}

