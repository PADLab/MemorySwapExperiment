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
	
	// return available memory
	public static long availableMem() {
		return Runtime.getRuntime().freeMemory();
	}
	
	// return total memory
	public static long totalMem() {
		return Runtime.getRuntime().totalMemory();
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
	
	public static void appendToFile(File file, String str) 
    { 
        try { 
  
            // Open given file in append mode. 
            BufferedWriter out = new BufferedWriter( 
                   new FileWriter(file, true)); 
            out.write(str); 
            out.close(); 
        } 
        catch (IOException e) { 
            System.out.println("exception occoured" + e); 
        } 
    } 
	
	public static void main(String[] args) {
		int loopCount = 1;
		long delta = 0;
		long usedMem=0;
		double cpuLoad = 0;
		Random rand = new Random();
		
		System.out.println("Initial total memory: " + totalMem());
		System.out.println("Initial available memory: " + availableMem());
		
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
			br.close();
			fr.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		while(loopCount <= 1000000000){
			// Add 100 random integers to the list
			for(int i = 0; i<100; i++){
				int rand_num = rand.nextInt(1000);
				list.add(rand_num);
			}
			
			before = Instant.now();
			
			// Get 100 values by index from list
			for(int j = 0; j<100;j++){
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
			
			appendToFile(file, delta+", "+loopCount+", "+list.size() + ", "+ usedMem+", "+cpuLoad+"\n");
		}
	}


}
