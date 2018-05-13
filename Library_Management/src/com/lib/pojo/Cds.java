package com.lib.pojo;

import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="cd")
@Entity
public class Cds {
	private int cdId;
	private int invId;
	private String cdName;
	private float cdCost;
	private int cdCount;

	public int getCdId() {
		return cdId;
	}

	public void setCdId(int cdId) {
		this.cdId = cdId;
	}

	public int getInvId() {
		return invId;
	}

	public void setInvId(int invId) {
		this.invId = invId;
	}

	public String getCdName() {
		return cdName;
	}

	public void setCdName(String cdName) {
		this.cdName = cdName;
	}

	public float getCdCost() {
		return cdCost;
	}

	public void setCdCost(float cdCost) {
		this.cdCost = cdCost;
	}

	public int getCdCount() {
		return cdCount;
	}

	public void setCdCount(int cdCount) {
		this.cdCount = cdCount;
	}

}
