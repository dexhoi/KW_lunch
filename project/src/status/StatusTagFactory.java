package status;

import java.util.ArrayList;
import java.util.List;

public class StatusTagFactory {

	private static StatusTagFactory factory = new StatusTagFactory();

	private static List<StatusTagBuilder> tags;

	private StatusTagFactory() {
		tags = new ArrayList<StatusTagBuilder>();

		tags.add(new InputErrorTagBuilder(LunchStatus.input_error));
		tags.add(new AddSuccessTagBuilder(LunchStatus.add_success));
		tags.add(new LogInFailTagBuilder(LunchStatus.login_fail));
	}

	public static StatusTagFactory getInstance() {
		return factory;
	}

	public String build(LunchStatus status) {
		for(var tag : tags) {
			if(tag.getStatus() == status) {
				return tag.build();
			}
		}

		return "";
	}

}
