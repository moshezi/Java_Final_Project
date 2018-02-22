/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import client.Client;

/**
 *
 * @author Moshe Itzhaki
 */
public class LoginWindow {
    
    private final Client client;
    
    public LoginWindow(Client client)
    {
        this.client = client;
        final Display display = new Display();
        final Shell shell = new Shell(display);
        shell.setLayout(new GridLayout(1, false));

        createContents(shell);

        shell.pack();
        shell.open();
        while (!shell.isDisposed())
        {
            if ( !display.readAndDispatch() )
                display.sleep();
        }
        display.dispose();
    }


    // ==================== 5. Creators ===================================

    private void createContents(final Composite parent)
    {
        final Label loginLabel = new Label(parent, 1);
        loginLabel.setText("Login name");
        final Text loginText = new Text(parent, 1);
        
        final Label portLabel = new Label(parent, 1);
        portLabel.setText("Port");
        final Text portText = new Text(parent, 1);
        
        final Label hostLabel = new Label(parent, 1);
        hostLabel.setText("Host");
        final Text hostText = new Text(parent, 1);
        
        final Button buttonOpen = new Button(parent, SWT.PUSH);
        buttonOpen.setText("Connect");

        buttonOpen.addSelectionListener(new SelectionAdapter()
        {
            @Override public void widgetSelected(final SelectionEvent e)
            {
                client.setPort(Integer.valueOf(portText.getText()));
                client.setHost(hostText.getText());
                client.init();
                client.login("login:".concat(loginText.getText()));
                parent.getShell().close();
            }
        });

        final Button buttonClose = new Button(parent, SWT.PUSH);
        buttonClose.setText("Close");

        buttonClose.addSelectionListener(new SelectionAdapter()
        {
            @Override public void widgetSelected(final SelectionEvent e)
            {
                System.exit(0);
            }
        });
    }
}
