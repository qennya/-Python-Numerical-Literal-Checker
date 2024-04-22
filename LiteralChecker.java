import java.util.Scanner;

public class LiteralChecker {
    public static void main(String[] args) {
            try (Scanner scanner = new Scanner(System.in)) {
                System.out.print("Enter an integer literal: ");
                String input = scanner.nextLine().trim();
    
                if (isValidDecimal(input)) {
                    System.out.println("Valid decimal integer literal.");
                } else if (isValidOctal(input)) {
                    System.out.println("Valid octal integer literal.");
                } else if (isValidHexadecimal(input)) {
                    System.out.println("Valid hexadecimal integer literal.");
                } else {
                    System.out.println("Not a valid integer literal.");
                }
            }
        }
    
        //NOT DONE
        private static boolean isValidDecimal(String input) {
            if (input.length() == 0) return false; //if empty
            if (input.charAt(0) == '0' && input.length() > 1) return false; 
            for (char e : input.toCharArray()) {
                if (e < '0' || e > '9'){
                    return false;
                }
            }
            return true;
        }
       
        //DONE
        private static boolean isValidOctal(String input) {
            if (input == null || input.length() < 2) {  //if empty or less than 2 -> false
                return false;
            }
        
            if (!(input.charAt(0) == '0' && (input.charAt(1) == 'o' || input.charAt(1) == 'O'))) { // if no 0o or 0O -> false
                return false;
            }
        
          
            char lastChar = input.charAt(input.length() - 1); //checks last charecter
            if (lastChar < '0' || lastChar > '7') {    // if last charecter is no within 0-7 -> false
                return false;
            }
        
            boolean underscoreSeen = false; //flag in case of underscore appearence
        
            for (int i = 2; i < input.length() - 1; i++) { // after 0o or 0O, loops char
                char e = input.charAt(i);
        
                
                if (e == '_') {// If an underscore appears

                    if (underscoreSeen) {
                        return false; // Prevents 2 underscores in a row 
                    }
                    underscoreSeen = true;
                } else if (e < '0' || e > '7') { //ends with 0-7 after underscore
                    return false; 
                } else {
                    underscoreSeen = false; // Reset the underscore flag
                }
            }
        
            return true;
        }
    
            //NOT DONE
        private static boolean isValidHexadecimal(String input) {
            if (input.length() < 3 || input.charAt(0) != '0' || (input.charAt(1) != 'x' && input.charAt(1) != 'X')) return false;
            for (char e : input.substring(2).toCharArray()) {
                if (!((e >= '0' && e <= '9') || (e >= 'a' && e <= 'f') || (e >= 'A' && e <= 'F'))) return false;
            }
            return true;
        }
    }