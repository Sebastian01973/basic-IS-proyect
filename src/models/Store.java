package models;

import java.util.ArrayList;

public class Store {

    private ArrayList<Product> productsStore;
    private int[] codesType;

    public Store() {
        productsStore = new ArrayList<>();
        codesType = new int[6];
        initCodes();
    }

    public int[] getCodeType() {
        return codesType;
    }

    public void initCodes(){
        int count = 0;
        for (int i = 0; i < codesType.length; i++) {
            codesType[i] = count;
            count += 250;
        }
    }

    public ArrayList<Object[]> getMatrixProducts(){
        ArrayList<Object[]> arrayProducts = new ArrayList<>();
        for (Product product:productsStore) {
            arrayProducts.add(product.toObjectvector());
        }
        return arrayProducts;
    }

    public TypeProduct getType(int value){
        switch (value){
            case 1: return TypeProduct.CONCENTRATES;
            case 2: return TypeProduct.NECKLACES;
            case 3: return TypeProduct.HYGIENE_PRODUCT;
            case 4: return TypeProduct.DEWORMERS;
            case 5: return TypeProduct.MEDICINES;
            case 6: return TypeProduct.VACCINES;
            default: return null;
        }
    }
    public Product createProduct(String name,int units,double price,TypeProduct typeProduct,String description){
        return new Product(generateCode(typeProduct),name,units,price,typeProduct,description);
    }

    public void printProducts(){
        for (Product p:productsStore) {
            System.out.println(p.toString());
        }
    }

    public void addProduct(Product product){
        productsStore.add(product);
    }


    public int generateCode(TypeProduct typeProduct){
        TypeProduct[] types = TypeProduct.values();
        for (int i = 0; i < types.length; i++) {
            if (typeProduct.equals(types[i])){
                codesType[i] = codesType[i] + 1;
                return codesType[i];
            }
        }
        return -1;
    }
    public boolean isExistProduct(int code){
        for (Product product:productsStore) {
            if (product.getCode() == code){
                return true;
            }
        }
        return false;
    }


    public Product searchProduct(int code){
        for (Product product:productsStore) {
            if (product.getCode() == code){
                return product;
            }
        }
        return null;
    }

    public void deleteProduct(Product product){
        productsStore.removeIf(product1 -> product.getCode() == product1.getCode());
    }

    public ArrayList<Product> getProductsStore() {
        return productsStore;
    }
}
