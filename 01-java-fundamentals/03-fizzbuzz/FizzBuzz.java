public class FizzBuzz {
    public String fizzBuzz(int number, String fizz, String buzz, String both, int fizzNum, int buzzNum) {
        if(number == 0) {
            return "0";
        }
        else if(number % fizzNum == 0 && number % buzzNum == 0) {
            return fizz + buzz;
        }
        else if(number % fizzNum == 0) {
            return fizz;
        }
        else if(number % buzzNum == 0) {
            return buzz;
        }
        else {
            return Integer.toString(number);
        }
        
    }

    public String fizzBuzz(int number, String fizz, String buzz, String both) {
        return fizzBuzz(number,fizz,buzz,both,3,5);
    }

    public String fizzBuzz(int number) {
        return fizzBuzz(number, "Fizz", "Buzz", "FizzBuzz");
    }

}
