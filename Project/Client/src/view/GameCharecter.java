 package view;

import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.graphics.Device;
import org.eclipse.swt.graphics.GCData;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;

public class GameCharecter {

		   int x,y;
		   String icon = new String("lib\\devil.png");
		   
		   public GameCharecter(int x,int y) {
			this.x=x;this.y=y;
		   }
		   
		   public void paint(PaintEvent e,int w,int h){
			   
				Image image = new Image(new Device() {

					@Override
					public void internal_dispose_GC(long arg0, GCData arg1) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public long internal_new_GC(GCData arg0) {
						// TODO Auto-generated method stub
						return 0;
					}
				

				}, icon);  
				
				ImageData imageData =  image.getImageData();
				e.gc.drawImage(image, 0, 0, imageData.width , imageData.height -10, x, y, w, h);
		   }
		   
		   public void paint(PaintEvent e,int w,int h, int x, int y){
			   
				Image image = new Image(new Device() {

					@Override
					public void internal_dispose_GC(long arg0, GCData arg1) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public long internal_new_GC(GCData arg0) {
						// TODO Auto-generated method stub
						return 0;
					}
					
				}, icon);  
				
				ImageData imageData =  image.getImageData();
				e.gc.drawImage(image, 0, 0, imageData.width - 10, imageData.height - 10, x, y, w, h);
		   }
		

}
