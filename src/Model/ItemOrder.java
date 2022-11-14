package Model;

public class ItemOrder {
    private Long idItemOrder;
    private Double price;
    private Double quantity;
    private Long idOrder;
    private Long idProduct;
    private String nameProduct;
    private Double total;
    private Double grandTotal;

    public ItemOrder() {

    }

    public ItemOrder(Long idItemOrder, Double price, Double quantity, Long idOrder, Long idProduct, String nameProduct, Double total, Double grandTotal) {
        this.idItemOrder = idItemOrder;
        this.price = price;
        this.quantity = quantity;
        this.idOrder = idOrder;
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
        this.total = total;
        this.grandTotal = grandTotal;
    }
    public static ItemOrder parseItemOrder(String rawItemOrder){
        String [] array = rawItemOrder.split(",");
        ItemOrder itemOrder = new ItemOrder();
        itemOrder.setIdItemOrder(Long.parseLong(array[0]));
        itemOrder.setPrice(Double.parseDouble(array[1]));
        itemOrder.setQuantity(Double.parseDouble(array[2]));
        itemOrder.setIdOrder(Long.parseLong(array[3]));
        itemOrder.setIdProduct(Long.parseLong(array[4]));
        itemOrder.setNameProduct(array[5]);
        itemOrder.setTotal(Double.parseDouble(array[6]));
        itemOrder.setGrandTotal(Double.parseDouble(array[7]));
        return itemOrder;
    }

    public Long getIdItemOrder() {
        return idItemOrder;
    }

    public void setIdItemOrder(Long idItemOrder) {
        this.idItemOrder = idItemOrder;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Long getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(Long idOrder) {
        this.idOrder = idOrder;
    }

    public Long getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Long idProduct) {
        this.idProduct = idProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Double getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(Double grandTotal) {
        this.grandTotal = grandTotal;
    }
    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s,%s,%s,%s,%s",
                idItemOrder,
                price,
                quantity,
                idOrder,
                idProduct,
                nameProduct,
                total,
                grandTotal);
    }
}
