/*
 * GNU GPL v3 License
 *
 * Copyright 2020 Niccolo` Tubini
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package it.geoframe.blogspot.buffer.bufferparameter;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

import com.opencsv.CSVReader;  

import oms3.annotations.*;

@Description("Prepare parameter vector for calibration reading csv file of parameter from pydream.")
@Documentation("")
@Author(name = "Concetta D'Amato, Niccolo' Tubini, Riccardo Rigon", contact = "concettadamato94@gmail.com")
@Keywords("Hydrology, Richards, WHETGEO-1D")
//@Label(JGTConstants.HYDROGEOMORPHOLOGY)
//@Name("shortradbal")
//@Status(Status.CERTIFIED)
@License("General Public License Version 3 (GPLv3)")



public class ReaderCSV{
	
	
	@Description(" ")
	@Out 
	@Unit ("-")
	public static double[] params;
	
	@Description(" ")
	@Out 
	@Unit ("-")
	public double[] thetaS;
	
	@Description(" ")
	@Out 
	@Unit ("-")
	public double[] thetaR;
	
	@Description(" ")
	@Out 
	@Unit ("-")
	public double[] par1SWRC;
	
	@Description(" ")
	@Out 
	@Unit ("-")
	public double[] par2SWRC;
	
	@Description(" ")
	@Out 
	@Unit ("-")
	public double[] par3SWRC;
	
	@Description(" ")
	@Out 
	@Unit ("-")
	public double[] par4SWRC;
	
	@Description(" ")
	@Out 
	@Unit ("-")
	public double[] par5SWRC;
	
	@Description(" ")
	@Out 
	@Unit ("-")
	public double[] ks;
	
	@Description(" ")
	@Out 
	@Unit ("-")
	public double[] alphaSpecificStorage;
		
	@Description(" ")
	@Out 
	@Unit ("-")
	public double[] betaSpecificStorage;
	
	
	
	
	@Execute
	
	public static void main(String[] args){
		
		String path = "/Users/concettadamato/Desktop/data_2.csv";
		String line = "";
		
		List<List<String>> lines = new ArrayList<>();
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));

				//while((line=br.readLine())!= null) { 
			line=br.readLine();
			String[] values=line.split(",");
				
			params = new double[values.length];
					
			for(int i = 0; i<=values.length-1; i++) {	
				params[i]=Double.parseDouble(values[i]);
					
				lines.add(Arrays.asList(values));
	
				System.out.println(params[i]);
			//}
			}
			
			
//ORA BISOGNA AGGIUNGERE LA SCRITTURA DEI PARAMETRI NELLE VARIABILI CHE DEVONO ESSERE PASSATE A RICHARDS
			// Aggiungere il nome delle variabili
		
		
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		
	} 
}  


