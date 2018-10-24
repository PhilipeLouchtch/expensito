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
		Long otherMilis = other.asSecondsFromEpoch();
		Long thisMilis = this.asSecondsFromEpoch();

		return thisMilis.compareTo(otherMilis);
	}

	@Override
	public Long asSecondsFromEpoch()
	{
		return zonedDateTime.withZoneSameInstant(ZoneOffset.UTC).toEpochSecond();
	}
}
