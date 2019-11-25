
class Main{
    public static void main(String args[]){
        Mall obj = new Mall();
        Thread t1 = new Thread(obj);
        Thread t2= new Thread(obj);
        Thread t3 = new Thread(obj);
        t1.start();
        t2.start();
        t3.start();
        try{
            t1.join();
            t2.join();
            t3.join();
        }
         catch(InterruptedException e)
         {
             System.out.println(e);
         }
        System.out.println("----------------------Store Closed-------------------------");
    }
}