package status;

public class LogInFailTagBuilder extends StatusTagBuilder {

	public LogInFailTagBuilder(LunchStatus status) {
		super(status);
	}

	@Override
	public String build() {
		return "<div class='alert alert-danger'>ログインに失敗しました</div>";
	}



}
