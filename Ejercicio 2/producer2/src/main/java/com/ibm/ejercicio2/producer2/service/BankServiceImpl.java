package com.ibm.ejercicio2.producer2.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ibm.ejercicio2.producer2.model.Bank;

@Service
public class BankServiceImpl implements IBankService {

	@Override
	public List<Bank> getAllServicesLocation() {
		try {
			String banamexJsonUrl = "https://www.banamex.com/localizador/jsonP/json5.json";
			URL url = new URL(banamexJsonUrl);
			BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));

			String inputLine = "";
			String inputText = "";
			while ((inputLine = br.readLine()) != null) {
				inputText = inputText + inputLine;
			}
			br.close();

			if (inputText.startsWith("jsonCallback({\"Servicios\":")) {
				inputText = inputText.substring(26, inputText.length());
				inputText = inputText.substring(0, inputText.length() - 3);
			}

			int jsonStartPosition = 0;
			int jsonEndPosition = 0;
			List<Bank> locations = new ArrayList<>();
			for (int i = 0; i < inputText.length(); i++) {
				if (inputText.charAt(i) == '[') {
					jsonStartPosition = i;
				}
				if (inputText.charAt(i) == ']') {
					jsonEndPosition = i;

					String singleJson = inputText.substring(jsonStartPosition, jsonEndPosition);
					String[] parts = singleJson.split("[,]");

					if (parts.length == 26) {
						Bank bank = Bank.builder().id(deleteCharsFromString(parts[0]))
								.serviceId(deleteCharsFromString(parts[1])).dos(deleteCharsFromString(parts[2]))
								.tres(deleteCharsFromString(parts[3]))
								.postalCode(deleteCharsFromString(parts[4] + "," + deleteCharsFromString(parts[5]))
										+ "," + deleteCharsFromString(parts[6]) + "," + deleteCharsFromString(parts[7]))
								.cinco(deleteCharsFromString(parts[8])).seis(deleteCharsFromString(parts[9]))
								.siete(deleteCharsFromString(parts[10])).ocho(deleteCharsFromString(parts[11]))
								.nueve(deleteCharsFromString(parts[12])).diez(deleteCharsFromString(parts[13]))
								.once(deleteCharsFromString(parts[14])).doce(deleteCharsFromString(parts[15]))
								.trece(deleteCharsFromString(parts[16])).catorce(deleteCharsFromString(parts[17]))
								.latitude(deleteCharsFromString(parts[18])).longitude(deleteCharsFromString(parts[19]))
								.State(deleteCharsFromString(parts[20])).dieciocho(deleteCharsFromString(parts[21]))
								.serviceName(deleteCharsFromString(parts[22])).build();
						locations.add(bank);
					} else if (parts.length == 27) {
						Bank bank = Bank.builder().id(deleteCharsFromString(parts[0]))
								.serviceId(deleteCharsFromString(parts[1])).dos(deleteCharsFromString(parts[2]))
								.tres(deleteCharsFromString(parts[3]))
								.postalCode(deleteCharsFromString(parts[4] + "," + deleteCharsFromString(parts[5]))
										+ "," + deleteCharsFromString(parts[6]) + "," + deleteCharsFromString(parts[7])
										+ "," + deleteCharsFromString(parts[8]))
								.cinco(deleteCharsFromString(parts[9])).seis(deleteCharsFromString(parts[10]))
								.siete(deleteCharsFromString(parts[11])).ocho(deleteCharsFromString(parts[12]))
								.nueve(deleteCharsFromString(parts[13])).diez(deleteCharsFromString(parts[14]))
								.once(deleteCharsFromString(parts[15])).doce(deleteCharsFromString(parts[16]))
								.trece(deleteCharsFromString(parts[17])).catorce(deleteCharsFromString(parts[18]))
								.latitude(deleteCharsFromString(parts[19])).longitude(deleteCharsFromString(parts[20]))
								.State(deleteCharsFromString(parts[21])).dieciocho(deleteCharsFromString(parts[22]))
								.serviceName(deleteCharsFromString(parts[23])).build();
						locations.add(bank);
					}

					jsonStartPosition = 0;
					jsonEndPosition = 0;
					singleJson = "";
					parts = null;

				}

			}
			return locations;
		} catch (Exception exception) {
			return null;
		}

	}

	private String deleteCharsFromString(String string) {
		string = string.replace("\"", "");
		string = string.replace("[", "");
		string = string.replace("]", "");
		string = string.replace(",", "");
		return string;
	}

	@Override
	public List<Bank> findNearestBanksAndBranches(double latGps, double lonGps, List<Bank> banksAndBranches) {

		List<Bank> nearestBanksAndBranches = new ArrayList<>();

		for (Bank bank : banksAndBranches) {

			double latGps2 = Double.parseDouble(bank.getLatitude());
			double lonGps2 = Double.parseDouble(bank.getLongitude());

			double distance = distance(latGps, latGps2, lonGps, lonGps2);

			if (distance <= 5) {
				nearestBanksAndBranches.add(bank);
			}
		}

		return nearestBanksAndBranches;

	}

	private double distance(double lat1, double lat2, double lon1, double lon2) {

		double theta = lon1 - lon2;
		double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2))
				+ Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
		dist = Math.acos(dist);
		dist = rad2deg(dist);
		dist = dist * 60 * 1.1515;

		dist = dist * 1.609344;

		return (dist);
	}

	private double deg2rad(double deg) {
		return (deg * Math.PI / 180.0);
	}

	private double rad2deg(double rad) {
		return (rad * 180.0 / Math.PI);
	}

}
