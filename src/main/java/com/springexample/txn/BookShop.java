package com.springexample.txn;

public interface BookShop {
    public void purchase(String isbn, String username);

    public void increaseStock(String isbn, int stock);

    public int checkStock(String isbn);
}
