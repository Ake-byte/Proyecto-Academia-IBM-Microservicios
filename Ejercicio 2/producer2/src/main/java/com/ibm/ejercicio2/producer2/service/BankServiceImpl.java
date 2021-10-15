package com.ibm.ejercicio2.producer2.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ibm.ejercicio2.producer2.model.Bank;

@Service
public class BankServiceImpl implements IBankService{

	@Override
	public List<Bank> getAllServicesLocation() {
		try{
            String banamexJsonUrl = "https://www.banamex.com/localizador/jsonP/json5.json";
            URL url = new URL(banamexJsonUrl);
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));

            String inputLine = "";
            String inputText = "";
            while ((inputLine = br.readLine()) != null) {
                inputText = inputText + inputLine;
            }
            br.close();
            
            if(inputText.startsWith("jsonCallback({\"Servicios\":")){
                inputText = inputText.substring(26, inputText.length());
                inputText = inputText.substring(0, inputText.length()-3);
            }
            
            int jsonStartPosition = 0;
            int jsonEndPosition = 0;
            List<Bank> locations = new ArrayList<>();
            for(int i = 0; i< inputText.length(); i++){
                if(inputText.charAt(i) == '['){	
                    jsonStartPosition = i;
                }
                if(inputText.charAt(i) == ']'){
                    jsonEndPosition = i;

                    String singleJson = inputText.substring(jsonStartPosition, jsonEndPosition);
                    String[] parts = singleJson.split("[,]");
                    
                    if(parts.length ==26) {
                    	Bank bank = Bank.builder()
                        		.id(deleteCharsFromString(parts[0]))
                            .serviceId(deleteCharsFromString(parts[1]))//100 o 400
                            .dos(deleteCharsFromString(parts[2]))
                            .tres(deleteCharsFromString(parts[3]))
                            .postalCode(deleteCharsFromString(parts[4] + ","
                              +deleteCharsFromString(parts[5])) + ","
                              +deleteCharsFromString(parts[6])+ ","
                              +deleteCharsFromString(parts[7]))//latitud
                            .cinco(deleteCharsFromString(parts[8]))//longitud
                            .seis(deleteCharsFromString(parts[9]))//Estado
                            .siete(deleteCharsFromString(parts[10]))
                            .ocho(deleteCharsFromString(parts[11]))//Sucursal/ATM
                            .nueve(deleteCharsFromString(parts[12]))
                            .diez(deleteCharsFromString(parts[13]))
                            .once(deleteCharsFromString(parts[14]))
                            .doce(deleteCharsFromString(parts[15]))
                            .trece(deleteCharsFromString(parts[16]))
                            .catorce(deleteCharsFromString(parts[17]))
                            .latitude(deleteCharsFromString(parts[18]))
                            .longitude(deleteCharsFromString(parts[19]))
                            .State(deleteCharsFromString(parts[20]))
                            .dieciocho(deleteCharsFromString(parts[21]))
                            .serviceName(deleteCharsFromString(parts[22]))
                            .build();
                    	locations.add(bank);
                    }
                    else if(parts.length == 27) {
                    	Bank bank = Bank.builder()
                        		.id(deleteCharsFromString(parts[0]))
                            .serviceId(deleteCharsFromString(parts[1]))//100 o 400
                            .dos(deleteCharsFromString(parts[2]))
                            .tres(deleteCharsFromString(parts[3]))
                            .postalCode(deleteCharsFromString(parts[4] + ","
                              +deleteCharsFromString(parts[5])) + ","
                              +deleteCharsFromString(parts[6])+ ","
                              +deleteCharsFromString(parts[7])+ ","
                              +deleteCharsFromString(parts[8]))//latitud
                            .cinco(deleteCharsFromString(parts[9]))//longitud
                            .seis(deleteCharsFromString(parts[10]))//Estado
                            .siete(deleteCharsFromString(parts[11]))
                            .ocho(deleteCharsFromString(parts[12]))//Sucursal/ATM
                            .nueve(deleteCharsFromString(parts[13]))
                            .diez(deleteCharsFromString(parts[14]))
                            .once(deleteCharsFromString(parts[15]))
                            .doce(deleteCharsFromString(parts[16]))
                            .trece(deleteCharsFromString(parts[17]))
                            .catorce(deleteCharsFromString(parts[18]))
                            .latitude(deleteCharsFromString(parts[19]))
                            .longitude(deleteCharsFromString(parts[20]))
                            .State(deleteCharsFromString(parts[21]))
                            .dieciocho(deleteCharsFromString(parts[22]))
                            .serviceName(deleteCharsFromString(parts[23]))
                            .build();
                    	locations.add(bank);
                    }

                    jsonStartPosition = 0;
                    jsonEndPosition = 0;
                    singleJson = "";
                    parts = null;
                    
                }
                
            }
            return locations;
        }catch(Exception exception){
        	return null;
        }

	}

	public String deleteCharsFromString(String string) {
		string = string.replace("\"", "");
		string = string.replace("[", "");
		string = string.replace("]", "");
		string = string.replace(",", "");
		return string;
	}

	@Override
	public List<Bank> findPostalCodeByState(String postalCode, List<Bank> banks) {
		//List<String> cdmxPC = Arrays.asList("01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16");
		List<Bank> banksAccordingPc = new ArrayList<>();
		//cdmxPC.contains(postalCode
		if(postalCode == "01" || postalCode == "01" || postalCode == "02" || postalCode == "03" || postalCode == "04" || postalCode == "05" || postalCode == "06" || postalCode == "07") {
			for(Bank b: banks) {
				if(b.getState().equals("Ciudad de México")) {
					banksAccordingPc.add(b);
				}
			}
		}else if(postalCode == "20") {
			for(Bank b: banks) {
				if(b.getState().equals("Aguascalientes")) {
					banksAccordingPc.add(b);
				}
			}
		}else if(postalCode == "21" || postalCode == "22") {
			for(Bank b: banks) {
				if(b.getState().equals("Baja California")) {
					banksAccordingPc.add(b);
				}
			}
		}else if(postalCode == "23") {
			for(Bank b: banks) {
				if(b.getState().equals("Baja California Sur")) {
					banksAccordingPc.add(b);
				}
			}
		}else if(postalCode == "24") {
			for(Bank b: banks) {
				if(b.getState().equals("Campeche")) {
					banksAccordingPc.add(b);
				}
			}
		}else if(postalCode == "29" || postalCode == "30") {
			for(Bank b: banks) {
				if(b.getState().equals("Chiapas")) {
					banksAccordingPc.add(b);
				}
			}
		}else if(postalCode == "31" || postalCode == "32" || postalCode == "33") {
			for(Bank b: banks) {
				if(b.getState().equals("Chihuahua")) {
					banksAccordingPc.add(b);
				}
			}
		}else if(postalCode == "25" || postalCode == "27") {
			for(Bank b: banks) {
				if(b.getState().equals("Coahuila")) {
					banksAccordingPc.add(b);
				}
			}
		}else if(postalCode == "28") {
			for(Bank b: banks) {
				if(b.getState().equals("Colima")) {
					banksAccordingPc.add(b);
				}
			}
		}else if(postalCode == "34" || postalCode == "35") {
			for(Bank b: banks) {
				if(b.getState().equals("Durango")) {
					banksAccordingPc.add(b);
				}
			}
		}else if(postalCode == "36" || postalCode == "37" || postalCode == "38") {
			for(Bank b: banks) {
				if(b.getState().equals("Guanajuato")) {
					banksAccordingPc.add(b);
				}
			}
		}
		else if(postalCode == "39" || postalCode == "40" || postalCode == "41") {
			for(Bank b: banks) {
				if(b.getState().equals("Guerrero")) {
					banksAccordingPc.add(b);
				}
			}
		}else if(postalCode == "42" || postalCode == "43") {
			for(Bank b: banks) {
				if(b.getState().equals("Hidalgo")) {
					banksAccordingPc.add(b);
				}
			}
		}else if(postalCode == "44" || postalCode == "45" || postalCode == "46" || postalCode == "47" || postalCode == "48" || postalCode == "49") {
			for(Bank b: banks) {
				if(b.getState().equals("Jalisco")) {
					banksAccordingPc.add(b);
				}
			}
		}else if(postalCode == "50" || postalCode == "51" || postalCode == "52" || postalCode == "53" || postalCode == "54" || postalCode == "55" || postalCode == "56" || postalCode == "57") {
			for(Bank b: banks) {
				if(b.getState().equals("México")) {
					banksAccordingPc.add(b);
				}
			}
		}else if(postalCode == "58" || postalCode == "59" || postalCode == "60" || postalCode == "61") {
			for(Bank b: banks) {
				if(b.getState().equals("Michoacán")) {
					banksAccordingPc.add(b);
				}
			}
		}else if(postalCode == "62") {
			for(Bank b: banks) {
				if(b.getState().equals("Morelos")) {
					banksAccordingPc.add(b);
				}
			}
		}else if(postalCode == "63") {
			for(Bank b: banks) {
				if(b.getState().equals("Nayarit")) {
					banksAccordingPc.add(b);
				}
			}
		}else if(postalCode == "64" || postalCode == "65" ||postalCode == "66" || postalCode == "67") {
			for(Bank b: banks) {
				if(b.getState().equals("Nuevo León")) {
					banksAccordingPc.add(b);
				}
			}
		}else if(postalCode == "68" || postalCode == "69" ||postalCode == "70" || postalCode == "71") {
			for(Bank b: banks) {
				if(b.getState().equals("Oaxaca")) {
					banksAccordingPc.add(b);
				}
			}
		}else if(postalCode == "72" || postalCode == "73" ||postalCode == "74" || postalCode == "75") {
			for(Bank b: banks) {
				if(b.getState().equals("Puebla")) {
					banksAccordingPc.add(b);
				}
			}
		}else if(postalCode == "76") {
			for(Bank b: banks) {
				if(b.getState().equals("Querétaro")) {
					banksAccordingPc.add(b);
				}
			}
		}else if(postalCode == "77") {
			for(Bank b: banks) {
				if(b.getState().equals("Quintana Roo")) {
					banksAccordingPc.add(b);
				}
			}
		}else if(postalCode == "78" || postalCode == "79") {
			for(Bank b: banks) {
				if(b.getState().equals("San Luis Potosí")) {
					banksAccordingPc.add(b);
				}
			}
		}else if(postalCode == "80" || postalCode == "81" || postalCode == "82") {
			for(Bank b: banks) {
				if(b.getState().equals("Sinaloa")) {
					banksAccordingPc.add(b);
				}
			}
		}else if(postalCode == "83" || postalCode == "84" || postalCode == "85") {
			for(Bank b: banks) {
				if(b.getState().equals("Sonora")) {
					banksAccordingPc.add(b);
				}
			}
		}else if(postalCode == "86") {
			for(Bank b: banks) {
				if(b.getState().equals("Tabasco")) {
					banksAccordingPc.add(b);
				}
			}
		}else if(postalCode == "87" || postalCode == "88" || postalCode == "89") {
			for(Bank b: banks) {
				if(b.getState().equals("Tamaulipas")) {
					banksAccordingPc.add(b);
				}
			}
		}else if(postalCode == "90") {
			for(Bank b: banks) {
				if(b.getState().equals("Tlaxcala")) {
					banksAccordingPc.add(b);
				}
			}
		}else if(postalCode == "91" || postalCode == "92" || postalCode == "93" || postalCode == "94" || postalCode == "95" || postalCode == "96") {
			for(Bank b: banks) {
				if(b.getState().equals("Veracruz")) {
					banksAccordingPc.add(b);
				}
			}
		}else if(postalCode == "97") {
			for(Bank b: banks) {
				if(b.getState().equals("Yucatán")) {
					banksAccordingPc.add(b);
				}
			}
		}else if(postalCode == "98" || postalCode == "99") {
			for(Bank b: banks) {
				if(b.getState().equals("Zacatecas")) {
					banksAccordingPc.add(b);
				}
			}
		}
		
		
		return banksAccordingPc;
	}
}
