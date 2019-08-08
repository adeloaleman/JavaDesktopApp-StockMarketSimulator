package smsimulator.model.investor;

import smsimulator.model.company.*;
import java.util.ArrayList;

public interface InvestorDAO {
    public ArrayList<Investor> getInvestors();
    public boolean saveInvestors(ArrayList<Investor> investors);
    public boolean deleteAllFromInvestor();
}