public class FinancialForecaster {

    public double forecastConstant(double currentValue, double growthRate, int periodsAhead) {

        // nothing left to predict, just return whatever value we reached
        if (periodsAhead == 0) {
            return currentValue;
        }

        // docs were kinda vague, so i just used the usual compound growth formula
        double updatedValue = currentValue * (1 + growthRate);

        // keep going till all periods are covered
        return forecastConstant(updatedValue, growthRate, periodsAhead - 1);
    }

    public double forecastVariable(double currentValue, double[] growthRates) {
        return forecastVariable(currentValue, growthRates, 0);
    }

    private double forecastVariable(double currentValue, double[] growthRates, int position) {

        // gone through all the yearly/monthly rates
        if (position >= growthRates.length) {
            return currentValue;
        }

        // apply the current growth rate and move to the next one
        double updatedValue = currentValue * (1 + growthRates[position]);

        return forecastVariable(updatedValue, growthRates, position + 1);
    }

    public static void main(String[] args) {

        FinancialForecaster forecaster = new FinancialForecaster();

        double initialAmount = 100000;
        double fixedRate = 0.05;
        int years = 3;

        double constantForecast = forecaster.forecastConstant(initialAmount, fixedRate, years);
        System.out.println("Constant 5% growth for 3 years on 100000: " + constantForecast);

        double[] yearlyRates = {0.04, 0.06, 0.05};

        double variableForecast = forecaster.forecastVariable(initialAmount, yearlyRates);
        System.out.println("Forecast using rates [4%, 6%, 5%]: " + variableForecast);
    }
}