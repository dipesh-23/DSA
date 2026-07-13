class Solution {
    public List<Integer> sequentialDigits(int low, int high) {

        String s = "123456789";

        List<Integer> list = new ArrayList<>();
        String l = String.valueOf(low);
        int p = l.length();

        int num = Integer.parseInt(s.substring(0,p));
        int i=1;

        while(num <= high){

            if(num >= low){
                list.add(num);
            }
            if(i>s.length()-p){
                p++;
                i=0;
            }

            if(p == 10){
                break;
            }
            num = Integer.parseInt(s.substring(i,i+p));
            i++;
        }


        return list;

        
    }
}