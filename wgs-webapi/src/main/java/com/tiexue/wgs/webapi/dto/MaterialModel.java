package com.tiexue.wgs.webapi.dto;

import java.util.List;

public class MaterialModel {

    private List<MaterialCont> mainMaterial;	 
    private List<MaterialCont> assistMaterial;
	public List<MaterialCont> getMainMaterial() {
		return mainMaterial;
	}
	public void setMainMaterial(List<MaterialCont> mainMaterial) {
		this.mainMaterial = mainMaterial;
	}
	public List<MaterialCont> getAssistMaterial() {
		return assistMaterial;
	}
	public void setAssistMaterial(List<MaterialCont> assistMaterial) {
		this.assistMaterial = assistMaterial;
	}
    

}
