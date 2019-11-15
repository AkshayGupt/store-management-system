/** This class deals with Watches and thus inherits the Product class */

import java.io.*;
class Watches extends Product
{
    static int watch_count=1;
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
            FileWriter fw = new FileWriter(f,true);
            // BufferedWriter bw = new BufferedWriter(new FileWriter(f,true));
            String temp=product_no+" "+brand+" "+name+" "+price+" "+discount+" "+System.getProperty("line.separator");
            fw.write(temp);            
            // bw.newLine();
            fw.close();
            // bw.close();
        }
        catch(IOException ex)
        {
            System.err.println(ex);
        }
       
    }

    void remove(int n)
    {
       
        File inputFile = new File("watches.txt");
        File tempFile = new File("myTempFile.txt");
        File rr = new File("rrrr.txt");
        try{

         
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
            
            String currentLine;
            while((currentLine = reader.readLine()) != null) {
               
                String trimmedLine = currentLine.trim();  // trim newline when comparing with lineToRemove
                int index=trimmedLine.indexOf(" ");

                int pno=Integer.parseInt(trimmedLine.substring(0,index));
                
                
                if(pno == n) continue;
                // System.out.println(trimmedLine);
                // System.out.println("***********************");
                writer.write(currentLine + System.getProperty("line.separator"));
            }
            writer.close(); 
            reader.close(); 

            
            //delete file
            // File f = new File("myTempFile.txt");
            // success = f.delete();

            //System.out.println(success);
            inputFile.delete();
            boolean success = tempFile.renameTo(inputFile);
        }
        catch(IOException e)
        {
            System.out.println(e+"....");
        }
       
        
    }
    
}