package com.quocnguyen.giohang.model;

import com.quocnguyen.giohang.entity.Product;

import java.util.ArrayList;
import java.util.List;

public class Card {
    private final List<CardItem> items;
    private double total;


    public Card() {
        this.items = new ArrayList<CardItem>();
        this.total = 0;
    }

    public double getTotal() {
        double total=0;
        for(CardItem item:items){
           total+= item.getSubTotal();
        }
        return total;
    }

    public CardItem getItem(Product product) {
        for (CardItem item : items) {
            if (item.getProduct().getId() == product.getId()) {
                return item;
            }
        }
        return null;
    }

    public List<CardItem> getItems() {
        return items;
    }

    //sub item
    public int getItemCount() {
        return items.size();
    }

    public void addItem(CardItem cardItem) {
        addItem(cardItem.getProduct(), cardItem.getQuantity());
    }

    public void addItem(Product product, int quatity) {
        CardItem item = getItem(product);
        // neeus ton tai + sl
        if (item != null) {
            item.setQuantity(item.getQuantity() + quatity);
        }
        // khong ton tai thi phai set moi
        else {
            item = new CardItem(product);
            item.setQuantity(quatity);
            items.add(item);
        }
    }

    public void updateItem(Product product, int quantity) {
        CardItem item = getItem(product);
        if (item != null) {
            item.setQuantity(quantity);
        }
    }

    public void removeItem(Product product) {
        CardItem item = getItem(product);
        if (item != null) {
            items.remove(item);
        }
    }

    public void clear() {
        items.clear();
        total = 0;
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

}
