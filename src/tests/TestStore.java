package tests;

import models.Product;
import models.Store;
import models.TypeProduct;

public class TestStore {

    public static void main(String[] args) {
        Store store = new Store();
        Product product = store.createProduct("UWU",12,2300, TypeProduct.HYGIENE_PRODUCT,"Hola soy un producto");
        store.addProduct(product);
        Product product1 = store.createProduct("Como",92,23210, TypeProduct.HYGIENE_PRODUCT,"Hola soy un producto");
        store.addProduct(product1);
        Product product2 = store.createProduct("Lucifer",32,23300, TypeProduct.HYGIENE_PRODUCT,"Hola soy un producto");
        store.addProduct(product2);
        Product product3 = store.createProduct("Au",72,400, TypeProduct.CONCENTRATES,"Hola soy un producto");
        store.addProduct(product3);
        Product product4 = store.createProduct("Rico",17,300, TypeProduct.MEDICINES,"Hola soy un producto");
        store.addProduct(product4);
        Product product5 = store.createProduct("mami",12,1300, TypeProduct.HYGIENE_PRODUCT,"Hola soy un producto");
        store.addProduct(product5);

        store.printProducts();

    }
}
