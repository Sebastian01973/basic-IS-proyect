package models;

public class Product {

    private int code;
    private String nameProduct;
    private int units;
    private double price;
    private TypeProduct typeProduct;
    private String description;

    public Product(int code, String nameProduct, int units, double price, TypeProduct typeProduct, String description) {
        this.code = code;
        this.nameProduct = nameProduct;
        this.units = units;
        this.price = price;
        this.typeProduct = typeProduct;
        this.description = description;
    }

    private double calculatePriceTotal(){
        return (units*price);
    }



    public Object[] toObjectvector(){
        return new Object[]{
          this.code,this.nameProduct,this.units,this.price,
                convertTypeProductString(this.typeProduct.toString()),this.description,
                calculatePriceTotal()
        };
    }

    public String convertTypeProductString(String typeProduct){
        switch (typeProduct){
            case "CONCENTRATES": return "Concentrados";
            case "NECKLACES": return "Collares";
            case "HYGIENE_PRODUCT": return "Productos Aseo";
            case "MEDICINES": return "Medicamentos";
            case "VACCINES": return "Vacunas";
            default: return null;
        }
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public int getUnits() {
        return units;
    }

    public void setUnits(int units) {
        this.units = units;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public TypeProduct getTypeProduct() {
        return typeProduct;
    }

    public void setTypeProduct(TypeProduct typeProduct) {
        this.typeProduct = typeProduct;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    @Override
    public String toString() {
        return "Product{" +
                "code=" + code +
                ", nameProduct='" + nameProduct + '\'' +
                ", units=" + units +
                ", price=" + price +
                ", typeProduct=" + typeProduct +
                ", description='" + description + '\'' +
                '}';
    }
}
