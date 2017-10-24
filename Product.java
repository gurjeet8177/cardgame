/**
 * This class Product defines/models the details of a product-its attributes and methods.
 * It will be used to create products that will be stocked in an inventory
 *
 * @author Anju Chawla
 * @since  June 2017
 * @version 1.0
 */
public class Product {

	// instance variables
	private String id;			// a unique identifying number for the product
	private String name; 		// the name of the product, may not be unique
	private int quantity; 		// the quantity of the product in stock
	private float price;		// the price of the product

        private int reorderLevel;///quantity when product is needed to reorder
         private int maximumQuantity;//maxixmum quantity where which product will be stocked

	/**
	 * Constructor to create objects of class Product
	 *
	 * @param id
	 *            to set the product's identifying number
	 * @param name
	 *            to set the name of the product
	 * @param quantity
	 *            to set the product's initial quantity
         * @param price 
         *                to set the quantity
	 */

	public Product(String id, String name, int quantity,float price) throws MyException
	{
		setId(id);
		setName(name);
		setQuantity(quantity);
		setPrice(price);
	}

	/**
	 * This method returns the identifying number of the product
	 *
	 * @return the identifying number of the product
	 */
	public String getId() {
		return this.id;
	}

	/**
	 * This method returns the name of the product
	 *
	 * @return the name of the product
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * This method returns the quantity of the product
	 *
	 * @return the quantity of the product in stock
	 */
	public int getQuantity() {
		return this.quantity;
	}

	/**
	 * This method returns the price of the product
	 *
	 * @return the price of the product
	 */
	public float getPrice() {
		return price;
	}

	/**
	 * This method sets the price of the product
	 *
	 * @param price
	 *            to set/change the price of the product
	 * @throws MyException if price <= 0
	 */

	public void setPrice(float price) throws MyException

	{
            if(price <=0)
                throw new MyException("Price must be greater then Zero ");//new MyException creates a an object 
            this.price=price;
	}

	/**
	 * This method sets the id of the product
	 *
	 * @param id
	 *            the identifying number of the product
	 */
	private void setId(String id) {

		this.id = id;
	}

	/**
	 * This method sets the name of the product
	 *
	 * @param name
	 *            the name of the product
	 */
	private void setName(String name) {
		this.name = name;
	}

	/**
	 * This method sets/changes the quantity of the product
	 *
	 * @param quantity
	 *            to set the quantity of the product
	 * @throws MyException if quantity <=0
	 */

	public void setQuantity(int quantity) throws MyException
	{
            if(quantity<=0)
                throw new MyException("quantity must be a greater then zero");
            this.quantity=quantity;
	}

	/**
     * This method returns a description of the product
     * @return The description including id, name and quantity of the product
     */

    @Override
    public String toString()
    {
        String info ="";

        info= String.format("%s: There are/is %d of %s in stock, priced at $%.2f%n",  getId(), getQuantity(),getName(),getPrice());

        return info;
    }

	/**
	 * This method adds the given amount of the product to its stock
	 * @param numberOfUnits
	 *            the number of items of a product to be added to the stock
	 * @throws MyException if amount <= 0
	 */

	public void addstock(int numberOfUnits) throws MyException
	{
            if(numberOfUnits<=0)
                throw new MyException("units to be added to product must gretare then zero");
                setQuantity(( getQuantity() + numberOfUnits ));
            

	}

	/**
	 * This method sells a product
	 *
	 * @throws MyException if there is no product in stock
	 */

	public void sellProduct() throws MyException
	{
            if (getQuantity()<=0)
                throw new MyException("product in stock");
             setQuantity(( getQuantity() -1 ));
	}

	/**
	 * This method sells some items of the product
	 *
	 * @param numberOfUnits
	 *            the number of items of a product to be sold
	 * @throws MyException if not enough in stock to sell
	 */

	public void sellProduct(int numberOfUnits) throws MyException
	{
            if(numberOfUnits<0)
                throw new MyException("enetr positive");
            
            if(getQuantity()<numberOfUnits)
                throw new MyException("not that much in quantity in stock");
            
            
            
                if (getQuantity()<=0)
                throw new MyException("procsucts not in stock");
                
             setQuantity(( getQuantity() -1 ));
	}

	/**
	 * This method overrides the equals method of the Object class
	 * Compares the current object with the object passed as a parameter
	 * @param obj the object to be compared with
	 */
	@Override
        
	public boolean equals(Object obj)
	{
            if(obj ==null)
                throw new IllegalArgumentException("product can not be null");
         Product p=(Product) obj;   //anyhting u give to fuction it converts to product type and store it in p
        /** if(this.getId().equalsIgnoreCase((p.getId())))
            return true;
            else
            return false;*/
         
         return this.getId().equalsIgnoreCase((p.getId()))?true : false ;
	}

    /**
     * @return the reorderLevel
     */
    public int getReorderLevel() {
        
        return reorderLevel;
    }

    /**
     * @param reorderLevel the reorderLevel to set
     */
    public void setReorderLevel(int reorderLevel) throws MyException {
        if(reorderLevel<0){
            throw new MyException("reorder must be greater tehn 0");
        }
        if(reorderLevel>=getQuantity())
             throw new MyException("reorder must be greater then quantity in stock");
        if(maximumQuantity<getQuantity())
            
            throw new MyException("this is cmplete shit,, crap crap crap");
        this.reorderLevel = reorderLevel;
    }

    /**
     * @return the maximumQuantity
     */
    public int getMaximumQuantity() {
        return maximumQuantity;
    }

    /**
     * @param maximumQuantity the maximumQuantity to set
     */
    public void setMaximumQuantity(int maximumQuantity) {
        this.maximumQuantity = maximumQuantity;
    }


}// of Product