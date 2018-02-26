package remotereader;

public class TestRemote {
	
	 static String localFileLocation="C:\\Users\\ajain5\\Desktop\\";
	 static String versionFileName="version.info";
	 static String remoteFileLocation="/opt/ctier/Commander/depots/RWS/deployments/NewSDK-JBoss/BVT2NewSDK-JBoss/sdk/newsdk/server/";
	
	public static void main(String[] args) throws Exception {
		getComponentVersion("192.168.210.70", "read", "read", remoteFileLocation,"BuildNumber");
	}
	
	public static String getComponentVersion(String host, String uName, String pwd,String logLocation,String key) throws Exception
	{
		return null;
		/*RemoteReader rr=new RemoteReader(host,uName,pwd);
		rr.copyLogFiletoLocal(logLocation, versionFileName, localFileLocation);
		String val=new TextParser().getValue(localFileLocation+versionFileName, key);
		return val;*/
	}
	
	

}
