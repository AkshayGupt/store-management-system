/** This class deals with Watches and thus inherits the Product class */

import java.io.*;
import java.util.*;
class Watches extends Product
{
    
    Watches(){
        super();
    }
     Watches(int p,String name,String brand,double price,double discount ){
        super( p, name, brand, price, discount);
         category="watch";
        
    }

    void add()
    {
     
        File f = new File("watches.txt");
       
        try{
            boolean find=searchInStock(product_no,"add");
            if(find==false)
            {
                FileWriter fw = new FileWriter(f,true);
                String temp=product_no+" "+brand+" "+name+" "+price+" "+discount+" "+"1"+" "+System.getProperty("line.separator");
                fw.write(temp);     
                fw.close();
            }
        }
        catch(IOException ex)
        {
            System.err.println(ex+"**inside add**");
        }

      
    }

    void remove(int n)
    {
       
        File inputFile = new File("watches.txt");
        File tempFile = new File("myTempFile.txt");
        // File rr = new File("rrrr.txt");


        
                boolean find=searchInStock(n, "remove");
                if(find == false)
                {
                    System.out.println("Not Available!!");
                }
        
      
           
        

            
    }
    boolean searchInStock(int n,String purpose)
    {
        boolean flag=false;
        File f = new File("watches.txt");
        File inputFile = new File("watches.txt");
        File tempFile = new File("tempo_Stock.txt");
        try{
         
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
            
            String currentLine;
            while((currentLine = reader.readLine()) != null) {
               
                String trimmedLine = currentLine.trim();  // trim newline when comparing with lineToRemove
                int firstgap=trimmedLine.indexOf(" ");

                int pno=Integer.parseInt(trimmedLine.substring(0,firstgap));
                
                
                if(pno == n) {
                    int index = trimmedLine.lastIndexOf(" ");
                    int val=Integer.parseInt(trimmedLine.substring(index+1));
                    if(purpose.equals("add"))
                    val++;
                    else
                    {
                        if(val==0)
                        System.out.println("Not enough in Stock !!,Sorry");
                        else
                       {
                        val--;
                        bill.add(currentLine);
                        System.out.println("Congrats, transaction successfull!!");
                       }
                    }
                    trimmedLine=trimmedLine.substring(0,index+1)+Integer.toString(val)+" ";
                    flag=true;
                    writer.write(trimmedLine + System.getProperty("line.separator"));
                    continue;
                }
               
                writer.write(currentLine + System.getProperty("line.separator"));
            }
            writer.close(); 
            reader.close(); 

            
            //delete file
            inputFile.delete();
            //rename temp file
            boolean success = tempFile.renameTo(inputFile);
            // System.out.println(success);
        }
        catch(IOException e)
        {
            System.out.println(e+"**inside searchInStock**");
        }
       return flag;
        
    }
}