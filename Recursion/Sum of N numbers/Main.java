public class Main {
    
    static void func1(int i, int sum){
        if(i<1){
            System.out.println(sum);
            return;
        }
        func1(i-1,sum+i);
            
    }
    static int func2(int i){
        if(i==0){
            return 0;
        }
        return i+func2(i-1);
            
    }
    public static void main(String[] args) {

       // Here, let’s take the value of n to be 3.
       int n = 3;
       System.out.println(func2(n));
    }
}