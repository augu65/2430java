package Investments;
public class Stock extends Investment {

	/**
	 * prevents the assignment of null to any of the class types
	 * @param symbol [String]
	 * @param name [String]
	 * @param quantity [int]
	 * @param price [double]
	 * @param bookValue [double]
	 */
	public Stock(String symbol,String name, int quantity, double price, double bookValue) {
		super(symbol,name,quantity,price,bookValue);
	}
	/**
	 * assigns values to all fields
	 */
	public Stock() {
		super();
	}
	/**
	 * Compares the fields with the Instance of those fields in Invest
	 * @return true || false
	 */
	@Override
	public boolean equals(Object o) {
		if(this==o) {
			return true;
		}else if(o == null) {
			return false;
		} else if(!(this.getClass().equals(o.getClass()))) {
			return false;
		}
		return (super.equals(o));
	}
	/**
	 * 
	 * @see java.lang.Object#toString()
	 * @return string
	 */
	@Override
	public String toString(){
		return "type = \"Stock\"\n"+super.toString();
	}
}
