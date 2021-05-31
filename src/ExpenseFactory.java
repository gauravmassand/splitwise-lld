public class ExpenseFactory {

    public Expense getInstance(String expenseType) {
        switch (expenseType) {
            case "EQUAL" :
                return new EqualExpense();
            case "EXACT" :
                return new ExactExpense();
            case "PERCENT" :
                return new PercentExpense();
        }
        return null;
    }
}
