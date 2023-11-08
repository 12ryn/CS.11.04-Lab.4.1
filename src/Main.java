public class Main {

    // 1. parenthesesCheck

    public static boolean parenthesesCheck(String str){

        return str.charAt(0) == '(' && str.endsWith(")");

    }

    // 2. reverseInteger

    public static String reverseInteger(int a){

        String str = String.valueOf(a);
        String result = "";

        // e.g. length 10 therefore last index = 9 or str.length()-1

        for(int i = 0; i < str.length(); i++){

            int adjust = str.length()-1 - i;
            result = result + str.charAt(adjust);

        }

        return result;

    }

    // 3. encryptThis

    public static String encryptThis(String str){

        String[] words =  str.split(" ");
        StringBuilder build = new StringBuilder();

        for(String word : words) {

            StringBuilder encrypt = new StringBuilder();

            if (!word.isEmpty()) {

                encrypt.append((int) word.charAt(0));

                if (word.length() > 1) {

                    encrypt.append(word.charAt(word.length() - 1));
                }

                if (word.length() > 2) {

                    encrypt.append(word, 2, word.length() - 1);
                    encrypt.append(word.charAt(1));
                }
            }

            build.append(encrypt).append(" ");
        }

        return build.substring(0, build.length()-1);

    }

    // 4. decipherThis
    public static String decipherThis(String str){

        String[] sect = str.split(" ");
        StringBuilder result = new StringBuilder();

        for (String word: sect) {

            StringBuilder decrypt = new StringBuilder();

            if (word.isEmpty() == false) {

                int firstChar = Integer.parseInt(word.replaceAll("[^0-9]", "")); // ^ = not
                decrypt.append((char) firstChar); // cast char's numeric value back to the char itself
                String remain = word.replaceAll("[0-9]", ""); // delete all numeric values

                if (remain.length() > 1) {

                    decrypt.append(remain.charAt(remain.length() - 1)); // LAST CHAR REPOSITIONED TO 2ND CHAR
                    decrypt.append(remain, 1, remain.length() - 1); // APPENDS EVERYTHING BETWEEN 2ND CHAR & FINAL CHAR
                    decrypt.append(remain.charAt(0)); //appends second char (0 as first char already appended) as last char

                }

                else {

                    decrypt.append(remain); // FOR 2 CHAR WORDS
                }
            }

            result.append(decrypt).append(" ");
        }

        if (result.substring(result.length() - 1).equals(" ")){ // space will be added at the end of each loop

            result = new StringBuilder(result.substring(0, result.length() - 1));

        }

        return result.toString();
    }

}
