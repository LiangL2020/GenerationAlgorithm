public class Main {

    public static void main(String[] args) {
//        Populations population = new Populations("hello, world!", 20);


//        Chromosome a = new Chromosome(13);
//        while(a.getCostScore() != 0){
        Populations population = new Populations("Hello, World!", 10);
        population.generation();
//        }
        while (population.generation() == false);
        population.display();
//        System.out.println(population.getGenerationNumber());
//        System.out.println("happy");
    }

    /*
    Mr.Hopps code

    public class Main {

    public static void main(String[] args) {

        int popSize = 12;
        String goal = "Hello, World!";
        Population pop;
//        int sum = 0;
//        int num = 1000;

//        for (int i = 0; i < 1000; i++) {
//            pop = new Population(12, "Hello World");
//            while(pop.nextGen());
//        }

//        long time = System.currentTimeMillis();
//        for (int i = 0; i < num; i++) {
        pop = new Population(popSize, goal);
        while (!pop.nextGen());
//        }
//        System.out.println((System.currentTimeMillis()-time)/num + " ms per solution");
//        System.out.println(sum/num + " generations");
        pop.display();

    }
}
     */
}
