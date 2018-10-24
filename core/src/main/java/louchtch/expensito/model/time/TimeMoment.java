package louchtch.expensito.model.time;

public interface TimeMoment extends Comparable<TimeMoment>
{
	public Long asSecondsFromEpoch();
}
