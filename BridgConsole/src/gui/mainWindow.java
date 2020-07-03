package gui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import apiCaller.apiBridg;
import appTools.settingReader;

public class mainWindow {

	protected Shell shell;
	private Text text;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			mainWindow window = new mainWindow();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("SWT Application");
		
		addButton(shell);
		addOutResultComponent(shell);		
		

	}
	
	void addButton(Shell shell) {
		Button btnCallTestmethod = new Button(shell, SWT.NONE);
		btnCallTestmethod.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				MessageBox messageBox = new MessageBox(shell, SWT.ICON_QUESTION | SWT.YES | SWT.NO);
			    messageBox.setMessage("simple messaeg");
			    messageBox.setText("Confirm Delete - test");
			    int response = messageBox.open();
			}
		});
		btnCallTestmethod.setBounds(10, 10, 141, 25);
		btnCallTestmethod.setText("Call testMethod");
		
		
		
		Button btnCallPostApi = new Button(shell, SWT.NONE);
		btnCallPostApi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				callPostMethod();
			}

		});
		btnCallPostApi.setBounds(10, 42, 141, 25);
		btnCallPostApi.setText("call Post method");
		
		
		Button btnCallGetApi = new Button(shell, SWT.NONE);
		btnCallGetApi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				callGetMethod();
			}
		});
		btnCallGetApi.setBounds(10, 82, 141, 25);
		btnCallGetApi.setText("call Get method");
	}
	
	
	void addOutResultComponent(Shell shell) {
		text = new Text(shell, SWT.BORDER);
		text.setEditable(false);
		text.setBounds(10, 173, 414, 78);
		text.setText(readConfigSetting());
		
		Label lblServerResponce = new Label(shell, SWT.NONE);
		lblServerResponce.setBounds(10, 152, 91, 15);
		lblServerResponce.setText("Server responce:");
	}
	
	
	String readConfigSetting() {
		settingReader sr = new settingReader();
		String res = "api.Host: " + sr.readPropertyValue("api.Host");

        return res;
	}


	private void callPostMethod() {
		
		settingReader sr = new settingReader();
		String apiHost = sr.readPropertyValue(settingReader.apiHost);
		apiBridg ab = new apiBridg(apiHost);
		
		text.setText(ab.phytonTestMethods.callPostMethodWithParam());
	}
	
	

	private void callGetMethod() {
		
		settingReader sr = new settingReader();
		String apiHost = sr.readPropertyValue(settingReader.apiHost);
		apiBridg ab = new apiBridg(apiHost);
		
		text.setText(ab.phytonTestMethods.callGetMethod());
	}
}
