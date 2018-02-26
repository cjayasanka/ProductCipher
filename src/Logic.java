public class Logic {

    public static void main(String[] args) {
        char[] text = "This is a dummy text".toCharArray();
        char[] encrypted = new char[text.length];
        char[] decrypted = new char[text.length];

        char[] one = makeArrayOne("close");
        char[] two = makeArrayTwo("close");

        for (int i =0; i < text.length; i++){
            encrypted[i] = two[new String(one).indexOf(text[i])];
        }
        System.out.println(new String(encrypted));

        for (int i =0; i < text.length; i++){
            decrypted[i] = one[new String(two).indexOf(encrypted[i])];
        }
        System.out.println(new String(decrypted));

    }

    static char[] makeArrayOne(String password){

        String arrOne = "";
        String alphabet = " !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~";

        for(int i =0; i < password.length(); i++){
            if(!arrOne.contains(password.substring(i,i+1))){
                arrOne = arrOne + password.substring(i,i+1);
            }
        }

        for(int i =0; i < alphabet.length(); i++){
            if(!arrOne.contains(alphabet.substring(i,i+1))){
                arrOne = arrOne + alphabet.substring(i,i+1);
            }
        }

        return arrOne.toCharArray();
    }

    static char[] makeArrayTwo(String password){

        int val = 0;
        char[] alpha = " !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~".toCharArray();
        char[] alphabet = new char[95];

        for(int i =0; i < password.length(); i++){
            val = val + (int)password.substring(i,i+1).toCharArray()[0];
        }

        for(int i =0; i < alpha.length; i++){
            alphabet[i] = alpha[(val+i)%95];
        }

        return alphabet;
    }
}
