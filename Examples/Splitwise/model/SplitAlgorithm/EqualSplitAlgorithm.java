package Examples.Splitwise.model.SplitAlgorithm;

import Examples.Splitwise.model.Balance.Balance;
import Examples.Splitwise.model.Balance.Paid;
import Examples.Splitwise.model.Expense.Expense;
import Examples.Splitwise.model.Split;
import Examples.Splitwise.model.SplitType;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

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
    public List<Split> getValidSplits() {
        BigDecimal amount = Balance.addAll(expense.getParticipants());
        List<Paid> participants = expense.getParticipants();
        int size = participants.size();
        List<Split> splits = new ArrayList<>();
        for(int i=0;i<size;i++) splits.add(new Split(expense,participants.get(i).getUser(),amount,getSplitType()));
        return splits;
    }
}
