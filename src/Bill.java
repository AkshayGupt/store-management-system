import java.util.ArrayList;
class Bill extends Product
{
    void displayBill()
    {
        System.out.println("\t\tBILL");
        System.out.println("Id \tName\tMRP\tDiscount\tCost");
        double totalprice=0;
        for (int counter = 0; counter < bill.size(); counter++) { 		      
            
            double price=0;
            int i=0;
            String temp =bill.get(counter);
            temp.trim();
            temp=temp+" ";
           
            String pno=temp.substring(i,temp.indexOf(" "));
            System.out.print(pno+"\t");
            temp=temp.substring(temp.indexOf(" ")+1);
            // System.out.println("Brand: "+temp.substring(i,temp.indexOf(" ")));
            temp=temp.substring(temp.indexOf(" ")+1);
            System.out.print(temp.substring(i,temp.indexOf(" "))+"\t");
            temp=temp.substring(temp.indexOf(" ")+1);
            price=Double.parseDouble(temp.substring(i,temp.indexOf(" ")));
            System.out.print(temp.substring(i,temp.indexOf(" "))+"\t");
            temp=temp.substring(temp.indexOf(" ")+1);
            price  =price - (0.01*Double.parseDouble(temp.substring(i,temp.indexOf(" "))));
            System.out.print(temp.substring(i,temp.indexOf(" "))+"\t\t");

            System.out.print(price+"\t");

            totalprice+=price;
            System.out.println();
        }   
        
        System.out.println();
        System.out.println("Total Cost: "+totalprice);

        System.out.println("Added 18% GST");
        totalprice=totalprice+(0.18*totalprice);
        System.out.println("Final Price: "+totalprice);
    }
     void add( )
     {}
     boolean searchInStock(int n,String purpose ){
         return true;
     }
}