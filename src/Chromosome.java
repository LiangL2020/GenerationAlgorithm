public class Chromosome {
    private String code;
    private int costScore;

    public Chromosome(int length){
        code = "";
        for (int i = 0; i < length; i++) {
            char c = (char)(int)(Math.random() * 72 + 65);
            code += c;
        }
        costScore = 9999;
//        char a = 'a';
//        int aV = (int)a;
//        char A = (char)65;
//
//        char random = (char)(int)(Math.random() * 128);
    }

    public Chromosome(String code){
        this.code = code;
        costScore = 9999;
    }

    //pivot at middle, return 2 offspring
//    public Chromosome[] mate(Chromosome other){
//    }

    public void calCost(String goal){
        int total = 0;
        for(int i = 0; i < this.code.length(); i++) {
            int temp  = (this.code.charAt(i) - goal.charAt(i));
            total += temp*temp;
//            total += Math.abs(temp);
        }
        costScore = total;
    }

    //chance < 1
    public void mutate(double chance) {
        if (Math.random() > chance) {
            return;
        }

        int index = (int)(Math.random() * this.code.length());
        double upOrDown = Math.random();
        //pick a char in the string randomly and add by 1/-1
        char rand = (char)((int)code.charAt(index) + (int)(Math.random()*3-1));

        String temp = code.substring(0, index) + rand + code.substring(index+1, code.length());
        code = temp;
    }


    public String getCode() {
        return code;
    }

    public int getCostScore() {
        return costScore;
    }
}
