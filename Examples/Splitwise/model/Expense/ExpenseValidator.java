package Examples.Splitwise.model.Expense;

import Examples.Splitwise.model.Balance.Balance;
import Examples.Splitwise.model.Expense.ExpenseRequestDTO.ExpenseDTO;
import Examples.Splitwise.model.Balance.Paid;
import Examples.Splitwise.model.SplitAlgorithm.SplitAlgorithm;

import java.math.BigDecimal;
import java.util.List;

public class ExpenseValidator {

    public static boolean validate(ExpenseDTO expenseDTO) {
        if (expenseDTO == null) return false;
        return expenseDTO.validate() && validateExpense(expenseDTO);
    }

    private static boolean validateExpense(ExpenseDTO expenseDTO) {
        return validatePayers(expenseDTO.getParticipants(), expenseDTO.getAmount())
                && validateAmountPaid(expenseDTO)
                && validateSplitAlgorithm(expenseDTO.getSplitAlgorithm());
    }

    private static boolean validateSplitAlgorithm(SplitAlgorithm splitAlgorithm) {
        return splitAlgorithm.validate();
    }

    private static boolean validatePayers(List<Paid> payers, BigDecimal amount) {
        if (payers == null || amount == null) return false;
        boolean unique = Balance.areAllUnique(payers);
        BigDecimal sum = Balance.addAll(payers);
        return unique && sum.compareTo(amount) == 0;
    }

    private static boolean validateAmountPaid(ExpenseDTO expenseDTO) {
        return expenseDTO.getAmount() != null && expenseDTO.getAmount().compareTo(BigDecimal.ZERO) > 0;
    }
}

