package status;

public abstract class StatusTagBuilder {

	protected LunchStatus status;

	public StatusTagBuilder(LunchStatus status) {
		this.status = status;
	}

	public LunchStatus getStatus() {
		return status;
	}

	public abstract String build();
}
