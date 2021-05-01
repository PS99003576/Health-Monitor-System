package com.ltts;

import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.slf4j.Logger;

@Service
public class Sensor1 {

	private static final Logger log = LoggerFactory.getLogger(Sensor1.class);

	private final RabbitTemplate rabbitTemplate;

	public Sensor1(final RabbitTemplate rabbitTemplate ) {
		this.rabbitTemplate = rabbitTemplate;
		
	}

	@Scheduled(fixedDelay = 3000)
	public void generateBPRandom() {
		int minimumBloodPressure = 90;
		int maximumBloodPressure = 140;
		Random random = new Random();
		Integer patientId = 1;
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();

		Sensor1model data = new Sensor1model
				       (patientId,
				        random.nextInt(maximumBloodPressure - minimumBloodPressure) + minimumBloodPressure,
						null,
						null,formatter.format(date));
		
		rabbitTemplate.convertAndSend(Sensor1Application.EXCHANGE_NAME, Sensor1Application.Blood_Pressure,
				data);
		
		log.info("BloodPressure has Sent Successfully :)");

	}

	@Scheduled(fixedDelay = 5000)
	public void generateHeartRateRandom() {

		int minimumHeartRate = 40;
		int maximumHeartRate = 100;
		Random random = new Random();
		Integer patientId = 1;
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		
		Sensor1model data = new Sensor1model(patientId, random.nextInt(maximumHeartRate - minimumHeartRate) + minimumHeartRate, null, null,
				formatter.format(date));
		rabbitTemplate.convertAndSend(Sensor1Application.EXCHANGE_NAME, Sensor1Application.Heart_rate, data);
		log.info("HeartRate Sent Successfully");
	}

	@Scheduled(fixedDelay = 8000)
	public void generateOLRandom() {

		int minimumOxygenLevel = 60;
		int maximumOxygenLevel = 100;
		Random random = new Random();
		Integer patientId = 1;
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		Sensor1model data = new Sensor1model(patientId, null, random.nextInt(maximumOxygenLevel - minimumOxygenLevel) + minimumOxygenLevel,null,
				 formatter.format(date));
		rabbitTemplate.convertAndSend(Sensor1Application.EXCHANGE_NAME, Sensor1Application.Blood_oxygen_level,
				data);
		log.info("OxygenLevel has Sent Successfully :)");

	}

}
