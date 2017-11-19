package views;

import java.util.Random;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;


import model.Roles;
import model.User;

public class DashboradView {
	private User user;
	public DashboradView(User user) {
		this.user = user;
	}
	
	public void view(){
		JFrame frame = new JFrame("Login");
		frame.setSize(700, 600);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		
		JLabel lbTitle = new JLabel("Bem vindo " + this.user.getName());
		lbTitle.setSize(150,150);
		lbTitle.setLocation(250,10);
		frame.add(lbTitle);
		
		String[] columnNames = { "ID", "Nome da prop", "Status", "endereço", "Agrotoxico" };
		Object rowData[][] = this.generateDataForTable();
			    
		JTable table = new JTable(new MyTableModel(columnNames, rowData, user.getRole()));
	    		
		
		JScrollPane scrollPane = new JScrollPane(table);
	    scrollPane.setLocation(10, lbTitle.getY() +  lbTitle.getHeight());
	    scrollPane.setSize(frame.getWidth() - 40, frame.getHeight() - (lbTitle.getY() + lbTitle.getHeight() + 40 ));

		frame.add(scrollPane);

		frame.setVisible(true);
	}
	
	private Object[][] generateDataForTable() {
		String[] propNames = {
			"Una	Edmunds",
			"Carolyn	Dyer",
			"Dan	Vaughan",
			"Michelle	Slater",
			"Fiona	Morgan",
			"Amelia	Mitchell",
			"Joshua	Parr",
			"Faith	Avery",
			"Thomas	Hemmings",
			"Neil	Slater",
			"Wendy	Allan",
			"Stewart	Ferguson",
			"Rose	Morrison",
			"Wanda	Slater",
			"Harry	Bell"
		};
		
		String[] status = {
			"Aprovado",
			"Reprovado"
		};
		
		String[] addresNames = {
			"2 South Highland Street",
			"Dothan, AL 36301",
			"369 Rockwell Lane",
			"Gainesville, VA 20155",
			"3 Tunnel Rd. ",
			"Simpsonville, SC 29680",
			"262 South Lexington Lane", 
			"Cape Coral, FL 33904",
			"683 Buttonwood Lane",
			"Oak Park, MI 48237",
			"8182 Golden Star St.", 
			"Eden Prairie, MN 55347",
			"189 Indian Spring Drive ",
			"Carpentersville, IL 60110",
			"84 North Deerfield Court ",
			"Des Plaines, IL 60016",
			"189 Wellington Dr. ",
			"Hephzibah, GA 30815",
			"76 10th Drive ",
			"Berwyn, IL 60402",
			"353 Lake Forest Circle", 
			"Hinesville, GA 31313",
			"434 Race Street ",
			"West Chicago, IL 60185",
			"93 Heritage St. ",
			"Indianapolis, IN 46201",
			"33 Shore Court ",
			"Crown Point, IN 46307",
			"8111 Harrison Dr. ",
			"Auburn, NY 13021",
			"8656 Summer St. ",
			"Coraopolis, PA 15108",
			"16 Trusel Drive ",
			"Bartlett, IL 60103",
			"7918 Andover St. ",
			"Danville, VA 24540",
			"73 Prospect Dr. ",
			"Hummelstown, PA 17036",
			"66 Del Monte St. ",
			"Minneapolis, MN 55406"	
		};
		
		String[] agrotoxicosNames = {
			"Abamectina",
			"Veto",
			"Organoclorados",
			"Organofosforados ",
			"Carbamatos ",
			"Paraquat ",
			"Glifosate ",
			"Clorofenóxicos ",
			"Fluoracetato de Sódio",
			"Fosfeto ",
			"Hidroxicumarínicos "
		};
		
		Object[][] dataRows = new Object[20][5];
		
		for (int i = 0 ; i < 20; i++) {
			Random random = new Random();
			String value = "";
			dataRows[i][0] = i+1;
			
			
			value = propNames[random.nextInt(propNames.length - 1)];
			dataRows[i][1] = value ;
			
			
			value = status[random.nextInt(status.length )];
			dataRows[i][2] = value;
			
			
			value = addresNames[random.nextInt(addresNames.length - 1)];
			dataRows[i][3] = value;
		
			
			
			value = agrotoxicosNames[random.nextInt(agrotoxicosNames.length - 1)];
			dataRows[i][4] = value;
		
		}
		
		return dataRows;
	}
}




class MyTableModel extends AbstractTableModel {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String[] columnNames = null;
    private Object[][] data = null;
    private Roles myRole = null;
    
    public MyTableModel (String[] columns, Object[][] data, Roles role ) {
    	this.columnNames = columns;
    	this.data = data;
    	this.myRole = role;
    }
    

    public int getColumnCount() {
    	if(this.myRole == Roles.USER) {
    		return 2;
    	}else if (this.myRole == Roles.MOD) {
    		return 3;
    	}
        return columnNames.length;
    }

    public int getRowCount() {
        return data.length;
    }

    public String getColumnName(int col) {
        return columnNames[col];
    }

    public Object getValueAt(int row, int col) {
        return data[row][col];
    }

    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }

    /*
     * Don't need to implement this method unless your table's
     * editable.
     */
    public boolean isCellEditable(int row, int col) {
        //Note that the data/cell address is constant,
        //no matter where the cell appears onscreen.
        if (col < 2) {
            return false;
        } else {
            return true;
        }
    }

    /*
     * Don't need to implement this method unless your table's
     * data can change.
     */
    public void setValueAt(Object value, int row, int col) {
        data[row][col] = value;
        fireTableCellUpdated(row, col);
    }
   
}
