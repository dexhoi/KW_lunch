package status;

public class InputErrorTagBuilder extends StatusTagBuilder {

	public InputErrorTagBuilder(LunchStatus status) {
		super(status);
	}

	@Override
	public LunchStatus getStatus() {
		return status;
	}

	@Override
	public String build() {
		return "<div class='alert alert-danger'>入力された値が正しくありません</div>";
	}

}
