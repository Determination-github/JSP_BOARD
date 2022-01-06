package jsp.member.model.members;

import java.sql.Date;

public class MemberBean {
	private String memberID;
	private String memberPWD;
	private String memberName;
	private String memberEmail;
	private Date memberReg;
	
	public String getMemberID() {
		return memberID;
	}
	public void setMemberID(String memberID) {
		this.memberID = memberID;
	}
	public String getMemberPWD() {
		return memberPWD;
	}
	public void setMemberPWD(String memberPWD) {
		this.memberPWD = memberPWD;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getMemberEmail() {
		return memberEmail;
	}
	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}
	public Date getMemberReg() {
		return memberReg;
	}
	public void setMemberReg(Date memberReg) {
		this.memberReg = memberReg;
	}
	
	@Override
	public String toString() {
		return "MemberBean [memberID=" + memberID + ", memberPWD=" + memberPWD + ", memberName=" + memberName
				+ ", memberEmail=" + memberEmail + ", memberReg=" + memberReg + "]";
	}
	
	
	
}
