package tech.codehunt.fileio;


import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;

public class ProjectIO {
	
	  private String result;
	   @SuppressWarnings("finally")
	public String projectWrite(HttpServletRequest request, String uniqueFileName)
	   {
		   try
		   {
			   InputStream is = request.getPart("myfile").getInputStream();
			  byte b[]= new byte[is.available()];
			  is.read(b);
			  // when host the website then use this path
			 // String path=request.getRealPath("images\\myproject\\")+uniqueFileName;
			  
			  String path="C:\\Users\\User\\eclipse-workspace\\myportfolio\\src\\main\\webapp\\images\\fileuploaded\\"+uniqueFileName;
			   FileOutputStream fos = new FileOutputStream(path);
			   fos.write(b);
			   
			   
			   is.close();
			   fos.close();
			   
			   result="success";
			   
		   }
		   catch(Exception e)
		   {
			   result="failed";
			   e.printStackTrace();
		   }
		   finally
		   {
			   return result;
		   }
		   
		   
		   
		   
		   
	   }
	   @SuppressWarnings("finally")
	public String projectDelete(HttpServletRequest request, String filename)
	   {
		   try
		   {
			   
			  String path="C:\\Users\\User\\eclipse-workspace\\myportfolio\\src\\main\\webapp\\images\\fileuploaded\\"+filename;
			   
			  new File(path).delete();			   
			   result="success";
			   
		   }
		   catch(Exception e)
		   {
			   result="failed";
			   e.printStackTrace();
		   }
		   finally
		   {
			   return result;
		   }
		   
		   
		   
		   
		   
	   }

}
