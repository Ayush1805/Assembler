//Piyush Aggarwal and Ayush Yadav
//   2017356      and   2017335

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

class SymbolTable {
	private int no;
	private String symbol;
	private String type;
	private String value;
	private int address;
	public int totalnosymbol=0;
	
	SymbolTable(String _symbol,String _type,String _value,int _adrs){
		setNo(++totalnosymbol);
		symbol=_symbol;
		type=_type;
		setValue(_value);
		setAddress(_adrs);		
	}
	SymbolTable(String _symbol,String _type,int _adrs){
		setNo(++totalnosymbol);
		symbol=_symbol;
		type=_type;
		setAddress(_adrs);		
	}
	SymbolTable(String _symbol,String _type){
		setNo(++totalnosymbol);
		symbol=_symbol;
		type=_type;		
	}
	
	SymbolTable(String _symbol,String _type,String val){
		setNo(++totalnosymbol);
		symbol=_symbol;
		type=_type;
		setValue(val);		
	}
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getSymbol() {
		return symbol;
	}	
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String val) {
		this.value = val;
	}
	public int getAddress() {
		return address;
	}
	public void setAddress(int address) {
		this.address = address;
	}
	
}

class LiteralTable {
	private int no;
	private String literal;
	private int value;
	private int address;
	public int totalnoliteral=0;
	
	LiteralTable(String _literal,int _value,int _adrs){
		setNo(++totalnoliteral);
		literal=_literal;
		setValue(_value);
		setAddress(_adrs);
	}
	
	LiteralTable(String _literal,int _value){
		setNo(++totalnoliteral);
		literal=_literal;
		setValue(_value);	
	}

	public String getLiteral() {
		return literal;
	}	
	public void setLiteral(String literal) {
		this.literal = literal;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public int getAddress() {
		return address;
	}
	public void setAddress(int address) {
		this.address = address;
	}
	
}

class machcode {
	private int adrs;
	private String opcode;
	private String operand;
	private String comment;
	
	machcode(int _adrs,String _opcode,String _operand,String _comment){
		setAdrs(_adrs);
		setOpcode(_opcode);
		setOperand(_operand);
		setComment(_comment);
	}
	machcode(int _adrs,String _opcode,String _operand){
		setAdrs(_adrs);
		setOpcode(_opcode);
		setOperand(_operand);
	}
	machcode(int _adrs,String _opcode){
		setAdrs(_adrs);
		setOpcode(_opcode);
	}
	public int getAdrs() {
		return adrs;
	}
	public void setAdrs(int adrs) {
		this.adrs = adrs;
	}
	public String getOpcode() {
		return opcode;
	}
	public void setOpcode(String opcode) {
		this.opcode = opcode;
	}
	public String getOperand() {
		return operand;
	}
	public void setOperand(String operand) {
		this.operand = operand;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
}

class OpcTable{
	String Assopc;
	String machopc;
	String operand;
	
	OpcTable(String Aop,String Mop,String opr){
		Assopc=Aop;
		machopc=Mop;
		operand=opr;
	}
	OpcTable(String Aop,String Mop){
		Assopc=Aop;
		machopc=Mop;
	}
	
}
public class Assembler {
	
	public static String getopcode(String asop) {
		if(asop.equalsIgnoreCase("CLA")) {
			return "0000";
		}
		else if(asop.equalsIgnoreCase("LAC")) {
			return "0001";
		}
		else if(asop.equalsIgnoreCase("SAC")) {
			return "0010";
		}
		else if(asop.equalsIgnoreCase("ADD")) {
			return "0011";
		}
		else if(asop.equalsIgnoreCase("SUB")) {
			return "0100";
		}
		else if(asop.equalsIgnoreCase("BRZ")) {
			return "0101";
		}
		else if(asop.equalsIgnoreCase("BRN")) {
			return "0110";
		}
		else if(asop.equalsIgnoreCase("BRP")) {
			return "0111";
		}
		else if(asop.equalsIgnoreCase("INP")) {
			return "1000";
		}
		else if(asop.equalsIgnoreCase("DSP")) {
			return "1001";
		}
		else if(asop.equalsIgnoreCase("MUL")) {
			return "1010";
		}
		else if(asop.equalsIgnoreCase("DIV")) {
			return "1011";
		}
		else if(asop.equalsIgnoreCase("STP")) {
			return "1100";
		}
		else if(asop.equalsIgnoreCase("DC") || asop.equalsIgnoreCase("DS")) {
			return "1101";
		}
		
		return null;
	}
	
	public static BufferedReader readFile(File file) throws FileNotFoundException {
		BufferedReader br = new BufferedReader(new FileReader(file));
		return br;
	}
	
	public static String getNextLine(BufferedReader br) throws IOException {
		String st;
		if((st=br.readLine())!=null)
			return st;
		else
			return null;
	}
	public static String getbin(int n) {
		int a;
		String x="";
		while(n>0) {
			a=n%2;
			x=a+x;
			n/=2;
		}
		int len=x.length();
		if(x.length()<8) {
			String y="";
			for(int i=0;i<8-len;i++) {
				y+="0";
			}
			y+=x;
			return y;
		}
		else
			return x;
	}
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		System.out.println("Enter location of file : ");
//		String loc="C:\\Users\\Piyush Aggarwal\\eclipse-workspace\\Assembler\\src\\test.txt";
		String loc=in.nextLine();
//		in.nextLine();
		BufferedReader br;
		try {
			br = readFile(new File(loc));
		} catch (FileNotFoundException e1) {
			System.out.println("File location not found..");
			return;
		}
		int lineno=0;
		String nextLine;
//		while((nextLine=getNextLine(br))!=null) {
//			System.out.println(lineno++ + "\t" + nextLine);			
//		}
		br=readFile(new File(loc));
		lineno=0;
		ArrayList<SymbolTable> symTab=new ArrayList<SymbolTable>();
		ArrayList<LiteralTable> litTab=new ArrayList<LiteralTable>();
		ArrayList<machcode> mcode=new ArrayList<machcode>();
		ArrayList<OpcTable> opcodetable=new ArrayList<OpcTable>();
		boolean stop=false;
		int loccounter=0;
		System.out.println("CONVERTING FILE ...");
		while((nextLine=getNextLine(br))!=null) {
			System.out.println(lineno++ + "\t" + nextLine);	
			String[] row=nextLine.split("\t");
			if(row.length==1 || row[1].length()==0) {
				System.out.println("ERROR : No opcode in this line : "+nextLine+ " : Ignoring this line. ");
				continue;
			}
			if((row.length==2 || row[2].length()==0) && !(row[1].equalsIgnoreCase("CLA") || row[1].equalsIgnoreCase("STP"))) {
				System.out.println("ERROR : No operand in this line : "+ nextLine + " : Ignoring this line.");
				continue;
			}
			if(row.length>=3 && row[2].length()>0 && (row[1].equalsIgnoreCase("CLA") || row[1].equalsIgnoreCase("STP"))) {
				System.out.println("ERROR : No operand is needed in this line : "+ nextLine + " : Ignoring this operand.");
			}
			String mcop=getopcode(row[1]);
			if(mcop==null) {
				System.out.println("ERROR : Unidentified opcode in this line : "+nextLine+ " : Ignoring this line.");
				continue;
			}
			if(row[0].length()==0 && (row[1].equalsIgnoreCase("DS") || row[1].equalsIgnoreCase("DW") || row[1].equalsIgnoreCase("DC"))) {
				System.out.println("Label/Var. Name is required in declarative statements : "+nextLine+" : Ignoring this line");
				continue;
			}
			
			
			if((stop==false) && (row[0].length()>0 && !(row[1].equalsIgnoreCase("DS") || row[1].equalsIgnoreCase("DW") || row[1].equalsIgnoreCase("DC")))) {
				if(getopcode(row[0])!=null) {
					System.out.println("Label Name can't be an opcode. : Ignoring this label.");
				}
				else {
					ArrayList<SymbolTable> cur=symTab;
					boolean check1=false; 
					for(int i=0;i<cur.size();i++) {
						SymbolTable x=cur.get(i);
						if(x.getType().equalsIgnoreCase("LABEL")&& x.getSymbol().equalsIgnoreCase(row[0])) {
							x.setAddress(loccounter);
							check1=true;
						}
					}
					if(check1==false)
						symTab.add(new SymbolTable(row[0],"LABEL",loccounter));
					
						
				}
			}
			String opc=getopcode(row[1]);
			if(stop==true && !(opc.equals("1101"))) {
				System.out.println("ERROR : Conversion already stopped : Ignoring this line.");
				continue;
			}
			if(opc.equals("1100")) {
				stop=true;
			}
//			if(opc.equals("0101"))
			if(opc.equals("0000")||opc.equals("1100")) {
				mcode.add(new machcode(loccounter++,opc));
				opcodetable.add(new OpcTable(row[1],opc));
			}
			else {
				if(row[2].startsWith("'=")) {
					ArrayList<LiteralTable> cur=litTab;
					boolean check=false;
					for(int i=0;i<cur.size();i++) {
						LiteralTable x=cur.get(i);
						if(x.getLiteral().equals(row[2])) {
							check=true;
						}
					}
					if(check==false)
						litTab.add(new LiteralTable(row[2],Character.getNumericValue(row[2].charAt(2))));
				}
				else {
					if ((opc.equals("1101"))== false) {
						ArrayList<SymbolTable> cur=symTab;
						boolean check1=false; //Var
						boolean check2=false; //Label
						for(int i=0;i<cur.size();i++) {
							SymbolTable x=cur.get(i);
							if(x.getSymbol().equals(row[2])) {
								if(x.getType().equalsIgnoreCase("VARIABLE"))
									check1=true;
								else if(x.getType().equalsIgnoreCase("LABEL"))
									check2=true;
							}
						}
						if((opc.equals("0101") || opc.equals("0110") || opc.equals("0111")) && check1==true){
							System.out.println("ERROR : You entered a variable name as operand to a branch statement. It should be a LABEL.");
							continue;
						}
						if(!(opc.equals("0101") || opc.equals("0110") || opc.equals("0111")) && check2==true) {
							System.out.println("ERROR : You entered a Label name as operand. It should be a variable.");
							continue;
						}
						if((opc.equals("0101") || opc.equals("0110") || opc.equals("0111")) && check2==false) {
							symTab.add(new SymbolTable(row[2],"LABEL"));
						}
						if(!(opc.equals("0101") || opc.equals("0110") || opc.equals("0111")) && check1==false)
							symTab.add(new SymbolTable(row[2],"VARIABLE"));
						if((opc.equals("0101") || opc.equals("0110") || opc.equals("0111")) && check1==true){
							System.out.println("ERROR : You entered a variable name as operand to a branch statement. It should be a LABEL.");
							continue;
						}
						if(!(opc.equals("0101") || opc.equals("0110") || opc.equals("0111")) && check2==true) {
							System.out.println("ERROR : You entered a Label name as operand. It should be a variable.");
							continue;
						}
					}
				}
				if(!(opc.equals("1101") )) {
					mcode.add(new machcode(loccounter++,opc,row[2]));				
					opcodetable.add(new OpcTable(row[1],opc,row[2]));
				}
			}
			if(row.length==4 && row[3].length()>0) {
				mcode.get(mcode.size()-1).setComment(row[3]);
			}
				
			
			
			if(row[0].length()>0 && (row[1].equalsIgnoreCase("DS") || row[1].equalsIgnoreCase("DW") || row[1].equalsIgnoreCase("DC"))) {
				if(row[2].length()==0) {
					System.out.println();
				}
				ArrayList<SymbolTable> cur=symTab;
				boolean flag=false;
				for(int i=0;i<cur.size();i++) {
					SymbolTable x=cur.get(i);
					if(x.getSymbol().equals(row[0]) && x.getType().equalsIgnoreCase("LABEL")) {
						System.out.println("ERROR : Label can't be declared a value : Ignoring this line.");
						flag=true;
						continue;
					}
					if(x.getSymbol().equals(row[0]) ) {
						symTab.get(i).setValue(row[2]);
						x.setValue(row[2]);
						flag=true;
					}
				}
				if(flag==false)
					symTab.add(new SymbolTable(row[0],"VARIABLE",row[2]));
				
			}
			

		}
		System.out.println();
		if(stop==false)
			System.out.println("ERROR : There is no Stop statement in the Assemly Code. Still showing results.");
		ArrayList<SymbolTable> symb=symTab;
		for(int i=0;i<symb.size();i++) {
			SymbolTable x=symb.get(i);
			if(x.getType().equalsIgnoreCase("VARIABLE")) {
				x.setAddress(loccounter++);
				mcode.add(new machcode(x.getAddress(),"Address of "+x.getSymbol()));
				if(x.getValue()==null) {
					System.out.println("ERROR : No Value declared for "+x.getSymbol()+" : Still showing result.");
				}
			}	 
		}
		
		ArrayList<LiteralTable> litr=litTab;
		for(int i=0;i<litr.size();i++) {
			LiteralTable x=litr.get(i);
			x.setAddress(loccounter++);
			mcode.add(new machcode(x.getAddress(),"Address of "+x.getLiteral()));
		}
		
		boolean checkstop=false;
		ArrayList<machcode> machinecode=mcode;
		for(int i=0;i<machinecode.size();i++) {
			machcode x=machinecode.get(i);
			if(x.getOpcode().equals("1100")) 
				checkstop=true;
			if(checkstop==false){
				if(x.getOpcode().equals("0000"))
					continue;
				else {
					String oprnd=x.getOperand();
					ArrayList<LiteralTable> litr2=litTab;
					for(int i1=0;i1<litr2.size();i1++) {
						LiteralTable x1=litr2.get(i1);
						if(x1.getLiteral().equalsIgnoreCase(oprnd)) {
							x.setOperand(Integer.toString(x1.getAddress()));
						}
					}
					
					ArrayList<SymbolTable> symb2=symTab;
					for(int i1=0;i1<symb2.size();i1++) {
						SymbolTable x1=symb2.get(i1);
						if(x1.getSymbol().equalsIgnoreCase(oprnd)) {
							x.setOperand(Integer.toString(x1.getAddress()));
						}
					}
				}
			}
		}
		System.out.println("Opcode Table");
		for(int i=0;i<opcodetable.size();i++) {
			OpcTable x=opcodetable.get(i);
			System.out.println(x.Assopc+" "+x.machopc+ " "+x.operand);
		}
		
		
		System.out.println();
		System.out.println("The Symbol Table,Literal Table and the machine code are printed in a file : output.txt");
		
		File dir=new File("C:\\Users\\Piyush Aggarwal\\eclipse-workspace\\Assembler\\src");
		dir.mkdirs();
		File file=new File(dir,"output.txt");
		FileWriter archivo=new FileWriter(file);
		BufferedWriter cout=new BufferedWriter(archivo);
		cout.write("                 SYMBOL TABLE");
		cout.newLine();
		cout.write(String.format("%10s%10s%10s%10s", "Symbol","Type","Value","Address"));
		cout.newLine();
		cout.write("-----------------------------------------");
		cout.newLine();
		
//		System.out.println();
//		System.out.println("                 SYMBOL TABLE");
//		System.out.format("%10s%10s%10s%10s","Symbol","Type","Value","Address");
//		System.out.println();
//		System.out.println("-----------------------------------------");
		ArrayList<SymbolTable> now=symTab;
		for(int i=0;i<now.size();i++) {
			SymbolTable x=now.get(i);
//			System.out.format("%10s%10s%10s%10s",x.getSymbol(),x.getType(),x.getValue(),getbin(Integer.valueOf(x.getAddress())));
//			System.out.println();
			cout.write(String.format("%10s%10s%10s%10s",x.getSymbol(),x.getType(),x.getValue(),getbin(Integer.valueOf(x.getAddress()))));
			cout.newLine();
		}
		
		cout.newLine();
		cout.write("          Literal TABLE");
		cout.newLine();
		cout.write(String.format("%10s%10s%10s", "Literal","Value","Address"));
		cout.newLine();
		cout.write("-------------------------------");
		cout.newLine();
//		System.out.println();
//		System.out.println("          Literal TABLE");
//		System.out.format("%10s%10s%10s","Literal","Value","Address");
//		System.out.println();
//		System.out.println("-------------------------------");
		ArrayList<LiteralTable> now3=litTab;
		for(int i=0;i<now3.size();i++) {
			LiteralTable x3=now3.get(i);
//			System.out.format("%10s%10s%10s",x3.getLiteral(),x3.getValue(),getbin(Integer.valueOf(x3.getAddress())));
//			System.out.println();
			cout.write(String.format("%10s%10s%10s", x3.getLiteral(),x3.getValue(),getbin(Integer.valueOf(x3.getAddress()))));
			cout.newLine();
		}
		cout.newLine();
		cout.write("       Machine Lang Code");
		cout.newLine();
		cout.write(String.format("%10s%10s%10s%10s", "Address","Opcode","Operand","Comment"));
		cout.newLine();
		cout.write("---------------------------------------------------");
		cout.newLine();
//		System.out.println();
//		System.out.println("       Machine Lang Code");
//		System.out.format("%10s%20s%10s%10s","Address","Opcode","Operand","Comment");
//		System.out.println();
//		System.out.println("---------------------------------------------------");
		ArrayList<machcode> now2=mcode;
		for(int i=0;i<now2.size();i++) {
			machcode x=now2.get(i);
			if(x.getOperand()==null && x.getComment()==null) {
//				System.out.format("%10s%20s",getbin(x.getAdrs()),x.getOpcode());
//				System.out.println();
				if(x.getOpcode().startsWith("Address of ")) {
					continue;
				}
				cout.write(String.format("%10s%10s", getbin(x.getAdrs()),x.getOpcode()));
				cout.newLine();
			}
			else if(x.getComment()==null) {
//				System.out.format("%10s%20s%10s",getbin(x.getAdrs()),x.getOpcode(),getbin(Integer.valueOf(x.getOperand())));
//				System.out.println();
				if(x.getOpcode().startsWith("Address of ")) {
					continue;
				}
				cout.write(String.format("%10s%10s%10s", getbin(x.getAdrs()),x.getOpcode(),getbin(Integer.valueOf(x.getOperand()))));
				cout.newLine();
			}
			else {
//				System.out.format("%10s%20s%10s%30s",getbin(x.getAdrs()),x.getOpcode(),getbin(Integer.valueOf(x.getOperand())),x.getComment());
//				System.out.println();
				if(x.getOpcode().startsWith("Address of ")) {
					continue;
				}
				cout.write(String.format("%10s%10s%10s%30s", getbin(x.getAdrs()),x.getOpcode(),getbin(Integer.valueOf(x.getOperand())),x.getComment()));
				cout.newLine();
			}
		}
		
		cout.close();
	}
}
