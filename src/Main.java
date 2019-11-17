
class Main{
    public static void main(String args[]){
        Mall obj = new Mall();
        Thread t1 = new Thread(obj);
        t1.start();
    }
}