import java.util.*;

import ir.huri.jcal.JalaliCalendar;

/**
 * voting class creates a voting with question , type and choices
 * type can be 1 choice or multi choices . if type = 0 it will have 1 choice else type will be equals to 1 .
 * @author Ali Rezaei La'l
 */
public class Voting {

    private int type;
    private String question;
    private HashMap<String,HashSet<Vote>> polls;
    private ArrayList<Person> voters;

    /**
     * creates new object of Voting class with given type and question .
     * @param type
     * @param question
     */
    public Voting(int type,String question){
        this.type = type;
        this.question = question;
        voters = new ArrayList<Person>();
        polls = new HashMap<String, HashSet<Vote>>();
    }

    /**
     * returns question of vote .
     * @return question
     */
    public String getQuestion() {
        return question;
    }

    /**
     * returns type of vote
     * @return type
     */
    public int getType() {
        return type;
    }

    /**
     * add a new poll in polls list
     * @param choice
     */
    public void createChoice(String choice){
        HashSet<Vote> votes = new HashSet<Vote>();
        polls.put(choice,votes);
        System.out.println("polls : "+polls);
    }

    /**
     * add a new person to list of voters .
     * if he already exits in list he can't vote .
     */
    public void vote(Person person,ArrayList<String> choices){
        for (Person per : voters){
            if (per.equals(person)){
                System.out.println("you can't vote any more .");
                return;
            }
        }

        for (String choice : choices){
            voters.add(person);
            GregorianCalendar gregorianCalendar = new GregorianCalendar();
            JalaliCalendar jalaliCalendar = new JalaliCalendar(gregorianCalendar);
            Vote newVote = new Vote(person,jalaliCalendar.toString());
            HashSet<Vote> votes = polls.get(choice);
            votes.add(newVote);

        }
        System.out.println("the vote submitted");

    }

    /**
     * prints every person information who voters
     */
    public void getVoters() {
        for (int i=0;i<voters.size();i++){
            System.out.println("voter"+(i+1)+" : "+voters.get(i).getFirstName()+" "+voters.get(i).getLastName());
        }
    }

    /**
     * print choices in poll and all people who voted that choice
     */
    public void printVotes(){

        Set<String> sets = polls.keySet();
        ArrayList<String> setList = new ArrayList<>(sets);

        for (int i = 0;i<setList.size();i++){
            System.out.println("number of " +setList.get(i)+" : "+polls.get(setList.get(i)).size());
            for (Vote vote : polls.get(setList.get(i))){
                System.out.println(vote.getPerson().getFirstName()+" "+vote.getPerson().getLastName()+" voted in : "+vote.getDate());
            }
        }

    }

    /**
     * returns String array list of polls
     * @return pollsList
     */
    public ArrayList<String> getPolls() {
        Set<String> sets = polls.keySet();
        ArrayList<String> pollsList = new ArrayList<>(sets);
        return pollsList;
    }
}
