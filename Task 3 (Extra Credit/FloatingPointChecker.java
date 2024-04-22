import java.util.Scanner;

public class FloatingPointChecker {
    public static void main(String[] args) {
            try (Scanner scanner = new Scanner(System.in)) {
                System.out.print("Enter an integer literal: ");
                String input = scanner.nextLine().trim();
    
                if (isPointFloat(input)) {
                    System.out.println("Valid point float literal.");
                } else if (isExponentFloat(input)) {
                    System.out.println("Valid exponent float literal.");
                } else {
                    System.out.println("Not a valid floating point literal.");
                }
            }
        }
    
        //DONE
        private static boolean isPointFloat(String input) {
            boolean decimalFlag = false;
            boolean underscoreFlag = false;

            for(char e : input.toCharArray()) {
                if((e < '0' || e > '9') && e!='.') {
                    return false;
                } else if(e == '_' && underscoreFlag) {
                    return false;
                }
                underscoreFlag = false;
                if(e == '_') {
                    underscoreFlag = true;
                }
                if(e == '.' && decimalFlag) {
                    return false;
                } else if (e == '.') {
                    decimalFlag = true;
                }
                if(input.length() <2 && decimalFlag) {
                    return false;
                }
            }
            return true;
        }
       
        private static boolean isExponentFloat(String input) {
            boolean expFlag = false;
            boolean signFlag = false;
            boolean decimalFlag = false;
            boolean underscoreFlag = false;

            for(char e : input.toCharArray()) {
                if((e < '0' || e > '9') && e!='.' && e!='e' && e!='E' && e!='+' && e!='-' && e!='_') {
                    return false;
                } else if(e == '_' && underscoreFlag) {
                    return false;
                } else if((e == 'e' || e == 'E') && expFlag) {
                    return false;
                } else if((e == '-' || e == '+') && signFlag) {
                    return false;
                }

                underscoreFlag = false;
                if(e == '_') {
                    underscoreFlag = true;
                }
                if(e == '.' && decimalFlag) {
                    return false;
                } else if (e == '.') {
                    decimalFlag = true;
                }
                if(input.length() <2 && decimalFlag) {
                    return false;
                }
                if(e == 'e' || e == 'E') {
                    expFlag = true;
                } else if(e == '+' || e == '-') {
                    signFlag = true;
                }
               
            }
            
            return true;
            
        }
    }