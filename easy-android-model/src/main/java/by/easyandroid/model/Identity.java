package by.easyandroid.model;

import org.springframework.data.annotation.Id;

public class Identity {

	@Id
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Identity && id != null) {
			return id.equals(((Identity) obj).getId());
		}
		
		return false;
	}
}