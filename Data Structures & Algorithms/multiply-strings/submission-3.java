class Solution {
    // multiplication
    public String multiply(String num1, String num2) {
        if(num1 == "0" || num2 == "0"){
            return "0";
        }

        StringBuilder number1 = new StringBuilder();
        StringBuilder number2 = new StringBuilder();

        for(int i = 0; i < num1.length(); i++){
            number1.append(num1.charAt(i));
        }

        for(int j = 0; j < num2.length(); j++){
            number2.append(num2.charAt(j));
        }

        num1 = number1.reverse().toString();
        num2 = number2.reverse().toString();
        int[] result = new int[number1.length() + number2.length()];
        for(int i = 0; i < num1.length(); i++){
            for(int j = 0; j < num2.length(); j++){
                int num = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                result[i+j] += num;
                result[i+j+1] += (result[i+j] / 10);
                result[i+j] = (result[i+j] % 10);
            }
        }

        StringBuilder res = new StringBuilder();

        for(int i : result){
            res.append(String.valueOf(i));
        }

        int end = res.length() - 1;
        while(end > 0 && res.charAt(end) == '0'){
            res.deleteCharAt(end);
            end--;
        }

        return res.reverse().toString();
    }
}
