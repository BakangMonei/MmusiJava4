package files;


public class Grossing {
    protected double hoursWorked, rateOfPay, salary = 0, carAllowance = 0, monthlyGratuity, taxRate;

    public Grossing(double hoursWorked, double rateOfPay, double monthlyGratuity, double taxRate) {
        this.hoursWorked = hoursWorked;
        this.rateOfPay = rateOfPay;
        this.monthlyGratuity = monthlyGratuity;
        this.taxRate = taxRate;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(double hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public double getRateOfPay() {
        return rateOfPay;
    }

    public void setRateOfPay(double rateOfPay) {
        this.rateOfPay = rateOfPay;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getCarAllowance() {
        return carAllowance;
    }

    public void setCarAllowance(double carAllowance) {
        this.carAllowance = carAllowance;
    }

    public double getMonthlyGratuity() {
        return monthlyGratuity;
    }

    public void setMonthlyGratuity(double monthlyGratuity) {
        this.monthlyGratuity = monthlyGratuity;
    }

    public double getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(double taxRate) {
        this.taxRate = taxRate;
    }

    public double calculateGrossSalary() {
        double grossSalary = this.carAllowance + this.salary + this.monthlyGratuity;
        return grossSalary;
    }

    @Override
    public String toString() {
        return "Grossing{" + "hoursWorked=" + hoursWorked + ", rateOfPay=" + rateOfPay + ", salary=" + salary + ", carAllowance=" + carAllowance + ", monthlyGratuity=" + monthlyGratuity + ", taxRate=" + taxRate + '}';
    }


}
