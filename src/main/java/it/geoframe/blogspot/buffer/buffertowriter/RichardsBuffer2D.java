/*
 * GNU GPL v3 License
 *
 * Copyright 2016 Marialaura Bancheri
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
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import oms3.annotations.*;

@Description("Buffer for 1D Richards simulation.")
@Documentation("")
@Author(name = "Niccolo' Tubini, Riccardo Rigon", contact = "tubini.niccolo@gmail.com")
@Keywords("Hydrology, Richards, Infiltration")
//@Label(JGTConstants.HYDROGEOMORPHOLOGY)
//@Name("shortradbal")
//@Status(Status.CERTIFIED)
@License("General Public License Version 3 (GPLv3)")

public class RichardsBuffer2D {

	@Description("Variable to store")
	@In 
	@Unit ("-")
	public ArrayList<ArrayList<Double>> inputVariable;

	@Description("Date at which the varible is computed")
	@In 
	@Unit ("YYYY-MM-DD HH:mm")
	public String inputDate;

	@Description("Dual spatial coordinate: is the position of edges ")
	@In 
	@Unit ("m")
	public Map<Integer, Double[]> inputDualSpatialCoordinate;

	@Description("Boolean value controlling the buffer component")
	@In 
	@Unit ("-")
	public boolean doProcessBuffer;

	@In 
	public int writeFrequency = 1;

	@Description()
	@Out
	@Unit ()
	public LinkedHashMap<String,ArrayList<ArrayList<Double>>> variable = new LinkedHashMap<String,ArrayList<ArrayList<Double>>>(); // consider the opportunity to save varibale as float instead of double


	@Description("")
	int step=0;

	private ArrayList<ArrayList<Double>> tempVariable;



	@Execute
	public void solve() {

		if(step==0){

			tempVariable = new ArrayList<ArrayList<Double>>();

		}

		if( ((step-1)%writeFrequency) == 0 || step == 1) {

			variable.clear();

		}


		if(doProcessBuffer== true) {

			// water suction values
			tempVariable.add(new ArrayList<Double>(inputVariable.get(0)));

			// water content
			tempVariable.add(new ArrayList<Double>(inputVariable.get(1)));

			// water volume
			tempVariable.add(new ArrayList<Double>(inputVariable.get(2)));

			// saturation degree
			tempVariable.add(new ArrayList<Double>(inputVariable.get(3)));

			// Darcy velocities
			tempVariable.add(new ArrayList<Double>(inputVariable.get(4)));

			// Darcy velocities x
			tempVariable.add(new ArrayList<Double>(inputVariable.get(5)));
			
			// Darcy velocities z
			tempVariable.add(new ArrayList<Double>(inputVariable.get(6)));

			// error volume
			tempVariable.add(new ArrayList<Double>(inputVariable.get(7)));

//			Iterator it;
//			//			variable.put(inputDate, new ArrayList<ArrayList<Double>>(tempVariable.clone()));
//			it = variable.entrySet().iterator();
//			while (it.hasNext()) {
//				Entry<String, ArrayList<ArrayList<Double>>> entry = (Entry<String, ArrayList<ArrayList<Double>>>) it.next();
//			
//				System.out.println(entry.getKey() + " psi[1] "+entry.getValue().get(0).get(1)+ " theta[1] "+entry.getValue().get(1).get(1));
//			}	
			
			
			variable.put(inputDate, new ArrayList<ArrayList<Double>>(tempVariable));
//
//			System.out.println("Buffer "+inputDate);
//			System.out.println("psi[1] "+variable.get(inputDate).get(0).get(1));//+" "+variable.get(inputDate).get(0).get(1000)+" "+variable.get(inputDate).get(0).get(2000)+" "+variable.get(inputDate).get(0).get(4000)+" "+variable.get(inputDate).get(0).get(5000));
//
//			System.out.println("theta[1] "+variable.get(inputDate).get(1).get(1));//+" "+variable.get(inputDate).get(1).get(1000)+" "+variable.get(inputDate).get(1).get(2000)+" "+variable.get(inputDate).get(1).get(4000)+" "+variable.get(inputDate).get(1).get(5000));

			tempVariable.clear();
		}

		step++;

	}


}
