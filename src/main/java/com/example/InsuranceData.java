package com.example;

public class InsuranceData {

	String prov;
	int highTurns;
	String namespace;
	public String getNamespace(){
		return namespace;
	}
	public void setNamespace(String namespace){
		this.namespace=namespace;
	}
	public String getProv() {
		return prov;
	}
	public void setProv(String prov) {
		this.prov = prov;
	}
	public int getHighTurns() {
		return highTurns;
	}
	public void setHighTurns(int highTurns) {
		this.highTurns = highTurns;
	}
	public int getLowTurns() {
		return lowTurns;
	}
	public void setLowTurns(int lowTurns) {
		this.lowTurns = lowTurns;
	}
	int lowTurns;
}
