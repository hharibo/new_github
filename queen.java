import java.util.*;
import java.awt.*;
import javax.swing.*;

class E_Q{
	int size;
	int c = 1;
	HashMap<Integer,int[]> HM;
	int[] pan;
	int pan2[];
	E_Q(int size,HashMap HM){
		this.size = size;
		this.HM = HM;
		pan = new int[size];
	}
	void d_o() {
		Back(0);
	}
	boolean is_passible(int s) {
		for (int i=0;i<s;i++) {
			if (pan[s] == pan[i] || s-i ==pan[s]-pan[i] || s-i == -(pan[s]-pan[i]))
				return false;
		}
		return true;
	}
	void Back(int s) { 
		if(s == size) {
			//int a[] = pan;
			
			HM.put(c,new int);
			c++;
			for(int i=0;i<size;i++){
                System.out.print(pan[i]);
            }
			System.out.println();
		}
		else {
			for(int i =1;i<=size;i++) {
				pan[s] = i;
				if (is_passible(s)==true) {
					Back(s+1);
				}
			}
		}
	}
}
public class queen extends JFrame {
	queen(int size,byte pan[][]){
		super("Test Frame");
		 getContentPane().setBackground(Color.BLACK);
	    getContentPane().setLayout(new GridLayout(size,size));
	    
	    JPanel[] jPanel = new JPanel[size*size];
		for(int i=0;i<size;i++) {
		    if (i%2==0)
		    {
		    	for(int j=0;j<size;j++)
		    	{
		    		if(j%2==0) {
		    			jPanel[i+j] = new JPanel();
		    			jPanel[i+j].setBackground(Color.black);
		    			 getContentPane().add(jPanel[i+j]);
		    		}else {
		    			jPanel[i+j] = new JPanel();
		    			jPanel[i+j].setBackground(Color.white);
		    			 getContentPane().add(jPanel[i+j]);
		    		}
		    			
		    	}
		    }
		    else {
		    	for(int j=0;j<size;j++)
		    	{
		    		if(j%2==0) {
		    			jPanel[i+j] = new JPanel();
		    			jPanel[i+j].setBackground(Color.white);
		    			 getContentPane().add(jPanel[i+j]);
		    		}else {
		    			jPanel[i+j] = new JPanel();
		    			jPanel[i+j].setBackground(Color.black);
		    			 getContentPane().add(jPanel[i+j]);
		    		}
		    			
		    	}
		    }
		}
	
		setSize(700,700); // 프레임 사이즈 설정
		setVisible(true);
	}
	public static void main(String args[]) {
		Scanner scanner =new Scanner(System.in);
		HashMap<Integer,int[]> HM = new HashMap<Integer,int[]>();

		int size;
		System.out.print("체스판의 크기를 입력하십시오 ");
		size = scanner.nextInt();
		
		E_Q e_q = new E_Q(size,HM);
		e_q.d_o();
		System.out.println(HM.get(1));
		
		//new queen(size,pan);
	}
}
