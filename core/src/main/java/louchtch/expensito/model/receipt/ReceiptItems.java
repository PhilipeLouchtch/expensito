package louchtch.expensito.model.receipt;

import louchtch.money.Numeraire;

import java.util.Set;

public interface ReceiptItems<TReceiptItem extends ReceiptItem>
{
	Numeraire sumTotal();

	ReceiptItems<TReceiptItem> add(TReceiptItem item);
	Set<TReceiptItem> asSet();
}
