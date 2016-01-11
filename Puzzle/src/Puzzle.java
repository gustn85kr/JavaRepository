import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public  class Puzzle extends JFrame implements ActionListener{
	
	private JButton btn[];
	public static void main(String[] args) {
		new Puzzle();

	}
	Puzzle(){
		setTitle("Puzzle");
		setSize(400, 300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		makeUI();
		setVisible(true);
		
	}
	private void makeUI() {
		RandomList rlist = new RandomList(16);
		int[] list = rlist.getList();
		btn = new JButton[16];
		setLayout(new GridLayout(4,4));
		for(int i=0;i<16;i++){
			int n = list[i] + 1;
			add(btn[i] = new JButton(String.valueOf(n)));
			btn[i].setEnabled(true);
			btn[i].addActionListener(this);
			if( n == 16){
				btn[i].setText("");
				btn[i].setEnabled(false);
			}
		}
		
	}
	private int[] nb = new int[4];
	private void findNeighber(int id){
		// up 
		nb[0] = id-4;
		//down
		nb[1] = id+4;
		if(nb[1]>=16){
			nb[1]= -1;
		}
		//left
		nb[2] = id-1;
		if(nb[2] < 0 || nb[2] %4 == 3){
			nb[2] = -1;
		}
		//right
		nb[3] = id+1;
		if(nb[3] %4 ==0 ){
			nb[3] = -1;
		}
	}
	private boolean isEnd(){
		
		int n=1;
		for(int i=0;i<15;i++){
			String s = btn[i].getText();
			if(s==""){
				return false;
			}
			int b = Integer.parseInt(s);
			if(n!=b){
				
				return false;
			}
			n++;
		}
		return true;
	}
	
	public void actionPerformed(ActionEvent e){
		JButton  b = (JButton)e.getSource();
		int id;
		for(id=0 ; id<16;id++){
			if( b == btn[id]){
				break;
			}
		}
		findNeighber(id);
		
		for( int i =0;i<4; i++){
			if(nb[i] >=0 && !btn[nb[i]].isEnabled()){
				JButton act,inact;
				act = btn[id];
				inact = btn[nb[i]];
				inact.setText(act.getText());
				act.setText("");
				inact.setEnabled(true);
				act.setEnabled(false);
				break;
			}
		}

		if(isEnd()){
			System.exit(0);
		}
		
		
	}
	

}
