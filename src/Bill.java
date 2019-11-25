import java.util.*;
import java.io.*;
import java.text.SimpleDateFormat;  
class Bill extends Product
{
    String username;
    String usercontact;
    double totalprice = 0;
    void displayBill()
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter your Name: ");  
         username = sc.nextLine();    
        System.out.println("Your Phone Number");
         usercontact = sc.next();
        System.out.println("\t\tBILL");
        System.out.println("Dear "+username+",");
        System.out.println(usercontact);
        System.out.println("Id \tName\tMRP\tDiscount\tCost");
        
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
        add();
        bill.clear();
    }
     void add( )
     {
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());
        // System.out.println(formatter.format(date));
        

         try{
         File record = new File("record.txt");
         FileWriter fw =new FileWriter(record,true);
         String str = username+" "+usercontact+" "+Double.toString(totalprice)+" "+formatter.format(date)+"\n";
         fw.write(str);
         fw.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }

     }
     boolean searchInStock(int n,String purpose ){
         return true;
     }
}