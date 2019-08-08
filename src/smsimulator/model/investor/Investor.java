package smsimulator.model.investor;


public class Investor {
    public static int    idAutoIncrement;
    private final  int    id;
    private        String name;
    private        double budget;
    
    
    public Investor(String name, double budget){
        idAutoIncrement++;
        this.id         = idAutoIncrement;
        this.name       = name;
        this.budget     = budget;
    }
    
    public Investor(int id, String name, double budget){
        idAutoIncrement++;
        this.id         = id;
        this.name       = name;
        this.budget     = budget;
    }
    
    
    // Getters:
    public int getId(){
        return id;
    }
    
    public String getName(){
        return name;
    }
    
    public double getBudget(){
        return budget;
    }
    
    
    // Setters:
    public void setName(String name){
        this.name = name;
    }
    
    public void setBudget(double budget){
        this.budget = budget;
    }
    
    
    @Override
    public String toString(){
        return "Investor "+id+":                \n"
                    +"\tName:        "+name+"   \n"
                    +"\tShares:      "+budget+" \n";
    }
    
}
