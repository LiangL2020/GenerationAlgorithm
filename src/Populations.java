import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Populations {

    private String goal;
    private int generationNumber, size;
    private ArrayList<Chromosome> individual;

    public Populations(String goal, int size) {
        this.individual = new ArrayList<Chromosome>();
        this.goal = goal;
        this.generationNumber = 0;
//        changeVal = 5;
        this.size = size;

        for (int i = 0; i < size; i++) {
            Chromosome c = new Chromosome(goal.length());
            individual.add(c);
        }
    }

    public void sort(){
        Collections.sort(individual, new Comparator<Chromosome>() {
            @Override
            public int compare(Chromosome o1, Chromosome o2) {
                return o1.getCostScore() - o2.getCostScore();
            }
        });
    }

//    public void changeSomeVals(){
////        a = changeVal/2;
//        for (int i = 0; i < 5; i++) {
//            individual.remove(individual.size() - 1);
//        }
//        for (int j = 0; j < 5; j++) {
//            Chromosome c = new Chromosome(goal.length());
//            individual.add(c);
//            individual.get(individual.size() - j - 1).mutate(0.8);
//            individual.get(individual.size() - j - 1).calCost(goal);
//        }
//    }

    public void mate1(int a){
        // take a parent string from the arraylist and change a few letters
        for (int i = 0; i < a; i++) {
            individual.remove(individual.size() - 1);
        }

//        System.out.println("Size: " + size);
//        System.out.println("Individual Size: " + individual.size());
        for (int i = 0; i < a; i++) {
            Chromosome c = new Chromosome(goal.length());
            individual.add(c);
            int b = (int)(Math.random()*individual.size()); //a random string from the first 15 strings
//            System.out.println("*15: "+(int)(0.99*15));
//            int b = (int)(Math.random()*individual.size());
//            System.out.println("b1: " + b);
//            b = b - 1 - i;
//            System.out.println("b2: " + b);
            int d = (int)(Math.random()*goal.length() - 1); //a random number between 0 and the length of the goal
            double e = (Math.random()); //a random number between 0-0.99
            String temp = "";

            if(e < 0.5) {
                temp = individual.get(b).getCode().substring(0, d) + individual.get(individual.size() - 1).getCode().substring(d + 1);
            }else{
                temp = individual.get(individual.size()-1).getCode().substring(0, d) + individual.get(b).getCode().substring(d + 1);
            }

            individual.get(individual.size()-1).equals(temp);
        }
    }

    public void mate2(){
        for (int i = 0; i < individual.size()/6; i++) {
            int b = (int)(Math.random()*individual.size()/2); //a random string from the first 15 strings
            int c = (int)(Math.random()*individual.size()/2);
            int d = (int)(Math.random()*goal.length() - 1); //a random number between 0 and the length of the goal
            String temp = individual.get(b).getCode().substring(0,d) + individual.get(c).getCode().substring(d+1);
            individual.get((individual.size()-1)/2+i).equals(temp);
        }
    }

    public void

    public boolean generation(){

        for (int i = 0; i < individual.size(); i++) {
            individual.get(i).calCost(goal);
        }

        sort();
//        mate2();
        mate1(size*7/20); //7/20 ratio
        display();


        for (int i = 0; i < this.individual.size(); i++) {
            individual.get(i).mutate(0.5);
            individual.get(i).calCost(goal);
            if (individual.get(i).getCode() == goal) {
                this.sort();
                this.display();
                return true;
            }
        }

        int temp = 0;
        for (int i = 0; i < individual.size(); i++) {
            temp += individual.get(i).getCostScore();
        }

        temp = temp/individual.size();

        generationNumber++;
        System.out.println("avg cost: " + temp);
        System.out.println("generation number:" + generationNumber + "\n\n");
        return false;
    }

    public void display(){
        for (int i = 0; i < individual.size(); i++) {
            int a = i + 1;
            System.out.println(a);
            System.out.println("code: "+individual.get(i).getCode()+"\ncost score:"+individual.get(i).getCostScore());
        }
    }

    public int getGenerationNumber(){return generationNumber;}

//    public int getSize(){
//        return size;
//    }

}
