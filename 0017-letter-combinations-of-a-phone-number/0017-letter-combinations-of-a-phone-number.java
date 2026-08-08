class Solution {
    public void f(int index,String digits,List<String> list, StringBuilder sb,List<String> res){

        if(index == digits.length()){
            res.add(new StringBuilder(sb).toString());
            return;
        }

        int digit = digits.charAt(index)-'0';
        for(int i=0; i<list.get(digit).length(); i++){
            sb.append(list.get(digit).charAt(i));
            f(index+1,digits,list,sb,res);
            sb.deleteCharAt(sb.length()-1);
        }

    }
    public List<String> letterCombinations(String digits) {
        
        List<String> res = new ArrayList<>();
        List<String> list = new ArrayList<>();
        list.add("#");
        list.add("#");
        list.add("abc");
        list.add("def");
        list.add("ghi");
        list.add("jkl");
        list.add("mno");
        list.add("pqrs");
        list.add("tuv");
        list.add("wxyz");

        f(0,digits,list,new StringBuilder(),res);

        return res;
    }
}