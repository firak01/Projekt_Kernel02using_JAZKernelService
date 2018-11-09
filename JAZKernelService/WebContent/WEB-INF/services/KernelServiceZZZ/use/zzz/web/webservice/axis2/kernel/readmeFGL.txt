20181109
Momentan sind die Klassen für die Persistierung und die HibernateSessionFactory noch im TileHexMap Projekt vorhanden.
Daher muss dieses Projekt zwingend im WebDeploymentAssembly Menü der Projekteingeschaften das TileHexMap Projekt einbinden: 
Source: JAZTileHexMap03
Deploy Path: WEB-INF/lib/JAZTileHexMap03.jar

Im Verzeichnis tomcat/lib muss vorhanden sein (ggfs. hier im Eclipse auch den Ordner Apache Tomcat v.... aktualisieren):
hibernate4-sqlite-dialect-0.1.2.jar
sqlite-jdbc-3.23.1.jar

Ansonsten Fehlermeldung:

getMethodCurrentNameLined - Line: 102: Jndi Pfad = 'jdbc/ServicePortal'
[ERROR] org/hibernate/SessionFactory
java.lang.reflect.InvocationTargetException
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(Unknown Source)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(Unknown Source)
	at java.lang.reflect.Method.invoke(Unknown Source)
	at org.apache.axis2.rpc.receivers.RPCUtil.invokeServiceClass(RPCUtil.java:256)
	at org.apache.axis2.rpc.receivers.RPCMessageReceiver.invokeBusinessLogic(RPCMessageReceiver.java:121)
	at org.apache.axis2.receivers.AbstractInOutMessageReceiver.invokeBusinessLogic(AbstractInOutMessageReceiver.java:40)
	at org.apache.axis2.receivers.AbstractMessageReceiver.receive(AbstractMessageReceiver.java:106)
	at org.apache.axis2.engine.AxisEngine.receive(AxisEngine.java:169)
	at org.apache.axis2.transport.http.HTTPTransportUtils.processHTTPPostRequest(HTTPTransportUtils.java:178)
	at org.apache.axis2.transport.http.AxisServlet.doPost(AxisServlet.java:163)
	at javax.servlet.http.HttpServlet.service(HttpServlet.java:648)
	at javax.servlet.http.HttpServlet.service(HttpServlet.java:729)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:292)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:207)
	at org.apache.tomcat.websocket.server.WsFilter.doFilter(WsFilter.java:52)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:240)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:207)
	at org.apache.catalina.core.StandardWrapperValve.invoke(StandardWrapperValve.java:212)
	at org.apache.catalina.core.StandardContextValve.invoke(StandardContextValve.java:94)
	at org.apache.catalina.authenticator.AuthenticatorBase.invoke(AuthenticatorBase.java:504)
	at org.apache.catalina.core.StandardHostValve.invoke(StandardHostValve.java:141)
	at org.apache.catalina.valves.ErrorReportValve.invoke(ErrorReportValve.java:79)
	at org.apache.catalina.valves.AbstractAccessLogValve.invoke(AbstractAccessLogValve.java:620)
	at org.apache.catalina.core.StandardEngineValve.invoke(StandardEngineValve.java:88)
	at org.apache.catalina.connector.CoyoteAdapter.service(CoyoteAdapter.java:502)
	at org.apache.coyote.http11.AbstractHttp11Processor.process(AbstractHttp11Processor.java:1132)
	at org.apache.coyote.AbstractProtocol$AbstractConnectionHandler.process(AbstractProtocol.java:684)
	at org.apache.tomcat.util.net.NioEndpoint$SocketProcessor.doRun(NioEndpoint.java:1533)
	at org.apache.tomcat.util.net.NioEndpoint$SocketProcessor.run(NioEndpoint.java:1489)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(Unknown Source)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(Unknown Source)
	at org.apache.tomcat.util.threads.TaskThread$WrappingRunnable.run(TaskThread.java:61)
	at java.lang.Thread.run(Unknown Source)
Caused by: java.lang.NoClassDefFoundError: org/hibernate/SessionFactory