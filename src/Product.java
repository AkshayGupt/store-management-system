/** This is an abstract class which can be extended by any product class  */

abstract class Product
{
    String category;
    int product_no; 
    String name;
    String brand;
    double price;
    double discount;
    Product()
    {
        category=null;
        product_no=0;
        name=null;
        brand=null;
        price=0;
        discount=0;
    }
    Product(int p,String name,String brand,double price,double discount){

        this.price=price;
        this.name=name;
        this.product_no=p;
        this.discount=discount;
        this.brand=brand;
    }

    abstract void add( );
}