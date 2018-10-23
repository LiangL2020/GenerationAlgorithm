public class Chromosome {
    private String code;
    private int costScore;

    public Chromosome(int length){
        code = "";
        for (int i = 0; i < length; i++) {
            char c = (char)(int)(Math.random() * 94 + 33);
//            char c = (char)(int)(Math.random() * 128); //gets negative huge cost scores
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

    //pivot at middle. returns 2 offspring
    public Chromosome[] mate(Chromosome other){
        int pivot = code.length()/2+1;
        String firstChild = code.substring(0, pivot) + other.getCode().substring(pivot);
        String secondChild = other.getCode().substring(0, pivot) + code.substring(pivot);
        Chromosome[] kids = {new Chromosome(firstChild), new Chromosome(secondChild)};
        return kids;
    }

    //alternating chars.  Experimenting.
    public Chromosome[] mate2(Chromosome other){
        String kid1 = "";
        String kid2 = "";
        for (int i = 0; i < code.length(); i++) {
            if(i % 2 == 0) {
                kid1 += code.charAt(i);
                kid2 += other.code.charAt(i);
            }else{
                kid2 += code.charAt(i);
                kid1 += other.code.charAt(i);
            }
        }
        Chromosome[] ans = {new Chromosome(kid1), new Chromosome(kid2)};
        return ans;

    }

    //chance < 1
    public void mutate(double chance) {
        if (Math.random() > chance) {
            return;
        }

        int index = (int)(Math.random() * this.code.length());
        //pick a char in the string randomly and add by 1/-1
        char rand = (char)((int)code.charAt(index) + (int)(Math.random()*5-2));

        String temp = code.substring(0, index) + rand + code.substring(index+1, code.length());
        code = temp;
    }


    public String getCode() {
        return code;
    }

    public int getCostScore() {
        return costScore;
    }


/*
Mr.Hopps code
public class Chromosome {

    private String code;
    private int costScore;

    //Makes a random string of the given length.
    public Chromosome(int length){
        code = "";
        for (int i = 0; i < length; i++) {
            char c = (char)(int)(Math.random()*256);
            code += c;
        }
        costScore = 9999;
    }
    public Chromosome(String code){
        this.code = code;
        costScore = 9999;
    }

    //pivot at middle. returns 2 offspring
    public Chromosome[] mate(Chromosome other){
        int pivot = code.length()/2+1;
        String firstChild = code.substring(0, pivot) + other.getCode().substring(pivot);
        String secondChild = other.getCode().substring(0, pivot) + code.substring(pivot);
        Chromosome[] kids = {new Chromosome(firstChild), new Chromosome(secondChild)};
        return kids;
    }

    //alternating chars.  Experimenting.
    public Chromosome[] mate2(Chromosome other){
        String kid1 = "";
        String kid2 = "";
        for (int i = 0; i < code.length(); i++) {
            if(i % 2 == 0) {
                kid1 += code.charAt(i);
                kid2 += other.code.charAt(i);
            }else{
                kid2 += code.charAt(i);
                kid1 += other.code.charAt(i);
            }
        }
        Chromosome[] ans = {new Chromosome(kid1), new Chromosome(kid2)};
        return ans;

    }

    public void mutate(double chance){
        if(Math.random() > chance)
            return; //don't mutate.
        int index = (int)(Math.random()*code.length());
        int charInt = (int)(code.charAt(index));
        int sign = 1;
        if(Math.random() < .5)
            sign *= -1;
        charInt += (int)(Math.random()*5+1)*sign;   //+- 1-5 to char
        code = code.substring(0, index) + (char)(charInt) + code.substring(index+1);
        if(Math.random() < chance)
            mutate(chance);
    }

    public void calculateScore(String goal){
        int total = 0;
        for (int i = 0; i < code.length(); i++) {
            char a = goal.charAt(i);
            char b = code.charAt(i);
            int diff = (int)a - (int)b;
            total += diff*diff;
        }
        costScore = total > -1 ? total : 999999;
    }

    public String getCode() {
        return code;
    }

    public int getCostScore() {
        return costScore;
    }
}
 */
}
