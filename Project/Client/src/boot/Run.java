package boot;

import java.io.IOException;

import javax.xml.bind.JAXBException;

import model.MyModel;
import presenter.Presenter;
import view.LoginWindow;
import view.MyGuiView;
import client.Client;
import client.XMLSerializer;

public class Run {

	public static void main(String[] args) throws JAXBException, IOException {
		
		/** @author Moshe Itzhaki */
                Client client = new Client();
                client.setxMLSerializer(new XMLSerializer());
                new LoginWindow(client);
		MyGuiView myGuiView = new MyGuiView();
		MyModel myModel = new MyModel();
                myModel.setClient(client);
		Presenter presnter = new Presenter(myGuiView, myModel);
		myGuiView.addObserver(presnter);
		myModel.addObserver(presnter);
		myGuiView.start();

	}

}
