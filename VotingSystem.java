import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

/**
 * creates voting and print result of vote
 * @author Ali Rezaei La'l
 */
public class VotingSystem {

    private ArrayList<Voting> votingList ;

    /**
     * make an array list of voting class
     */
    public VotingSystem(){
         votingList = new ArrayList<Voting>();
    }

    /**
     * creates a new vote .
     * @param question
     * @param type
     * @param choices
     */
    public void createVoting(String question , int type,ArrayList<String> choices){
        Voting voting = new Voting(type,question);
        for (String choice : choices){
            voting.createChoice(choice);
        }
        votingList.add(voting);
    }
    /**
     * returns voting list .
     * @return votingList
     */
    public ArrayList<Voting> getVotingList() {
        return votingList;
    }


    /**
     * returns index element of voting list
     * @param index
     * @return votingList.get(index)
     */
    public Voting getVoting(int index){
        return votingList.get(index);
    }

    /**
     * remove a voting element of the voting list
     * @param index
     */
    public void removeVoting(int index){
        if (index>=0 && index< votingList.size()){
            votingList.remove(index);
        }
        else {
            System.out.println("index is not valid");
        }

    }

    /**
     * prints all the questions in voting list
     */
    public void printVottingQuestion(){
        for (Voting voting : votingList){
            System.out.println("question : "+voting.getQuestion());
        }

    }
    /**
     * add a person to list of voter of a particular vote then submits their vote.
     * If they already voted for that voting he can't not vote again.
     * If the voting type is 0, he can vote randomly by "random" as their choice.
     * @param index
     * @param personName
     * @param choices
     */
    public void vote(int index,Person personName,ArrayList<String> choices){
        if (votingList.get(index).getType()==0 && choices.size()==1 && choices.get(0).equals("random")){

            Random random = new Random();
            int rand = random.nextInt(votingList.get(index).getPolls().size());
            choices.remove(0);
            choices.add(votingList.get(index).getPolls().get(rand));
        }

        votingList.get(index).vote(personName,choices);

    }

    /**
     * get a index for voting list and prints its question and choices of that case .
     * @param index
     */
    public void printVoting(int index){
        System.out.println("vote question : "+votingList.get(index).getQuestion());
        for (int i = 0;i<votingList.get(index).getPolls().size();i++){
            System.out.println("poll "+(i+1)+" : "+votingList.get(index).getPolls().get(i));
        }
    }

    /**
     * prints result of a particular vote
     * @param index
     */
    public void printResult(int index){
        votingList.get(index).printVotes();
    }


}

