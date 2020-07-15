package status;

/**
 * LunchStatusをもとにHtmlタグを出力
 *
 */
public abstract class StatusTagBuilder {

	protected LunchStatus status;

	/**
	 *
	 * @param status ステータス
	 */
	public StatusTagBuilder(LunchStatus status) {
		this.status = status;
	}

	public LunchStatus getStatus() {
		return status;
	}

	/**
	 * LunchStatusをもとにHtmlタグを生成する
	 * @return
	 */
	public abstract String build();
}
