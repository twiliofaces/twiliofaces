import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import javax.inject.Named;

import org.twiliofaces.annotations.notification.AccountSid;

@Named
@SessionScoped
public class FlowerHandler implements Serializable {

	public FlowerHandler() {
		// TODO Auto-generated constructor stub
	}

	@Inject
	@AccountSid
	Instance<String> accoInstanceRequest;

	@Inject
	@AccountSid
	String accountSid;

	public void useAccopuntSid() {
		System.out.println(accountSid);
		System.out.println(accoInstanceRequest.get());
	}

}
