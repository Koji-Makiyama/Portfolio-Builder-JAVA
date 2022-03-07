import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.Scanner; 

class ProfileBuilder implements Profile, Serializable {    
    String fName;
    String mName;
    String lName;
    String dob;
    String occupation;
    String gender;
    String preferred_pronoun;

    public String toString() {
        return this.fName + " " + this.mName + " " + this.lName + "'s gender is " + this.gender + ", " + this.preferred_pronoun + " date of birth is " + this.dob + ", and " + this.preferred_pronoun + " occupation is: " + this.occupation + ".";
    }

    public String get_(String value) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your " + value); 
        String input = scanner.nextLine();
        if (value == "preferred pronoun") {
            scanner.close();
        }
        return input;
    };

    public void warning() { System.out.println("DISCLAIMER & WARNING: Before you enter any information, you should know that this application is for EDUCATIONAL PURPOSES ONLY. DO NOT USE IT FOR MALICIOUS PURPOSES. Feel free to test it out with fake names, dates, occupations, etc.!"); }
    public void get_fName() { this.fName = get_("first name"); }
    public void get_mName() { this.mName = get_("middle name"); }
    public void get_lName() { this.lName = get_("last name"); }
    public void get_dob() { this.dob = get_("date of birth (MM/DD/YYYY)"); }
    public void get_occupation() { this.occupation = get_("occupation"); }
    public void get_gender() { this.gender = get_("gender (male/female/other)"); }
    public void get_preferred_pronoun() { this.preferred_pronoun = get_("preferred pronoun (her/his/their)"); }
    public void ask_question(Object o) { 
        Scanner scanner = new Scanner(System.in);  
        System.out.println("Would you like to have this information exported to a document? (Y/N)"); 
        String input = scanner.nextLine();
        if (input.equals("Y")) {
            try {
                FileOutputStream serialize = new FileOutputStream("./ExportedSerProfile.ser");
                ObjectOutputStream serializeobj = new ObjectOutputStream(serialize);
                serializeobj.writeObject(o);
                serializeobj.close();
                serialize.close();
                System.out.println("On Windows, your exported ser file should be in your C:\\User\\(yourUsernamehere), folder. Goodbye!");
            } catch (IOException i) {
                System.out.println(i);
            }
        } else {
            System.out.println("You have chosen to not export your created profile to a .ser file.");
        }
        scanner.close();
    }
}
