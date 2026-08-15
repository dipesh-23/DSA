class Solution {
    public String addBinary(String a, String b) {
        int alen= a.length();
        int blen = b.length();

        StringBuilder sb = new StringBuilder();
        StringBuilder sba = new StringBuilder(a);
        StringBuilder sbb = new StringBuilder(b);

        a = sba.reverse().toString();
        b= sbb.reverse().toString();

        int sum=0;
        int carry =0;

        int i=0;

        while(i< Math.min(alen,blen)){
            sum = carry+(a.charAt(i)-'0')+(b.charAt(i)-'0');
            
            sb.append(sum%2);
            carry = sum/2;
            i++;
        }

        while(i < blen){
            sum = carry+(b.charAt(i)-'0');
            sb.append(sum%2);
            carry = sum/2;
            i++;
        }

        while(i < alen){
            sum = carry+(a.charAt(i)-'0');
            sb.append(sum%2);
            carry = sum/2;
            i++;
        }

        if(carry == 1){
            sb.append('1');
        }

        return sb.reverse().toString();


    }
}