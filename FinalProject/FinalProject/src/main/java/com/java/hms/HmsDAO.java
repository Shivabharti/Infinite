package com.java.hms;

import java.util.List;

public interface HmsDAO {
	public List<Insurance_Claim> showInsuranceClaim();
	public String addClaimHistory(Insurance_Claim claim);
	public List<Claim_History> showClaimHistory();

}
