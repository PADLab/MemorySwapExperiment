import java.util.*;
import java.time.*;
import java.lang.management.ManagementFactory;
import com.sun.management.OperatingSystemMXBean;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class OStest {

	
	// return current memory used
	public static long currentUsedMem() {
		return Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
	}
	
	//return current % of memory used
	public static long percentUsedMem() {
		long total = Runtime.getRuntime().totalMemory();
		long free = Runtime.getRuntime().freeMemory();
		long used = total-free;
		
		return (used/total * 100);
	}
	
	//returns the current CPU load
	public static double getCPUload(){
		// HC given error on access restriction? Code continues to work fine
		// despite underlined errors
		OperatingSystemMXBean osBean = ManagementFactory.getPlatformMXBean(OperatingSystemMXBean.class);
		return(osBean.getProcessCpuLoad());
	}
	
	public static void main(String[] args) {
		int loopCount = 1;
		long delta = 0;
		long usedMem=0;
		double cpuLoad = 0;
		Random rand = new Random();
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		// Begin timer
		Instant before = Instant.now();
		
		File file = new File("output.txt");
		BufferedWriter br = null;
		FileWriter fr = null;
		
		try {
			fr = new FileWriter(file);
            br = new BufferedWriter(fr);
			br.write("Delta, loop, list size, mem used, cpu load\n");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		while(true){
			// Add 10 random integers to the list
			for(int i = 0; i<10; i++){
				int rand_num = rand.nextInt(1000);
				list.add(rand_num);
			}
			// Get 10 values by index from list
			for(int j = 0; j<10;j++){
				int rand_num2 = rand.nextInt(list.size()-1);
				Integer temp = list.get(rand_num2);
			}
			
			Instant after = Instant.now(); // check elapsed time
			delta = Duration.between(before, after).toMillis();
			
			loopCount++;
			usedMem = currentUsedMem();
			cpuLoad = getCPUload();
			// write data to .txt file in comma-separated format
			// Work out how to convert to csv!
			try {
				br.write(delta+", "+loopCount+", "+list.size() + ", "+ usedMem+", "+cpuLoad+"\n");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		/*
		// Infinite while loop means br never closed...solution?
		try {
            br.close();
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        */
		//System.out.println(list.get(1));
	}


}
