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
import basic.zBasic.util.server.tomcat.ServerContextUtilZZZ;
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
	
	
	public String proofJndiResourceConfiguredAvailable(){
		String sReturn = null;
		main:{
		try {
			IKernelZZZ objKernel = KernelSingletonZZZ.getInstance();
			String sJndi = objKernel.getParameter("DatabaseRemoteNameJNDI");
			
			sReturn = this.proofJndiResourceAvailable(sJndi);
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
	
		main:{
//			try {
				//IKernelZZZ objKernel = KernelSingletonZZZ.getInstance();
				//String sJndi = objKernel.getParameter("DatabaseRemoteNameJNDI");
				
				//Aber an dieser Stelle will ich überhaupt keine Hibenate - Verbindung haben..., wie ?
				//HibernateContextProviderJndiSingletonTHM objContextHibernate = HibernateContextProviderJndiSingletonTHM.getInstance(objKernelSingleton, sContextJndi);					
				//objContextHibernate.getConfiguration().setProperty("hibernate.hbm2ddl.auto", "update");  //! Jetzt erst wird jede Tabelle über den Anwendungsstart hinaus gespeichert UND auch wiedergeholt.				
				
				//Also ist die einzige Lösung es so zu probieren:
				InitialContext ctx;
				try {
					ctx = new InitialContext();
					String sJndicontextPath = ServerContextUtilZZZ.computeContextJndiLookupPath(sJndiContext);
					Object ref = ctx.lookup(sJndicontextPath);
					if(ref!=null){
						bReturn = true;
					}
				} catch (NamingException e) {
					//Merke: Wenn dieser Fehler geworfen wird, dann ist die Ressource nicht vorhanden, 
					//       also nur den Fehler abfangen.
					bReturn = false;
					
					//e.printStackTrace();
					//ExceptionZZZ ez = new ExceptionZZZ(e.getMessage());
					//throw ez;
				}
				
				
				
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
//			} catch (ExceptionZZZ e) {
//				System.out.println(e.getDetailAllLast());
//				e.printStackTrace();
//			}
		}//end main:
	
		return sReturn;
	}
	
	
}
