import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	// write your code here

        VotingSystem votingSystem_1 = new VotingSystem();
        ArrayList<String> choices_1 = new ArrayList<String>();

        choices_1.add(0,"gozine_1");
        choices_1.add(1,"gozine_3");
        choices_1.add(2,"gozine_2");

        System.out.println("choice 1 :"+choices_1);
        ArrayList<String> choices_2 = new ArrayList<String>();
        choices_2.add("answer_1");
        choices_2.add("answer_2");
        choices_2.add("answer_3");
        choices_2.add("answer_4");

        votingSystem_1.createVoting("what's your choice ?",0,choices_1);
//        votingSystem_1.printVoting(0);

        choices_1.add(3,"gozine_1");
//        System.out.println("choices 11 :"+choices_1);
        votingSystem_1.createVoting("another question ?",1,choices_2);
        votingSystem_1.printVoting(1);

        Person p1 = new Person("ali","rezaei");
        Person p2 = new Person("shain","shaye");

        ArrayList<String> p1_choices = new ArrayList<String>();
        ArrayList<String> p2_choices = new ArrayList<String>();

        p1_choices.add("gozine_1");
        p2_choices.add("answer_1");
        p2_choices.add("answer_4");

        Person p3 = new Person("maryam","rezaei");
        ArrayList<String> p3_choices = new ArrayList<String>();

        p3_choices.add("random");

        votingSystem_1.vote(0,p1,p1_choices);
        votingSystem_1.vote(0,p3,p3_choices);
        System.out.println("results : ");
        votingSystem_1.printResult(0);

        votingSystem_1.vote(1,p2,p2_choices);

        System.out.println("result 2 :");
        votingSystem_1.printResult(1);
        votingSystem_1.removeVoting(0);
        votingSystem_1.printVottingQuestion();



    }
}
