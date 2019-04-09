package myblog.bean;

import java.util.Date;

public class Order {
	private int id;
	private String supplier;
	private String buyer;
	private String vending;
	private String goods;
	private int num;
	private float price;
	private Date time;

	public Order() {
		super();
	}

	public Order(String supplier, String buyer, String vending, String goods, int num, float price, Date time) {
		super();
		this.supplier = supplier;
		this.buyer = buyer;
		this.vending = vending;
		this.goods = goods;
		this.num = num;
		this.price = price;
		this.time = time;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}

	public String getBuyer() {
		return buyer;
	}

	public void setBuyer(String buyer) {
		this.buyer = buyer;
	}

	public String getVending() {
		return vending;
	}

	public void setVending(String vending) {
		this.vending = vending;
	}

	public String getGoods() {
		return goods;
	}

	public void setGoods(String goods) {
		this.goods = goods;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}
	@Override
    public String toString() {
        return "Order [goods=" + goods + ", num=" + num + "]";
    }

}
