
import java.util.*;
public class Mall implements Runnable{

  public  void run()
    {
        Scanner sc=new Scanner(System.in);
        System.out.println(" \t\t\t################# Welcome to Smart Store #################");
        System.out.println("Are you a customer YES/NO");
        String cus=sc.next();
        while(true)
        {
            switch(cus)
            {
                case "YES" :Customer obj = new Customer();
                        System.out.println("Watches\nBags");
                       String ch=sc.next();
                      
                        obj.show(ch);
                     break;
                case "NO": Owner obj1;
                System.out.println("Do you Want to Add or Remove");
                    ch=sc.next();
                    if(ch.equals("Add"))
                    {
                        System.out.println("Fill product details below:");
                        System.out.println("Enter category :\nw - watches \nb - bags");
                        char cat=sc.next().charAt(0);
                        System.out.println("Enter product number");
                        int p=sc.nextInt();
                        System.out.println("Enter product name");
                        String name=sc.next();
                        System.out.println("Enter product brand");
                        String brand = sc.next();
                        System.out.println("Enter product price");
                        double price = sc.nextDouble();
                        System.out.println("Enter product discount");
                        double dis=sc.nextDouble();
                    obj1 = new Owner("add",cat,p,name,brand,price,dis);
                    }
                    else if(ch.equals("Remove"))
                    {
                        System.out.println("Enter category ");
                        char cat=sc.next().charAt(0);
                        obj1 = new Owner("remove",cat,324324,"adadd","Sdfd",234,24);
                    }
                    break;
                    default:System.out.println("Wrong choice");
            }
            System.out.println("Do you want to exit the store ? YES / NO");
            if(sc.next().equals("YES"))
            break ;
        }

      l1:  System.out.println("Thank You , Visit Again");

    }
    
}