package Investments;

public abstract class Investment {

	private String symbol;
	private String name;
	private int quantity;
	private double price;
	private double bookValue;
	/**
	 * prevents the assignment of null to any of the class types
	 * @param symbol
	 * @param name
	 * @param quantity
	 * @param price
	 * @param bookValue
	 */
	public Investment(String symbol,String name, int quantity, double price, double bookValue) {
		if(symbol == null) {
			this.symbol="";
		}else {
			this.symbol=symbol;
		}
		if(name==null) {
			this.name="";
		}else {
			this.name=name;
		}
		if(quantity <0) {
			this.quantity=0;
		}else {
			this.quantity=quantity;
		}
		if(price <0) {
			this.price=0;
		}else {
			this.price=price;
		}
		if(bookValue <0) {
			this.bookValue=0;
		}else {
			this.bookValue=bookValue;
		}
	}
	/**
	 * assigns values to all fields
	 */
	public Investment () {
		this.symbol="";
		this.name="";
		this.quantity=0;
		this.price=0;
		this.bookValue=0;
	}
	/**
	 * Compares the fields with the Instance of those fields in Invest
	 * @returns true | false
	 */
	@Override
	public boolean equals(Object o) {
		if(!(o instanceof Investment )) {
			return false;
		}else {
			Investment b = (Investment) o;
			if(!(this.getSymbol().equals(b.getSymbol()))) {
				return false;
			}
			if(!(this.getQuantity()==b.getQuantity())) {
				return false;
			}
			if(!(this.getName().equals(b.getName()))) {
				return false;
			}
			if(!(this.getPrice()==b.getPrice())) {
				return false;
			}
			if(!(this.getBookValue()==b.getBookValue())) {
				return false;
			}
		}
		return true;
	}
	/**
	 * 
	 * @see java.lang.Object#toString()
	 * @returns string of the object
	 */
	@Override
	public String toString(){
		return "symbol = \""+this.symbol+"\"\nname = \""+this.name+"\"\nquantity = \""+this.quantity+"\"\nprice = \""+this.price+"\"\nbookValue = \""+this.bookValue+"\"";
	}
	/**
	 * returns value of symbol
	 * @return symbol
	 */
	public String getSymbol() {
		return symbol;
	}
	/**
	 * returns value of name
	 * @return name
	 */
	public String getName() {
		return name;
	}
	/**
	 * returns value of quantity
	 * @return quantity
	 */
	public int getQuantity() {
		return quantity;
	}
	/**
	 * returns value of price
	 * @return price
	 */
	public double getPrice() {
		return price;
	}
	/**
	 * returns value of bookValue
	 * @return bookValue
	 */
	public double getBookValue() {

		return bookValue;
	}
	/**
	 * sets value of symbol
	 * @return symbol
	 */
	public void setSymbol(String symbol) {
		this.symbol=symbol;
	}
	/**
	 * sets value of name
	 * @return name
	 */
	public void setName(String name) {
		this.name=name;
	}
	/**
	 * sets value of quantity
	 * @return quantity
	 */
	public void setQuantity(int quantity) {
		this.quantity= quantity;
	}
	/**
	 * sets value of price
	 * @return price
	 */
	public void setPrice(double price) {
		this.price= price;
	}
	/**
	 * sets value of bookValue
	 * @return bookValue
	 */
	public void setBookValue(double bookValue) {

		this.bookValue=bookValue;
	}
}
