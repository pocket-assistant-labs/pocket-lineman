package calc.constr.linecalc;



public class LineMath {

    public double meterToFeet(double input){
        double result = input * 3.2808399;
        return result;
    }

    public double feetToMeters(double input){
        double result = input * 0.3048;
        return result;
    }

    public double milliToInches(double input) {
        double result = input * 0.03937;
        return result;
    }

    public double inchesToMilli(double input) {
        double result = input * 25.4;
        return result;
    }

    public double poleHole(double input) {
        double result = (input * .1) + 2;
        return result;
    }

    public double dcAmpsCalc(double volts, double ohms){
        double result = volts/ohms;
        return result;
    }

    public double dcVoltsCalc(double amps, double ohms){
        double result = amps * ohms;
        return result;
    }

    public double dcOhmsCalc(double amps, double volts){
        double result = volts/amps;
        return result;
    }

}
