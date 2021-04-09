/**
 * store person and date voted
 * @author Ali Rezaei La'l
 */
public class Vote {

    private Person person;
    private String date;

    /**
     * creates new object of Vote class.
     * @param person
     * @param date
     */
    public Vote(Person person,String date){
        this.person = person;
        this.date = date;
    }

    /**
     * return person Object
     * @return person
     */
    public Person getPerson() {
        return person;
    }

    /**
     * return date of vote
     * @return date
     */
    public String getDate() {
        return date;
    }

    /**
     * this method check if a vote is equal to another vote
     * @param obj
     * @return a boolean . when two objects are equal it will be true else false .
     */
    @Override
    public boolean equals(Object obj) {

        if (this == obj){
            return true;
        }
        else if (!(obj instanceof Vote)){
            return false;
        }
        Vote vote = (Vote) obj;
        if (!getPerson().equals(vote.getPerson())){
            return false;
        }
        return getDate().equals(vote.getDate());

    }

    /**
     * returns a hash code value for object
     * @return res that is a hash code
     */
    @Override
    public int hashCode(){
        int hash;
        hash = getPerson().hashCode();
        hash = 31 * hash + getDate().hashCode();
        return hash;
    }
}


