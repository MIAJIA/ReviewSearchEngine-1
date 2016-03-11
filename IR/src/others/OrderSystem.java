package others;

public class OrderSystem {
	private String productName = null;
	private int count = 0;
	private int unitPrice = 0;
	
	
	public int getTotalPrice() {
		return count * unitPrice;
	}
	public String toString() {
		return productName + "-"+getTotalPrice();
	}
	
	public static void main(String[] args) {
		OrderSystem o = new OrderSystem();
		o.setCount(10);
		o.setProductName("apple");
		o.setUnitPrice(2);
		System.out.println(o);
	}
	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(int unitPrice) {
		this.unitPrice = unitPrice;
	}

	
	
	
}
