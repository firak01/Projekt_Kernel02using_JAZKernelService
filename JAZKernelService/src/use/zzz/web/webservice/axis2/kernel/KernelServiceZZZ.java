package use.zzz.web.webservice.axis2.kernel;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import basic.zBasic.ExceptionZZZ;
import basic.zBasic.util.datatype.string.StringZZZ;
import basic.zKernel.IKernelZZZ;
import basic.zKernel.KernelSingletonZZZ;
import basic.zKernel.KernelZZZ;

public class KernelServiceZZZ {
	public String sayHello(String name){
		return "Hello " + name;
	}
	public String getNow(){
		Calendar cal = Calendar.getInstance();
		//Date date = new Date();
		Date date = cal.getTime();
		String sReturn = new Integer(date.getYear()).toString() + new Integer(date.getMonth()).toString() + new Integer(date.getDay()).toString();
		return sReturn;
	}
	
	public String getParameter(String sParameterInIni){
		String sReturn=null;
		
		main:{
			if(StringZZZ.isEmpty(sParameterInIni)) break main;
			try {
				IKernelZZZ objKernel = KernelSingletonZZZ.getInstance();
				sReturn = objKernel.getParameter(sParameterInIni);				
			} catch (ExceptionZZZ e) {
				System.out.println(e.getDetailAllLast());
				e.printStackTrace();
				
			}
		}//end main:
		return sReturn;
	}
	
	/**Merke: Das ist der flexiblere Einsatz der MEthode.
	 *        In den WebServices kann durchaus eine Methode existieren, in der der Überagebestring fest ist,
	 *        da von einer festen Datasource (deshalb ...used...) ausgegangen wird.
	 *        Z.B.  TileService.getProofJndiResourceUsedAvailable();
	 * @param sJndiContext
	 * @return
	 */
	public String proofJndiResourceAvailable(String sJndiContext){
		String sReturn=null;
		boolean bReturn=false;
		
		//TODO GOON 20181018:
		main:{
			try {
				IKernelZZZ objKernel = KernelSingletonZZZ.getInstance();
				String sValue = objKernel.getParameter("DatabaseRemoteNameJNDI");
				
				//Missbrauch dieser Methode:
				//Tryout eine SessionFactory per JNDI zu erzeugen
	//			TryoutSessionFactoryCreation objTryout = new TryoutSessionFactoryCreation();
				//Das funktioniert. boolean bReturn = objTryout.tryoutGetSessionFactoryByJndi();
				
				//DEBUG: 20171206 NEUE ALTERNATIVE ÜBER CONTEXTPROVIDERJNDI
	//			boolean bReturn = objTryout.tryoutGetSessionFactoryByJndiContextProvider(sJndiContext);
				if(bReturn){
					sReturn = "vorhanden";
				}else{
					sReturn = "nicht vorhanden";
				}
			} catch (ExceptionZZZ e) {
				System.out.println(e.getDetailAllLast());
				e.printStackTrace();
			}
		}//end main:
	
		return sReturn;
	}
}
