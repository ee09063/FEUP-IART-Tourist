package Interface;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import Graph.Graph;

public class GUI implements KeyListener, MouseListener{
	
	protected static JMenuBar menu;
	protected static JMenu menu_file;
	
	protected static myPanel map;
	protected static GUI window;
	protected static JFrame frame;
	
	private static WindowListener closeWindow = new WindowAdapter() {
        public void windowClosing(WindowEvent e) {
        	map.setFocusable(true);
        	map.requestFocusInWindow();
            e.getWindow().dispose();
        }
    };
	
    public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window = new GUI();
					GUI.frame.pack();
					GUI.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
    
    public GUI(){
    	initialize();
    }
    
    private void initialize(){
    	frame = new JFrame("Tourist Map App");
    	frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		prepare();
		
		map = new myPanel();
		map.setFocusable(true);
		map.addKeyListener(this);
		map.addMouseListener(this);
		map.requestFocusInWindow();
		frame.getContentPane().add(map, BorderLayout.CENTER);
    }
	
    protected void prepare(){
    	menu = new JMenuBar();
    	menu_file = new JMenu("File");
    	
    	JMenuItem load_map = new JMenuItem("Load Map");
    	load_map.setToolTipText("Load Map");
    	load_map.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent e){
    			JFileChooser f = new JFileChooser();
    			f.setCurrentDirectory(new File(System.getProperty("user.dir")));
    			FileNameExtensionFilter filter = new FileNameExtensionFilter("TXT", "txt");
    			f.setFileFilter(filter);
    			int returnVal = f.showOpenDialog(frame);
    			if(returnVal == JFileChooser.APPROVE_OPTION){
    				File file = f.getSelectedFile();
    				System.out.println("You tried to load file " + file.getName());
    				/*
    				 * GRAPH BULDING GOES HERE
    				 */
    				try {
						Graph graph = new Graph(file);
						myPanel.g_to_draw = graph;
						map.repaint();
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
    				
    			}
    			/*
    			 * APPLICATION OF THE ALGORITH GOES HERE
    			 */
    		}
    	});
    	
    	JMenuItem exit = new JMenuItem("Exit");
    	exit.setToolTipText("Exit Application");
    	exit.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent e){
    			int option = JOptionPane.showConfirmDialog(frame, "Exit Application?", "Exit?", JOptionPane.YES_NO_OPTION);
    			if(option == JOptionPane.YES_OPTION){
    				System.exit(0);
    			}
    		}
    	});
    	
    	menu_file.add(load_map);
    	menu_file.add(exit);
    	menu.add(menu_file);
    	frame.setJMenuBar(menu);
    }
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	
}