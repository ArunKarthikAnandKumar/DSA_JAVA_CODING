package TCS;
class A extends Thread{
    
    public void run(){
       for (int i=0;i<10 ;i++ ){ 
        System.out.println("Class A");
        }
    }
}
class B extends Thread{
    
    public void run(){
        for (int i=0;i<10 ;i++ ){ 
        System.out.println("Class B");
        }
            
        }
}

public class Main
{
	public static void main(String[] args) {
		A obj=new A();
		obj.start();
		B obj1=new B();
		obj1.start();
	}
}
