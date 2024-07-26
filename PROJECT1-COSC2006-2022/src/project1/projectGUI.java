package project1;
/**
 * Import required statements 
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * This class is the GUI for the project 1/ Movie
 * Ranking System. With this GUI we can add movies
 * remove movies, get the capacity, ensure the capacity, 
 * get random recommendations, get the size and trim to size. 
 * @author Sahara Karima Mosin Rahimani
 *
 */
public class projectGUI extends JFrame implements ActionListener{
	/**
	 * Declaring all required variables, elements of the GUI and the ArraySequence
	 * 
	 */
		private JTextArea output;
		private JLabel AddBeforeLabel, TitleLabel1, GenreLabel1, IMDBLabel1, RTLabel1;
		private JLabel AddAfterLabel, TitleLabel2, GenreLabel2, IMDBLabel2, RTLabel2;
		private JLabel EnsureCapacityLabel, MinCapacityLabel, RandomRecLabel, RemoveLabel;
		private JLabel CapacityLabel, SizeLabel, TrimLabel;
		private JTextField TitleInput1, GenreInput1, IMDBInput1, RTInput1;
		private JTextField TitleInput2, GenreInput2, IMDBInput2, RTInput2;
		private JTextField CapacityInput;
		private JPanel inPanel, outPanel, mainPanel, inPanel2;
		private JButton AddBeforeButton, AddAfterButton, EnsureCapacityButton;
		private JButton RandomRecButton, RemoveButton, CapacityButton, SizeButton, TrimButton;
		private ArraySequence mySeq = new ArraySequence(); 
		private int IMDB1, IMDB2, Capacity, RT1, RT2;
		
		public projectGUI() {
			
		

			/*
			 * Initializing panels and setting their layout
			 */
			inPanel = new JPanel();
			inPanel.setLayout(new GridLayout(20,1));
			inPanel2 = new JPanel();
			inPanel2.setLayout(new GridLayout(20,1));
			outPanel = new JPanel();
			outPanel.setLayout(new FlowLayout());
			
			mainPanel = new JPanel();
			mainPanel.setLayout(new FlowLayout());
			
		
			/*
			 * Initializing labels
			 */
			AddBeforeLabel = new JLabel("Add Before:");
			TitleLabel1= new JLabel("Name:"); 
			GenreLabel1= new JLabel("Genre:");
			IMDBLabel1= new JLabel("IMDB:");
			RTLabel1 = new JLabel("Rotten Tomatoes:");
			AddAfterLabel = new JLabel("Add After:");
			TitleLabel2= new JLabel("Name:"); 
			GenreLabel2= new JLabel("Genre:");
			IMDBLabel2= new JLabel("IMDB:");
			RTLabel2 = new JLabel("Rotten Tomatoes:");
			EnsureCapacityLabel= new JLabel("Ensure Capacity:"); 
			MinCapacityLabel= new JLabel("Minimum Capacity:");
			RandomRecLabel= new JLabel("Random Recommendation:");
			RemoveLabel = new JLabel("Remove:");
			CapacityLabel= new JLabel("Capacity:"); 
			SizeLabel= new JLabel("Size:");
			TrimLabel= new JLabel("Trim to Size:");
			
			/*
			 * Initializing the text area for output and 
			 * Initializing all buttons
			 */
			output=new JTextArea(30,40);
		
			AddBeforeButton =new JButton("Add Before!");
			AddBeforeButton.addActionListener(this);
			
			AddAfterButton =new JButton("Add After!");
			AddAfterButton.addActionListener(this);
			
			EnsureCapacityButton=new JButton("Ensure Capacity!");
			EnsureCapacityButton.addActionListener(this);
			
			RandomRecButton =new JButton("Random Rec!");
			RandomRecButton.addActionListener(this);
			
			RemoveButton =new JButton("Remove!");
			RemoveButton.addActionListener(this);

			CapacityButton =new JButton("Capacity!");
			CapacityButton.addActionListener(this);
			
			SizeButton =new JButton("Size!");
			SizeButton.addActionListener(this);
			
			TrimButton =new JButton("Trim!");;
			TrimButton.addActionListener(this);
			
		
			/*
			 * Initializing all Text Fields
			 */
			CapacityInput = new JTextField(15);
			CapacityInput.addActionListener(this);
			TitleInput1 = new JTextField(15);
			TitleInput1.addActionListener(this);
			GenreInput1 = new JTextField(15);
			GenreInput1.addActionListener(this);
			IMDBInput1 = new JTextField(15);
			IMDBInput1.addActionListener(this);
			RTInput1 = new JTextField(15);
			RTInput1.addActionListener(this);
			TitleInput2 = new JTextField(15);
			TitleInput2.addActionListener(this);
			GenreInput2 = new JTextField(15);
			GenreInput2.addActionListener(this);
			IMDBInput2= new JTextField(15);
			IMDBInput2.addActionListener(this);
			RTInput2= new JTextField(15);
			RTInput2.addActionListener(this);
		
			/*
			 * Adding all elements to panels
			 */
			inPanel.add(AddBeforeLabel);
			inPanel.add(TitleLabel1);
			inPanel.add(TitleInput1);
			inPanel.add(GenreLabel1);
			inPanel.add(GenreInput1);
			inPanel.add(IMDBLabel1);
			inPanel.add(IMDBInput1);
			inPanel.add(RTLabel1);
			inPanel.add(RTInput1);
			inPanel.add(AddBeforeButton);
			inPanel.add(AddAfterLabel);
			inPanel.add(TitleLabel2);
			inPanel.add(TitleInput2);
			inPanel.add(GenreLabel2);
			inPanel.add(GenreInput2);
			inPanel.add(IMDBLabel2);
			inPanel.add(IMDBInput2);
			inPanel.add(RTLabel2);
			inPanel.add(RTInput2);
			inPanel.add(AddAfterButton);
			inPanel2.add(EnsureCapacityLabel);
			inPanel2.add(MinCapacityLabel);
			inPanel2.add(CapacityInput);
			inPanel2.add(EnsureCapacityButton);
			inPanel2.add(RandomRecLabel);
			inPanel2.add(RandomRecButton);
			inPanel2.add(RemoveLabel);
			inPanel2.add(RemoveButton);
			inPanel2.add(CapacityLabel);
			inPanel2.add(CapacityButton);
			inPanel2.add(SizeLabel);
			inPanel2.add(SizeButton);
			inPanel2.add(TrimLabel);
			inPanel2.add(TrimButton);
			
			outPanel.add(new JScrollPane(output));
			mainPanel.add(inPanel);
			mainPanel.add(inPanel2);
			mainPanel.add(outPanel);
			this.add(mainPanel);
		
		}
	 

 /**
  * This is the event handler for all the buttons 
  */
		public void actionPerformed(ActionEvent actEvent) {
	
			try {
			 
		
			 if(actEvent.getSource()==AddBeforeButton) {
				 /**
				  * Get the input entered by the user and 
				  * Add the movie before the current element
				  * Show output
				  */
				 String  NameStr1= TitleInput1.getText();
				 String  GenreStr1= GenreInput1.getText();
				 String IMDBStr1=IMDBInput1.getText();
				 IMDB1=Integer.parseInt(IMDBStr1);	
				 String RTStr1=RTInput1.getText();
				 RT1=Integer.parseInt(RTStr1);	
				 movie first=new movie(NameStr1, GenreStr1, IMDB1, RT1);
				 
				 mySeq.addBefore(first);
				 
				 String out="\n Sequence is composed of:\n"+mySeq.toString()+"\n";
				 output.append(out);
				 
			 }else if(actEvent.getSource()== AddAfterButton) {
				/**
				 * Get the input entered by the user and
				 * Add the movie after the current element
				 * Show output
				 */
				 String  NameStr2= TitleInput2.getText();
				 String  GenreStr2= GenreInput2.getText();
				 String IMDBStr2=IMDBInput2.getText();
				 IMDB2=Integer.parseInt(IMDBStr2);	
				 String RTStr2=RTInput2.getText();
				 RT2=Integer.parseInt(RTStr2);	
				 movie second=new movie(NameStr2, GenreStr2, IMDB2, RT2);
				 mySeq.addBefore(second);
				 
				 String out="\n"+"Sequence is composed of:\n"+mySeq.toString()+"\n";
				 output.append(out);
				
				 
			 }else if(actEvent.getSource()==RandomRecButton) {
				/**
				 * Get the current element of the sequence and 
				 * show the output
				 */
				
				 String out="\n Random Recommendation: "+ mySeq.getCurrent()+"\n";
				 output.append(out);
				 
			 }else if(actEvent.getSource()==RemoveButton) {
				 /**
				  * I add what will be removed from the sequence to the string out
				  * then I will remove the current element from the sequence and lastly append the 
				  * string and the entire sequence to the text area.
				  */
				
				 String out="\n"+"Removing: "+mySeq.getCurrent()+"\n";
				 mySeq.removeCurrent();
				 output.append(out+mySeq.toString());
				 
			 }else if(actEvent.getSource()== CapacityButton) {
				 /**
				  * Add the capacity to the string out and then append it to 
				  * the text area.
				  */
				 String out="\n"+"Capacity: "+ mySeq.getCapacity()+"\n";
				 output.append(out);
				 
			 }else if(actEvent.getSource()==EnsureCapacityButton) {
				 /**
				  * Get the capacity entered by the user, make it an integer
				  * then use the ensureCapacity method and add the new capacity to
				  * out and append out to the text area.
				  */
				String minCapStr=CapacityInput.getText();
				Capacity=Integer.parseInt(minCapStr);
				mySeq.ensureCapacity(Capacity);
				
				String out="\n"+"Capacity is now: "+ mySeq.getCapacity()+"\n";
				 output.append(out);
				 
			 }else if(actEvent.getSource()==SizeButton) {
				 /**
				  * Add the size to the string out and then append it to 
				  * the text area.
				  */
				String out="\n"+"Size: "+ mySeq.size()+"\n";
				 output.append(out);
				 
			 }else if(actEvent.getSource()==TrimButton) {
				 /**
				  * First I will add the previous capacity and size of the sequence to out
				  * then I will append out and the new capacity to the text area
				  */
				 String out="\n"+"Previous Capacity: "+ mySeq.getCapacity()+"\n"+"Size: "+mySeq.size()+"\n";
				 mySeq.trimToSize();
				 output.append(out+"New Capacity: "+mySeq.getCapacity()+"\n");
				 
			 }
			 
		
			 
		}catch(Exception e) {
			//Error message that will appear if there's an exception
			JOptionPane.showMessageDialog(null, "Invalid Function!");
		}	 
				 
	}
			 
			 
				

	 public static void main(String[] args) {

		 	//Create the gui object
			projectGUI gui = new projectGUI();
			
			//Make the GUI visible
			gui.setVisible(true); 
			gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
			//Set size and title
			gui.setSize(1000,600);  
			gui.setTitle("Movie Ranking System GUI"); 
			//Do not allow the GUI to be resized
			gui.setResizable(false);
		}

	}



