
import java.util.*;
import java.io.*;
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
                case "NO": 
                        boolean isAdmin = checkAdmin();
                        if(isAdmin)
                        {

                        
                Owner obj1;
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
                }
                else{
                    System.out.println("Sorry !Wrong Password or USer ID\n Try again");
                }
                    break;
                    default:System.out.println("Wrong choice");
            }
            System.out.println("Do you want to exit the store ? YES / NO");
            if(sc.next().equals("YES"))
            break ;
        }
        if(cus.equals("YES"))
        {
            Bill obj=new Bill();
            obj.displayBill();
        }
       System.out.println("Thank You , Visit Again");

    }

    boolean checkAdmin()
    {
       
        File f = new File("admin.txt");
        // System.out.println(new File("admin.txt").getAbsolutePath());
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter id");
        String id=sc.next();
        // System.out.println("Enter Password");
        // String password=sc.next();
        
        // try{
        //     FileWriter fw =new FileWriter(f);
        //     String str="UserID Pass@##"; //Admin id and password
        //     fw.write(str);
        //     fw.close();
        // }
        // catch(Exception e)
        // {
        //     System.out.println("Error "+e);
        // }
        try{
            File inputFile = new File("admin.txt");
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            String str = reader.readLine();
            str.trim();
            int firstgap = str.indexOf(" ");
            if(id.equals(str.substring(0,firstgap)))
            {

                return new Mall().password(str.substring(firstgap+1));
            }
            else
            return false;
        }
        catch(IOException e)
        {
            System.out.println("Errrr");
        }
        return false;
        


    }
    public boolean password(String pass) {        
        Console console = System.console();
        if (console == null) {
            System.out.println("Couldn't get Console instance");
            System.exit(0);
        }

        console.printf("Testing password%n");
        char[] passwordArray = console.readPassword("Enter your secret password: ");
        String toch = new String(passwordArray);
        if(toch.equals(pass))
       return true;
       else
       return false;

    }
    
}