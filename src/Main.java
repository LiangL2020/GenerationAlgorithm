public class Main {

    public static void main(String[] args) {
//        Populations population = new Populations("hello, world!", 20);


//        Chromosome a = new Chromosome(13);
//        while(a.getCostScore() != 0){
        Populations population = new Populations("hello, world!", 20);
        population.generation();
//        }
        while (population.generation() == false);
        population.display();
//        System.out.println("happy");
    }
}
