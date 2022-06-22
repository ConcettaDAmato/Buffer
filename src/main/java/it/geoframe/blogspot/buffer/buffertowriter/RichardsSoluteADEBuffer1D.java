/*
 * GNU GPL v3 License
 *
 * Copyright 2016 Niccolo` Tubini
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

package it.geoframe.blogspot.buffer.buffertowriter;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import oms3.annotations.*;

@Description("Buffer for 1D Richards simulation.")
@Documentation("")
@Author(name = "Concetta D'Amato, Niccolo' Tubini, Riccardo Rigon", contact = "tubini.niccolo@gmail.com")
@Keywords("Hydrology, Richards, Infiltration")
//@Label(JGTConstants.HYDROGEOMORPHOLOGY)
//@Name("shortradbal")
//@Status(Status.CERTIFIED)
@License("General Public License Version 3 (GPLv3)")

public class RichardsSoluteADEBuffer1D {
	
	@Description("Variable to store")
	@In 
	@Unit ("-")
	public ArrayList<double[]> inputVariable;
	
	@Description("Date at which the varible is computed")
	@In 
	@Unit ("YYYY-MM-DD HH:mm")
	public String inputDate;
	
	@Description("Boolean value controlling the buffer component")
	@In 
	@Unit ("-")
	public boolean doProcessBuffer;
	
	@In 
	public int writeFrequency = 1;
	
	@Description()
	@Out
	@Unit ()
	public LinkedHashMap<String,ArrayList<double[]>> myVariable = new LinkedHashMap<String,ArrayList<double[]>>(); // consider the opportunity to save varibale as float instead of double
	
	
	@Description("")
	private int step=0;
	
	private ArrayList<double[]> tempVariable;
	
	
	
	@Execute
	public void solve() {

		if(step==0){
			
			tempVariable = new ArrayList<double[]>();
		
		}
		
		if( ((step-1)%writeFrequency) == 0 || step == 1) {
//			System.out.println("Buffer1D clear");

			myVariable.clear();

		}
		
		if(doProcessBuffer== true) {
			// water suction values
			tempVariable.add(inputVariable.get(0).clone());

			// thetas
			tempVariable.add(inputVariable.get(1).clone());
			
			// water volume
			tempVariable.add(inputVariable.get(2).clone());

			// Darcy velocities
			tempVariable.add(inputVariable.get(3).clone());

			// Concentrations
			tempVariable.add(inputVariable.get(4).clone());

			// WaterVolumeConcentrationsNew
			tempVariable.add(inputVariable.get(5).clone());

			// Dispersion solute flux
			tempVariable.add(inputVariable.get(6).clone());

			// Advection solute fux
			tempVariable.add(inputVariable.get(7).clone());
			
			// error in WaterVolumeConcentration
			tempVariable.add(inputVariable.get(8).clone());

			// errorVolume
			tempVariable.add(inputVariable.get(9).clone());

			// Average solute concentrations
			tempVariable.add(inputVariable.get(10).clone());

			// Average WaterVolumeSoluteConcentration
			tempVariable.add(inputVariable.get(11).clone());

			myVariable.put(inputDate,(ArrayList<double[]>) tempVariable.clone());

			tempVariable.clear();
		}
		step++;
		
	}
	

}
