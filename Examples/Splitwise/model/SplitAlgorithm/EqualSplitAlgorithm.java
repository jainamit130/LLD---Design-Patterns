package Examples.Splitwise.model.SplitAlgorithm;

import Examples.Splitwise.model.Balance.Paid;
import Examples.Splitwise.model.Split;
import Examples.Splitwise.model.SplitType;
import Examples.Splitwise.model.User;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Map;

public class EqualSplitAlgorithm extends SplitAlgorithm {

    public EqualSplitAlgorithm() {
        super();
    }

    @Override
    public boolean validate() {
        return true;
    }

    @Override
    public SplitType getSplitType() {
        return SplitType.EQUAL;
    }

    @Override
    public Split getValidSplit(User user) {
        return new Split(expense,user,expense.getAmount().divide(
                new BigDecimal(expense.getParticipants().size()),
                2,
                RoundingMode.HALF_UP
        ),getSplitType());
    }
}
