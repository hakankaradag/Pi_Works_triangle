package pi;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

	
public  class Pi_Works_triangle {
		 
		 
			List<List> nodeList = new ArrayList<List>();
		 
			public static void main(String[] args) {
				Pi_Works_triangle ad = new Pi_Works_triangle();
				Scanner s = new Scanner(System.in);
				System.out.println("Enter file path:");
				String filePath = s.nextLine();
				ad.readFile(filePath);
				s.close();
				int index = 0;
				int num1 = 0, num2 = 0, sum = 0;
				boolean first = true;
				for (List a : ad.nodeList) {
					if (first) {
						num1 = (Integer) a.get(index);
						sum = num1;
						System.out.print(num1);
						first = false;
					} else {
						num1 = (Integer) a.get(index);
						num2 = (Integer) a.get(index + 1);
						if (num1 > num2 && notprime(num1)) {
							sum += num1;
							System.out.print("+" + num1);
						}else if(notprime(num2)) {
							sum += num2;
							index++;
							System.out.print("+" + num2);
						}
					}
		 
				}
				System.out.println("\nThe sum total is = " + sum);
			}
		 
			public void readFile(String path) {
				BufferedReader bis = null;
				try {
					bis = new BufferedReader(new FileReader(path));
					String tmp = bis.readLine();
					while (tmp != null) {
						String[] nums = tmp.split("\\s+");
						List<Integer> a = new ArrayList<Integer>();
						for (int i = 0; i < nums.length; i++) {
							a.add(Integer.parseInt(nums[i]));
						}
						nodeList.add(a);
						tmp = bis.readLine();
					}
		 
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					try {
						bis.close();
					} catch (Exception e) {
						e.printStackTrace();
		 
					}
				}
		 
			}
		 
		
	
		static boolean notprime(int num){
			
			int  i;
			boolean bool = false;
			
			

			for(i=2;i<num && bool==false;i++) {
				if(num%i == 0) {
					bool = true;
				}
				
			}
			if(bool == true) {
				return true;
			}else {
				return false;
			}
		}
		
	} 
 


