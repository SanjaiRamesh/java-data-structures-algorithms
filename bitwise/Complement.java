package bitwise;

public class Complement {

    public int bitwiseComplement(int n) {

        int ans =0;
        int power=1;

        int num=n;
        if(n==0) {
            return 1;
        }
        while(num>0){
            int rem = num%2 == 1? 0:1;
            if(rem == 1) {
                ans+=power;
            }
            num = num/2;

            power *=2;

        }
        return ans;


    }

    public static void main(String[] args) {
        Complement c = new Complement();
        System.out.println(c.bitwiseComplement(6));
        System.out.println(c.bitwiseComplement(5));
    }
}
