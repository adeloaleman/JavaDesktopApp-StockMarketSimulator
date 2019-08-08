package smsimulator.model;

import java.util.ArrayList;
import java.util.Random;
import smsimulator.model.company.Company;
import smsimulator.model.investor.Investor;


public class InvestorsCompaniesCreator {
    
    private ArrayList<Company>  companies;
    private ArrayList<Investor> investors;
    
    
    public InvestorsCompaniesCreator(){
        companies = new ArrayList<Company>();
        investors = new ArrayList<Investor>();
    }
    
       
    public void setCompanies(int number){
        String[] names = { "Microsoft Corporation",               "Apple Inc.",                      "Amazon.com Inc.",                 "Facebook Inc. Class A",               "Berkshire Hathaway Inc. Class B",     "Alphabet Inc. Class C",            "Alphabet Inc. Class A",           "Johnson & Johnson",                           "Exxon Mobil Corporation",      "JPMorgan Chase & Co.",
                           "Visa Inc. Class A",                   "Bank of America Corp",            "Procter & Gamble Company",        "Intel Corporation",                   "Verizon Communications Inc.",         "Cisco Systems Inc.",               "UnitedHealth Group Incorporated", "Pfizer Inc.",                                 "Chevron Corporation",          "AT&T Inc.",
                           "Home Depot Inc.",                     "Mastercard Incorporated Class A", "Merck & Co. Inc.",                "Boeing Company",                      "Walt Disney Company",                 "Wells Fargo & Company",            "Comcast Corporation Class A",     "Coca-Cola Company",                           "PepsiCo Inc.",                 "Netflix Inc.",
                           "Citigroup Inc.",                      "McDonald s Corporation",          "Walmart Inc.",                    "Abbott Laboratories",                 "Oracle Corporation",                  "Philip Morris International Inc.", "Adobe Inc.",                      "International Business Machines Corporation", "3M Company",                   "PayPal Holdings Inc",
                           "AbbVie Inc.",                         "Union Pacific Corporation",       "salesforce.com inc.",             "Medtronic plc",                       "Amgen Inc.",                          "Broadcom Inc.",                    "Honeywell International Inc.",    "NVIDIA Corporation",                          "Accenture Plc Class A",        "Thermo Fisher Scientific Inc.",
                           "Eli Lilly and Company",               "Costco Wholesale Corporation",    "United Technologies Corporation", "NIKE Inc. Class B",                   "Texas Instruments Incorporated",      "Altria Group Inc",                 "Linde plc",                       "Starbucks Corporation",                       "Lowe s Companies Inc.",        "NextEra Energy Inc.",
                           "General Electric Company",            "Gilead Sciences Inc.",            "DowDuPont Inc.",                  "American Tower Corporation",          "Danaher Corporation",                 "Caterpillar Inc.",                 "Booking Holdings Inc.",           "United Parcel Service Inc. Class B",          "Bristol-Myers Squibb Company", "American Express Company",
                           "U.S. Bancorp",                        "Anthem Inc.",                     "ConocoPhillips",                  "Lockheed Martin Corporation",         "Mondelez International Inc. Class A", "QUALCOMM Incorporated",            "Goldman Sachs Group Inc.",        "Automatic Data Processing Inc.",              "CVS Health Corporation",       "Intuit Inc.",
                           "Becton Dickinson and Company",        "TJX Companies Inc",               "Celgene Corporation",             "Intuitive Surgical Inc.",             "Duke Energy Corporation",             "Chubb Limited",                    "Dominion Energy Inc",             "Cigna Corporation",                           "Schlumberger NV",              "CME Group Inc. Class A",
                           "Charter Communications Inc. Class A", "Stryker Corporation",             "Morgan Stanley",                  "PNC Financial Services Group Inc.",   "Colgate-Palmolive Company",           "CSX Corporation",                  "Simon Property Group Inc.",       "EOG Resources Inc.",                          "BlackRock Inc.",               "Charles Schwab Corporation"
                         };
        Random r = new Random();
        for (int i = 0 ; i < number ; i++){
            companies.add(new Company(names[i], getRandomNumberInRange(500, 1000), getRandomNumberInRange(10, 100)));
        }
    }
    
    
    public void setInvestors(int number){
        String[] names = {"Ana Paula Neves Ferreira", "Ana Renaux Morais",  "Adelo Vieira",   "Amilcar Aponte",   "Muhammad Iqbal",    "Greg South",         "John Snel",               "Graham Glanville", "Remo Jansen",        "Egemen Ciritoglu",
                          "Malika Bendechache",       "Noel Cosgrave",      "Michael Weiss",  "Mark Morrissey",   "David O Neill",     "Kyle Goslin",        "Larry Hogan",             "Conor O Reilly",   "Carole McGloughlin", "Jenny Treanor",
                          "Ken Healy",                "Rubén Blades",       "Muhammad Ali",   "Alí Primera",      "Silvio Rodríguez",  "Oscar D Leon",       "Héctor Lavoe",            "Frankie Ruiz",     "Willie Colón",       "Gilberto Santa Rosa",
                          "Eddie Santiago",           "Grupo Niche",        "Celia Cruz",     "Simón Díaz",       "Servando Primara",  "Florentino Primera", "Chino y Nacho",           "Franco De Vita",   "Yordano",            "Yoni Pacheco",
                          "Pablo Milanés",            "Camarón de la Isla", "Julio Iglesias", "Jacques Brel",     "Édith Piaf",        "Juanito Alimaña",    "Ricardo Montaner",        "Antonio Lauro",    "Guaco",              "José Luis Rodríguez",
                          "Reynaldo Armas",           "Frank Quintero",     "Reina Lucero",   "Armando Molero",   "Metallica",         "Jerry Rivera",       "José Alberto El Canario", "El Gran Combo",    "Los Adolescentes",   "Maelo Ruiz",
                          "Joaquin Sabina",           "Victor Jara",        "Facundo Cabral", "Violeta Parra",    "Mercedes Sosa",     "Atahualpa Yupanqui", "Caetano Veloso",          "Victor Heredia",   "Alfredo Zitarrosa",  "Manu Chao",
                          "Vicentico",                "El León Santillán",  "Diomedes Díaz",  "Rafael Orozco",    "El Binomio de Oro", "Los Diablitos",      "Daniel Celedón",          "Shakira",          "Ricky Martin",       "Chayanne",
                          "Daddy Yankee",             "Luis Miguel",        "Alejandro Sanz", "Juan Luis Guerra", "Marc Anthony",      "Rocio Durcal",       "Juan Gabriel",            "Gloria Estefan",   "Jose Jose",          "Miguel Bose",
                          "Camilo Sesto",             "Carlos Santana",     "Roberto Carlos", "Placido Domingo",  "Luciano Pavarotti", "Carlos Vives",       "Jose Feliciano",          "Rocio Jurado",     "Fito Paez",          "Compay Segundo"
                         };
        
        Random r = new Random();
        for (int i = 0 ; i < number ; i++){
            investors.add(new Investor(names[i], getRandomNumberInRange(1000, 10000)));
        }
        System.out.println(names.length);
    }
    
    
    public ArrayList<Company> getCompanies(){
        return companies;
    }
    
    
    public ArrayList<Investor> getInvestors(){
        return investors;
    }
    
    
    private static int getRandomNumberInRange(int min, int max){
        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
    
    
}