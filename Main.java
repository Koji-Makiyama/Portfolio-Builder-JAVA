public class Main {      
    public static void main(String[] args) {
        ProfileBuilder profileid1 = new ProfileBuilder();

        profileid1.warning();

        profileid1.get_fName();
        profileid1.get_mName();
        profileid1.get_lName();
        profileid1.get_dob();
        profileid1.get_occupation();
        profileid1.get_gender();
        profileid1.get_preferred_pronoun(); 

        System.out.println("Below is your compiled profile:");
        System.out.println(profileid1);

        profileid1.ask_question(profileid1);

    }

}
