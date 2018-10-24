package louchtch.expensito.model.time;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;

public class ZonedTimeMoment implements TimeMoment
{
	private ZonedDateTime zonedDateTime;

	private ZonedTimeMoment(ZonedDateTime zonedDateTime)
	{
		this.zonedDateTime = zonedDateTime;
	}

	@Override
	public int compareTo(TimeMoment other)
	{
		Long otherMilis = other.asUnixMilisUtc();
		Long thisMilis = this.asUnixMilisUtc();

		return thisMilis.compareTo(otherMilis);
	}

	@Override
	public Long asUnixMilisUtc()
	{
		return zonedDateTime.withZoneSameInstant(ZoneOffset.UTC).toEpochSecond();
	}
}
