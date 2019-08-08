package smsimulator.model.company;

import java.util.ArrayList;

public interface CompanyDAO {
    public ArrayList<Company> getCompanies();
    public boolean saveCompanies(ArrayList<Company> companies);
    public boolean deleteAllFromCompany();
}