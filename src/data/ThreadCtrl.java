package data;

import har.Constants;

import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;

public class ThreadCtrl  implements Runnable {
	String cmd=null;
	
	
	ImageGUI videoGUI;
	JButton buttonRecover; 
//	ImageGUI predictVideo;

	public ThreadCtrl(String command) {
		// TODO Auto-generated constructor stub
		cmd=command;
	}
	
	public void setGUI(ImageGUI v,JButton b){
		videoGUI=v;
		buttonRecover=b;
		/*if(no==1){
			trainVideo=v;
		}
		else if(no==2){
			predictVideo=v;
		}*/
	}
	
	public void setGUI(JButton b){
		buttonRecover=b;
	}
		

	@Override
	public void run() {
		// TODO Auto-generated method stub

		if(cmd.equals("Extract")){
			
			//提取所有视频特征：
			ExtractAllVideos extA=new ExtractAllVideos();
			try {
				extA.exe(videoGUI);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			buttonRecover.setText("提取特征");
			MainWindow.isRunning=false;
			MainWindow.ExtractButtonState=false;
		}
		else if(cmd.equals("Train")){
			
//			训练：
			try {
				if(MySVM.loadTrainData())
//				MySVM.saveTrainDataTest();
//				System.out.println(MySVM.loadTrainData());
				MySVM.train();
				else
					System.out.println("训练数据加载失败！");
			} catch (NumberFormatException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			MainWindow.isRunning=false;
			MainWindow.TrainButtonState=false;
			buttonRecover.setText("训练");
		}
		else if(cmd.equals("Predict")){
			
			JFileChooser jfc=new JFileChooser(MyConstants.dataOfVideosAddress);  
	        jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES );  
	        jfc.showDialog(new JLabel(), "选择");
	        File file=jfc.getSelectedFile();
	        MySVM.predict(file.toString(),videoGUI);
	        MainWindow.isRunning=false;
	        MainWindow.PredictButtonState=false;
	        buttonRecover.setText("预测");
		}
	}

}
