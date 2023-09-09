package com.trendyol.shipment;

import java.util.HashMap;
import java.util.List;

public class Basket {

    private List<Product> products;
	private enum Constant {
		SHIPMENT_SIZE_THRESHOLD(3);

		public final int value;

		Constant(int value){
			this.value = value;
		}
	}
    public ShipmentSize getShipmentSize() {
    	HashMap<ShipmentSize, Integer> shipmentSizeAmounts = new HashMap<>();
		ShipmentSize largestProductSize = null;

		for (Product product : products) {
    		ShipmentSize productSize = product.getSize();
    		int productSizeShipmentAmount = shipmentSizeAmounts.getOrDefault(productSize, 0) + 1;
    		shipmentSizeAmounts.put(productSize, productSizeShipmentAmount);
    		if(productSizeShipmentAmount == Constant.SHIPMENT_SIZE_THRESHOLD.value) {
    			return productSize.returnNextBiggerSize();
    		}
			if(largestProductSize == null || productSize.isBigger(largestProductSize)) {
    	    	largestProductSize = productSize;
    	    }
    	}
        return largestProductSize;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
