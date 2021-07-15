import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.text.DecimalFormat;

public class Shop {
	String []product = new String[4];
	String []unit = new String[4];
	Double []cost = new Double[4];
	Scanner sc = new Scanner(System.in);
	DecimalFormat df = new DecimalFormat();
	
	HashMap<String,Integer> basket = new LinkedHashMap<>();
	
	public void display() {
		System.out.println("------------------------------");
		System.out.println("Product Unit Cost");
		
		for(int i=0; i<cost.length; i++) {
			System.out.println(product[i]+"\t"+unit[i]+"\t"+cost[i]);
		}	
	}
	public void purchase() {
		System.out.println("Press 0 if you did not want");
		
		System.out.print("\n how many Soup: ");
		basket.put("Soup",sc.nextInt());
		System.out.print("how many Bread: ");
		basket.put("Bread",sc.nextInt());
		System.out.print("how many Milk: ");
		basket.put("Milk",sc.nextInt());
		System.out.print("how many Apples: ");
		basket.put("Apples",sc.nextInt());
	}
	
	public void outPut() {
		int i=0;
		
		double total=0;
		int n=0;
		System.out.println("Product  Qty   ");
		for(Map.Entry<String, Integer> obj: basket.entrySet()) {
			if(i==0 && obj.getValue()>1) {
			     n = obj.getValue()/2;
				double price= obj.getValue() * cost[i++];
				total = total+price;
			}else if(i==1){
				if(n!=0 && (n==obj.getValue() || n>obj.getValue())) {
					double price= (obj.getValue() * cost[i++])/2;
					total = total+price;	
				}else if(n!=0 && n<obj.getValue()) {
					double price=  ((obj.getValue()-n) * cost[i]) + ((n *cost[i])/2);
					total = total+price;
					i++;
				}
			}else if(i==3) {
				
				double price= ((obj.getValue() * cost[i++]));
				total = total+(price- (price*10)/100);
			}
			else {
				double price= obj.getValue() * cost[i++];
				total = total+price;
			}
			
			System.out.println(obj.getKey()+" \t"+obj.getValue() );
		}
		df.setMaximumFractionDigits(2);
		System.out.println(df.format(total));
	}
	
	
	public static void main(String arg[]) {
		
		Shop sh = new Shop();
		
		System.out.println("Enter Product Name: ");		
		for(int i=0; i<sh.product.length; i++) {
			sh.product[i]=sh.sc.nextLine();
		}
		System.out.println("Enter Unit of Product: ");
		for(int i=0; i<sh.unit.length; i++) {
			sh.unit[i]=sh.sc.nextLine();
		}
		System.out.println("Enter Cost: ");
		for(int i=0; i<sh.cost.length; i++) {
			sh.cost[i]=sh.sc.nextDouble();
		}
		sh.display();
        System.out.println("\n \n Press 1 for shoaping : ");
        int n =sh.sc.nextInt();
       outer:
    	   while(n==1) {
    		   sh.purchase();
               sh.outPut();
    		   System.out.println("\n \n Press 1 for shoaping :  \n press 2 for exit: "); 
    		   n= sh.sc.nextInt();
    		   if(n==1)
    			   continue outer;
    		   else 
    			   System.exit(0);
    	   }
		
	}

}
