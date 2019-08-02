package beans;

import java.io.Serializable;

public class UserInfoBeans implements Serializable {

		private String name;
		private int loginId;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getLoginId() {
			return loginId;
		}
		public void setLoginId(int loginId) {
			this.loginId = loginId;
		}
		
}