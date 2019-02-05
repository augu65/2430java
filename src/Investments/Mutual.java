package Investments;
public  class Mutual extends Investment {

	/**
	 * prevents the assignment of null to any of the class types
	 * @param symbol
	 * @param name
	 * @param quantity
	 * @param price
	 * @param bookValue
	 */
	public Mutual(String symbol,String name, int quantity, double price, double bookValue) {
		super(symbol,name,quantity,price,bookValue);
	}
	/**
	 * assigns values to all fields
	 */
	public Mutual() {
		super();
	}
	/**
	 * @param Object o
	 * Compares the fields with the Instance of those fields in Invest
	 * @returns true | false
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
	 * @returns string of the object
	 */
	@Override
	public String toString(){
		return "type = \"MutualFund\"\n"+super.toString();
	}
	
}
