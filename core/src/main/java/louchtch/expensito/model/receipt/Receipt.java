package louchtch.expensito.model.receipt;

import louchtch.expensito.model.Expense;

public interface Receipt<TItem extends ReceiptItem> extends Expense
{
	ReceiptItems<TItem> items();
}
