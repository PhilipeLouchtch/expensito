package louchtch.expensito.model.expense;

import louchtch.money.Numeraire;

import java.util.Set;

public interface ReceiptItems
{
	Numeraire sumTotal();

	ReceiptItems add(ReceiptItem item);
	Set<ReceiptItem> asSet();
}
