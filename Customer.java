
/**
 * Each instance of this class represents one of Uncle Phil's customers.  
 * 
 * @author Andrew Nuxoll and Jonathan Liao
 * @version 3.2.2015
 */
public class Customer
{
    /* ---=== Instance Variables ===--- */
    private String nickname;
    private String description;
    private int visitTime;  //hour of the day on 24 hour clock
    private boolean daily; //does this customer visit every day?
    private boolean poverty; //does this person live in poverty?
    
    private int count; //how many different periodicals this customer bought
    private Periodical[] pRef; //array of references
    private int numPurchaes;
    
    /* ---=== Methods ===--- */

    public Customer(String initNickname, int initVisitTime, boolean initDaily, boolean initPoverty)
    {
        nickname = initNickname;
        visitTime = initVisitTime;
        daily = initDaily;
        description = "";
        numPurchaes = 0;
        
        pRef = new Periodical[10]; 
        for(int i = 0; i < pRef.length; i++){
            pRef[i] = null;
        }
        //%%%YOU WILL COMPLETE THIS METHOD
    }//ctor
    
    public void printSummary() {
        System.out.println("Nickname: " + this.nickname);
        System.out.println("Description: " + this.description);
        System.out.println("Visit Time: " + this.visitTime);
        System.out.println("Daily Visit?: " + this.daily);
        System.out.println("Live in poverty?: " + this.poverty);
        
        System.out.println("This customer has bought the following titles: ");
        for(int i = 0; i < this.pRef.length; i++){
            if(this.pRef[i] != null) {
                System.out.println(this.pRef[i].getTitle());
            }
        }
        
        System.out.println("Number of Purchases: " + this.numPurchaes);
    }
    
    /** accessor for daily */
    public boolean isDaily()
    {
        return daily;
    }
    
    public String getNickname() {
        return nickname;
    }
    
    public void fillDescription(String initDescription) {
        description = initDescription;
    }
    
    public String getDescription()
    {
        return description;
    }
    
    public void setVisitTime(int newTime) {
        visitTime = newTime;
    }
    
    public void buyPeriodical(Periodical initPeriodical) {
        this.numPurchaes++;
        
        boolean already = false;
        for(int i = 0; i < this.pRef.length; i++){
            if(this.pRef[i] != null) {
                if(initPeriodical.getTitle().equals(this.pRef[i].getTitle())) {
                    already = true;
                    break; //escape the forloop because this periodical has already been written
                }
            }
        }
        
        if(!already) {
            for(int i = 0; i < this.pRef.length; i++){
                if(this.pRef[i] == null) {
                    this.pRef[i] = initPeriodical;
                    break; //escape the forloop because this periodical has already been written
                }
                else if(i == 9) {
                    System.out.println(this.nickname + " has already bought 10 different titles. No more titles can fit on their list.");
                }
            }
        }
        
    }
    
    public void returnPeriodical(Periodical initPeriodical) {
        this.numPurchaes--;
        
        for(int i = 0; i < this.pRef.length; i++){
            if(this.pRef[i] != null) {
                if(initPeriodical.getTitle().equals(this.pRef[i].getTitle())) {
                    pRef[i] = null;
                    break; //escape the forloop because this periodical has already been written
                }
            }
        }
    }
}//class Customer
