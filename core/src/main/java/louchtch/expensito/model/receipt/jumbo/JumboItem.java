package louchtch.expensito.model.receipt.jumbo;

import louchtch.expensito.model.receipt.ReceiptItem;
import louchtch.money.Numeraire;

public interface JumboItem extends ReceiptItem
{
	Numeraire discount();
}
