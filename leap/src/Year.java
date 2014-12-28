

public class Year {

    public Year( int year) {
        this.year = year;
    }

    private int year;

    private boolean isDivisibleBy(int divisor){
        return year % divisor == 0;
    }

    public boolean isLeapYear(){
        if (this.isDivisibleBy(400))
            return true;
        if (this.isDivisibleBy(100))
            return false;
        return this.isDivisibleBy(4);
    }
}
