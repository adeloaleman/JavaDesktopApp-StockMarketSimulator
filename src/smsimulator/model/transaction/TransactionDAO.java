package smsimulator.model.transaction;

import smsimulator.model.investor.*;
import smsimulator.model.company.*;
import java.util.ArrayList;

public interface TransactionDAO {
    public ArrayList<Transaction> getTransactions(ArrayList<Investor> investors, ArrayList<Company> companies);
    public boolean saveTransactions(ArrayList<Transaction> transactions);
    public boolean deleteAllFromTransaction();
}