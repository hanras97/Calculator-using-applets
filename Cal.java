/*
	Advance Calculator

    --> This program perform all the basic operation that can be performed on a calculator.
    --> The operations include addition,subtraction,division,multiplication,modulo and power.
    --> Program supports both float and integer variables.
    --> Program is designed using applets and UI.

    github-@hanras97
*/
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
 
public class Cal extends Applet implements ActionListener   
{
	String msg=" ";
	double inp1,inp2,result;                                 
	TextField tf,to;
	Font f1;                                      
	Button b[]=new Button[10];                           
	Button add,sub,mul,div,clear,mod,EQ,dec,pow;        
	char OP;
	public void init()                                   
	{
        f1 = new Font("Monospaced",Font.BOLD,17);               //defining new font
        setFont(f1);											//setting new font
        Frame title = (Frame)this.getParent().getParent();
    	title.setTitle("Advance Calculator");                   //title   
		tf=new TextField(10);                        			//setting new textfield for numbers
		to=new TextField(10);                        			//setting new textfield for operator
		GridLayout gl=new GridLayout(7,3);           			//setting grid of n*m
		setLayout(gl);                               

		//Creating buttons

		for(int i=0;i<10;i++)
		{
			b[i]=new Button(""+i);               
		}
                dec=new Button(".");                         
		add=new Button("+");                         
		sub=new Button("-");                         
		mul=new Button("x");                         
		div=new Button("/");                         
		mod=new Button("mod");                       
        pow=new Button("^");                         
		clear=new Button("CLEAR");                   
		EQ=new Button("=");                          
                 
    	//Adding buttons to the output layout                                  
	
		add(tf);
		add(to);                                          
		add(clear);
		for(int i=0;i<10;i++)
		{
			add(b[i]);                           
		}
        add(dec);                                    
		add(add);                                    
		add(sub);                                    
		add(mul);                                        
		add(div);                                        
		add(mod);                                    
        add(pow);                                    
		add(EQ);                                     
		
                
        for(int i=0;i<10;i++)
		{
			b[i].addActionListener(this);
		}
        dec.addActionListener(this);
		add.addActionListener(this);
		sub.addActionListener(this);
		mul.addActionListener(this);
		div.addActionListener(this);
		mod.addActionListener(this);
        pow.addActionListener(this);
		clear.addActionListener(this);
		EQ.addActionListener(this);
	}
 
      
	public void actionPerformed(ActionEvent ae)
	{
		String str=ae.getActionCommand();            
		char ch=str.charAt(0);
		if ( Character.isDigit(ch)|| ch=='.')        
		tf.setText(tf.getText()+str);                
		else
		if(str.equals("+"))                          //Checks if the entered character is "+"
		{
			inp1=Double.parseDouble(tf.getText());   //Converts the entered String in Textview to Integer 
			OP='+';
			to.setText("+");
			tf.setText("");
			                     
		}
		else if(str.equals("-"))                     //Checks if the entered character is "-"
		{
			inp1=Double.parseDouble(tf.getText());   //Converts the entered String in Textview to Integer 
			OP='-';
			to.setText("-");
			tf.setText("");                      
		}
		else if(str.equals("x"))                     //Checks if the entered character is "x"
		{
			inp1=Double.parseDouble(tf.getText());   //Converts the entered String in Textview to Integer 
			OP='*';
			to.setText("*");
			tf.setText("");                      		}
		else if(str.equals("/"))                     //Checks if the entered character is "/"
		{
			inp1=Double.parseDouble(tf.getText());   //Converts the entered String in Textview to Integer 
			OP='/';
			to.setText("/");
			tf.setText("");                      
		}
		else if(str.equals("mod"))                     //Checks if the entered character is "%"
		{
			inp1=Double.parseDouble(tf.getText());     //Converts the entered String in Textview to Integer   
			OP='%';
			to.setText("%");                     
			tf.setText("");                      
		}
                else if(str.equals("^"))                     //Checks if the entered character is "^"
		{
			inp1=Double.parseDouble(tf.getText());          //Converts the entered String in Textview to Integer   
			OP='^';
			to.setText("^");                     
			tf.setText("");                      
		}
		if(str.equals("="))                          //Checks if the entered character is "="
		{
			inp2=Double.parseDouble(tf.getText());    //Converts the entered String in Textview to Integer and store it in another variable inp2 
			if(OP=='+')                               //Checks for operator
				result=inp1+inp2;
			else if(OP=='-')
				result=inp1-inp2;
			else if(OP=='*')
				result=inp1*inp2;
			else if(OP=='/')
				result=inp1/inp2;
			else if(OP=='%')
				result=inp1%inp2;
                        else if(OP=='^')
				result=Math.pow(inp1,inp2);     //Use of power function
			to.setText("");
			tf.setText(""+result);              //Dispalys the result in textview
		}	
		if(str.equals("CLEAR"))                 //Checks if the entered character is "CLEAR"
		{
			tf.setText("");                     //It clears the textfield
		}
	}

}