import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Populations {

    private String goal;
    private int generationNumber;
    private ArrayList<Chromosome> individual;

    public Populations(String goal, int size) {
        this.individual = new ArrayList<Chromosome>();
        this.goal = goal;
        this.generationNumber = 0;
//        this.size = size;

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

    public void changeSomeVals(){
        for (int i = 0; i < 5; i++) {
            individual.remove(individual.size() - 1);
        }
        for (int j = 0; j < 5; j++) {
            Chromosome c = new Chromosome(goal.length());
            individual.add(c);
            individual.get(individual.size() - j - 1).mutate(0.8);
            individual.get(individual.size() - j - 1).calCost(goal);
        }
    }

    public boolean generation(){

        for (int i = 0; i < individual.size(); i++) {
            individual.get(i).calCost(goal);
        }
        sort();
        changeSomeVals();
//        display();

        for (int i = 0; i < this.individual.size(); i++) {
            individual.get(i).mutate(0.5);
            individual.get(i).calCost(goal);
            if (individual.get(i).getCode() == goal) {
                this.sort();
                this.display();
                return true;
            }
        }

        generationNumber++;
//        System.out.println("\n\n" + "generation number:" + generationNumber);
        return false;

    }

    public void display(){
        for (int i = 0; i < individual.size(); i++) {
            int a = i + 1;
            System.out.println(a);
            System.out.println("code: "+individual.get(i).getCode()+"\ncost score:"+individual.get(i).getCostScore());
        }
    }

//    public int getSize(){
//        return size;
//    }

}
