package status;

public class AddSuccessTagBuilder extends StatusTagBuilder {

	public AddSuccessTagBuilder(LunchStatus status) {
		super(status);
	}

	@Override
	public String build() {
		return "<div class='alert alert-success'>追加に成功しました</div>";
	}

}
