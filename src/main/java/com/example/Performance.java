package com.example;

import java.util.Date;








public class Performance {
 
	static String agent_resource=ProvTrack.bbox_ns+"CarManufacturerServer";
	
	public static ResponseEntity calculatePerformanceData(InsuranceData data){
		String act=ProvTrack.bbox_ns+"ActivityMan"+new Date().getTime();
		String entity=data.getProv();
		ResponseEntity en=new ResponseEntity();
		
		
		double random=Math.random();
		if(random<0.3){
			en.setPerformance(1);
		}
		else if(random>=0.3 && random<0.7){
			en.setPerformance(2);
		}
		else if(random>=0.7){
			en.setPerformance(3);
		}
		String perfEntity=ProvTrack.bbox_ns+"PerfEntityMan"+new Date().getTime();
		String usage=ProvTrack.bbox_ns+"CarUsage"+new Date().getTime();
		ProvTrack.addStatement(act+" "+ProvTrack.type+ProvTrack.Activity);
		ProvTrack.addStatement(act+" "+ProvTrack.used+entity);
		
		
		ProvTrack.addStatement(perfEntity+" "+ProvTrack.type +ProvTrack.Performance);
		ProvTrack.addStatement(perfEntity+" "+ProvTrack.type +ProvTrack.PersonalData);
		ProvTrack.addStatement(perfEntity+" "+ProvTrack.type +ProvTrack.Entity);
		ProvTrack.addStatement(perfEntity+" "+ProvTrack.description+"\\\"Engine performance data\\\"^^xsd:string");

		ProvTrack.addStatement(usage+" "+ProvTrack.entity +entity);
		
		ProvTrack.addStatement(usage+" "+ProvTrack.type+ProvTrack.Usage);
		ProvTrack.addStatement(usage+" "+ProvTrack.purpose+"\\\"Using accelerometer data to calculate how the engine performs\\\"^^xsd:string");
		ProvTrack.addStatement(act+" "+ProvTrack.qualifiedUsage+ usage);
		ProvTrack.addStatement(perfEntity+" "+ProvTrack.wasGeneratedBy+act);
		
		// ADD GENERATION MAYBE 
		
		ProvTrack.addStatement(act+" "+ProvTrack.wasAssociatedWith + agent_resource);
	
		en.setProvdata(perfEntity);
		
		ProvTrack.sendProv();
		return en;
		
		
		
		
		
	}
}
