package com.example;

import java.util.Date;








public class Performance {
 
	static String agent_resource=ProvTrack.bbox_ns+"CarManufacturerServer";
	
	public static ResponseEntity calculatePerformanceData(InsuranceData data){
	ProvTrack track=new ProvTrack(data.getNamespace());
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
		track.addStatement(act+" "+ProvTrack.type+ProvTrack.Activity);
		track.addStatement(act+" "+ProvTrack.used+entity);
		
		
		track.addStatement(perfEntity+" "+ProvTrack.type +ProvTrack.Performance);
		track.addStatement(perfEntity+" "+ProvTrack.type +ProvTrack.PersonalData);
		track.addStatement(perfEntity+" "+ProvTrack.type +ProvTrack.Entity);
		track.addStatement(perfEntity+" "+ProvTrack.description+"\\\"Engine performance data\\\"^^xsd:string");

		track.addStatement(usage+" "+ProvTrack.entity +entity);
		
		track.addStatement(usage+" "+ProvTrack.type+ProvTrack.Usage);
		track.addStatement(usage+" "+ProvTrack.purpose+"\\\"Using accelerometer data to calculate how the engine performs\\\"^^xsd:string");
		track.addStatement(act+" "+ProvTrack.qualifiedUsage+ usage);
		track.addStatement(perfEntity+" "+ProvTrack.wasGeneratedBy+act);
		
		// ADD GENERATION MAYBE 
		
		track.addStatement(act+" "+ProvTrack.wasAssociatedWith + agent_resource);
	
		en.setProvdata(perfEntity);
		
		track.sendProv();
		return en;
		
		
		
		
		
	}
}
