package data;


import java.io.File;  
import java.io.FileInputStream;  
import java.io.FileNotFoundException;  
import java.io.FileOutputStream;  
import java.io.IOException;  
import java.io.InputStream;  
import java.io.OutputStream;  
 
public class FileCopy {  
   private static  File inputFile;  
   private static File outputFile;  
   private static InputStream inputStream;  
   private static OutputStream outputStream;  
   public FileCopy(String inputPath,String outputPath) throws FileNotFoundException{  
       inputFile=new File(inputPath);  
       outputFile=new File(outputPath);  
       inputStream=new FileInputStream(inputFile);  
       outputStream=new FileOutputStream(outputFile);  
         
   }  
   
   public FileCopy(File in,File out) throws FileNotFoundException{  
       inputFile=in;  
       outputFile=out;  
       inputStream=new FileInputStream(inputFile);  
       outputStream=new FileOutputStream(outputFile);  
         
   }
   
   private static void initialize(String inputPath,String outputPath) throws FileNotFoundException{
	   inputFile=new File(inputPath);  
       outputFile=new File(outputPath);  
       inputStream=new FileInputStream(inputFile);  
       outputStream=new FileOutputStream(outputFile);
   }
   
   
   private static  void initialize(File in,File out) throws FileNotFoundException{
	   inputFile=in;  
       outputFile=out;  
       inputStream=new FileInputStream(inputFile);  
       outputStream=new FileOutputStream(outputFile);
   }
   
   //一次性把数据全部读取到内存中来，再一次性写入  
   public static void copy1(File in,File out) throws IOException{  
	   initialize(in,out);
       byte b[]=new byte[(int)inputFile.length()];  
       inputStream.read(b);       //一次性读入  
       outputStream.write(b);   //一次性写入  
//     inputStream.close();  
//     outputStream.close();  
   }  
   //边读边写  
   public static void copy2(File in,File out) throws IOException{  
	   initialize(in,out);
       int temp=0;  
       while((temp=inputStream.read())!=-1){  
           outputStream.write(temp);  
       }  
       inputStream.close();  
       outputStream.close();  
   }  
   
   //一次性把数据全部读取到内存中来，再一次性写入  
   public static void copy1(String in,String out) throws IOException{  
	   initialize(in,out);
       byte b[]=new byte[(int)inputFile.length()];  
       inputStream.read(b);       //一次性读入  
       outputStream.write(b);   //一次性写入  
//     inputStream.close();  
//     outputStream.close();  
   }  
   //边读边写  
   public static void  copy2(String in,String out) throws IOException{  
	   initialize(in,out);
       int temp=0;  
       while((temp=inputStream.read())!=-1){  
           outputStream.write(temp);  
       }  
       inputStream.close();  
       outputStream.close();  
   }  
     
   public File getInputFile() {  
       return inputFile;  
   }  
   public void setInputFile(File inputFile) {  
       this.inputFile = inputFile;  
   }  
   public File getOutputFile() {  
       return outputFile;  
   }  
   public void setOutputFile(File outputFile) {  
       this.outputFile = outputFile;  
   }  
  /* public static void main(String[] args) throws IOException{  
       String inputPath="e:"+File.separator+"Xfire.rar";  
       String outputPath="f:"+File.separator+inputPath.substring(inputPath.indexOf(File.separator));  
       FileCopy fileCopy=new FileCopy(inputPath, outputPath);  
       long start1=System.currentTimeMillis();  
       fileCopy.copy1();  
       long end1=System.currentTimeMillis();  
       System.out.println("一次性全部读入内存复制文件大小为"+fileCopy.getInputFile().length()+"位花费时间为:"+(end1-start1)+"ms");  
         
         
       fileCopy.getOutputFile().delete();  
       long start2=System.currentTimeMillis();  
       fileCopy.copy2();  
       long end2=System.currentTimeMillis();  
       System.out.println("边读边写复制文件大小为"+fileCopy.getInputFile().length()+"位花费时间为:"+(end2-start2)+"ms");  
   }  */
 
}  
