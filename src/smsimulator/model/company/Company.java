package smsimulator.model.company;


public class Company {
    public  static int    idAutoIncrement;
    private final  int    id;
    private        String name;
    private        int    shares;
    private        double sharePrice;
    
    
    public Company(String name, int shares, double sharePrice){
        idAutoIncrement++;
        this.id         = idAutoIncrement;
        this.name       = name;
        this.shares     = shares;
        this.sharePrice = sharePrice;
    }
    
    public Company(int id, String name, int shares, double sharePrice){
        idAutoIncrement++;
        this.id         = id;
        this.name       = name;
        this.shares     = shares;
        this.sharePrice = sharePrice;
    }
    
    
    // Getters:
    public int getId(){
        return id;
    }
    
    public String getName(){
        return name;
    }
    
    public int getShares(){
        return shares;
    }
    
    public double getsharePrice(){
        return sharePrice;
    }
    
    
    // Setters:
    public void setName(String name){
        this.name = name;
    }
    
    public void setShares(int shares){
        this.shares = shares;
    }
    
    public void setSharePrice(double sharePrice){
        this.sharePrice = sharePrice;
    }
    
    
    @Override
    public String toString(){
        return "Company "+id+":                     \n"
                    +"\tName:        "+name+"       \n"
                    +"\tShares:      "+shares+"     \n"
                    +"\tShare price: "+sharePrice+" \n";
    }
    
}
