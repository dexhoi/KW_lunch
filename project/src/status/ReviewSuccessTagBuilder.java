package status;

public class ReviewSuccessTagBuilder extends StatusTagBuilder {

	public ReviewSuccessTagBuilder(LunchStatus status) {
		super(status);
	}

	@Override
	public String build() {
		return "<div class='alert alert-success'>レビューを追加しました</div>";
	}

}
