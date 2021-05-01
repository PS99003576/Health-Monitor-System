package com.ltts;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Sensor1model {

	private Integer patientId = 1;
	private Integer bloodPressure;
	private final Integer oxygenLevel;
	private final Integer heartRate;
	private String timeStamp;
	
	
	
	
	public Sensor1model(@JsonProperty("patientId") final Integer patientId,
			@JsonProperty("bloodPressure") final Integer bloodPressure, 
			@JsonProperty("oxygenLevel") final Integer oxygenLevel, 
			@JsonProperty("heartRate") final Integer heartRate,
			@JsonProperty("timeStamp") final String timeStamp) {
		super();
		this.patientId = patientId;
		this.bloodPressure = bloodPressure;
		this.oxygenLevel = oxygenLevel;
		this.heartRate = heartRate;
		this.timeStamp = timeStamp;
	}
	
	@Override
	public String toString() {
		return "Sensor1model [patientId=" + patientId + ", bloodPressure=" + bloodPressure + ", oxygenLevel="
				+ oxygenLevel + ", heartRate=" + heartRate + ", timeStamp=" + timeStamp + "]";
	}
	
	
	
	
}
