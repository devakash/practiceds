/*package remotereader;


import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpATTRS;

public class RemoteReader {
	
	private String remoteUser;
	private String remoteHost;
	private String remotePassword;
	
	public RemoteReader(String remoteHost, String remoteUser, String remotePassword){
		this.remoteHost = remoteHost;
		this.remoteUser = remoteUser;
		this.remotePassword = remotePassword;
	}
	
	private SftpATTRS getAttributes(String agentFile) throws Exception {
		SftpATTRS attrsJson;
		ChannelSftp sftpChannel=getChannel();
		sftpChannel.connect();
		attrsJson =sftpChannel.stat(agentFile);
		return attrsJson;
	}
	
	public Session getSession() throws Exception {
		JSch jsch = new JSch();
		Session session = jsch.getSession(remoteUser, remoteHost);
		session.setPassword(remotePassword);
		session.setConfig("StrictHostKeyChecking", "no");
		System.out.println("Establishing Connection...");
		session.connect();
		return session;
	}
	
	
	
	public ChannelSftp getChannel() throws Exception {
		JSch jsch = new JSch();
		Session session = jsch.getSession(remoteUser, remoteHost);
		session.setPassword(remotePassword);
		session.setConfig("StrictHostKeyChecking", "no");
		 System.out.println("Establishing Connection...");
		session.connect();
		 System.out.println("Connection established.");
		 System.out.println("Crating SFTP Channel.");
		 ChannelSftp sftpChannel = (ChannelSftp) session.openChannel("sftp");
		return sftpChannel;
	}
	
	public void copyFilefromlocal(String local, String remote) throws Exception {
		ChannelSftp channel = getChannel();
		channel.connect();
		System.out.println(local);
		channel.put(local, remote);
		channel.disconnect();
		channel.exit();
	}
	
	public void copyFilefromlocal(ChannelSftp channel,String local, String remote) throws Exception {
		channel.connect();
		System.out.println(local);
		channel.put(local, remote);
		//channel.disconnect();
		//channel.exit();
	}
	
	public void disConnectChannel(ChannelSftp channel) {
		channel.disconnect();
		channel.exit();
	}
	
	
	public void copyLogFiletoLocal(String logBasePath,String robotId,String processlogFileName, String localPath) throws Exception {
		ChannelSftp channel = getChannel();
		channel.connect();
		String finalLogPath = logBasePath+robotId+"/"+processlogFileName;
		channel.get(finalLogPath, localPath);
		channel.disconnect();
		channel.exit();
	}
	
	public void copyLogFiletoLocal(String logBasePath,String processlogFileName, String localPath) throws Exception {
		JSch jsch = new JSch();
		Session session = jsch.getSession(remoteUser, remoteHost);
		session.setPassword(remotePassword);
		session.setConfig("StrictHostKeyChecking", "no");
		 System.out.println("Establishing Connection...");
		session.connect();
		 System.out.println("Connection established.");
		 System.out.println("Crating SFTP Channel.");
		 ChannelSftp sftpChannel = (ChannelSftp) session.openChannel("sftp");
		 sftpChannel.connect();
		String finalLogPath = logBasePath+processlogFileName;
		sftpChannel.get(finalLogPath, localPath);
		sftpChannel.exit();
		session.disconnect();
	}
	
	public void copyLogFiletoLocal(String logBasePath,String processlogFileName, String localPath) throws Exception {
		ChannelSftp channel = getChannel();
		channel.connect();
		String finalLogPath = logBasePath+processlogFileName;
		System.out.println(finalLogPath);
		System.out.println(localPath);
		InputStream out= null;
	    out= channel.get(finalLogPath);
	    BufferedReader br = new BufferedReader(new InputStreamReader(out));
	    String line;
	    File newFile = new File(localPath);
		OutputStream os = new FileOutputStream(newFile);
		BufferedOutputStream bos = new BufferedOutputStream(os);
	    while ((line = br.readLine().trim()) != null) 
	    {
	    	System.out.println("Writing: " );
			bos.w
	    }
	    br.close();
	        sftpChannel.disconnect();
	        session.disconnect();
		channel.get(finalLogPath, localPath);
		channel.disconnect();
		channel.exit();
	}
	
	public void copyRemotefile(String processlogfolder, String filename, String localFile) {
		try{
			ChannelSftp channel = getChannel();
			channel.connect();
			channel.cd(processlogfolder);
			byte[] buffer = new byte[1024];
			BufferedInputStream bis = new BufferedInputStream(channel.get(filename));
			File newFile = new File(localFile);
			OutputStream os = new FileOutputStream(newFile);
			BufferedOutputStream bos = new BufferedOutputStream(os);
			int readCount;
			//System.out.println("Getting: " + theLine);
			while( (readCount = bis.read(buffer)) > 0) {
				System.out.println("Writing: " );
				bos.write(buffer, 0, readCount);
			}
			bis.close();
			bos.close();
			}catch(Exception ex){
				ex.printStackTrace();
			}
	}
	
	public void copyFilefromlocal(String local, String logBasePath, String robotId,String processlogFileName) throws Exception {
		ChannelSftp channel = getChannel();
		channel.connect();
		String finalLogPath = logBasePath+robotId+"/"+processlogFileName;
		channel.put(local, finalLogPath);
		channel.disconnect();
		channel.exit();
	}
	
	public String runRemoteScripts(String command) throws Exception {
		String rez = "+!";
	  try{
		Session session = getSession();
		ChannelExec channelexec = (ChannelExec)session.openChannel("exec");
		channelexec.setCommand(command);
		channelexec.setInputStream(null);

		channelexec.setErrStream(System.err);

        InputStream in = channelexec.getInputStream();
        channelexec.connect();
        byte[] tmp = new byte[1024];
        while (true) {
            while (in.available() > 0) {
                int i = in.read(tmp, 0, 1024);
                if (i < 0)
                    break;
                 System.out.print(new String(tmp, 0, i));
                rez = new String(tmp, 0, i);
            }
            if (channelexec.isClosed()) {
                System.out.println("exit-status: "+channelexec.getExitStatus());
                break;
            }
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                rez = e.toString();
            }
        }
        channelexec.disconnect();
        session.disconnect();
    }

    catch (Exception e) {
        rez = e.toString();
    }
    return rez;

	}
	
	public void changeDircory(String absolute_path) throws Exception {
		Session session = getSession();
		ChannelExec channelexec = (ChannelExec)session.openChannel("exec");
		channelexec.setCommand("cd "+absolute_path);
		channelexec.connect();
		channelexec.run();
		channelexec.disconnect();
        session.disconnect();
	}
	
	public String runRemoteScripts(String command, int TIMEOUT) throws Exception {
		String rez = "+!";
	  try{
		Session session = getSession();
		ChannelExec channelexec = (ChannelExec)session.openChannel("exec");
		channelexec.setCommand(command);
		channelexec.setInputStream(null);

		channelexec.setErrStream(System.err);

        InputStream in = channelexec.getInputStream();
        channelexec.connect();
        byte[] tmp = new byte[1024];
        while (true) {
            while (in.available() > 0) {
                int i = in.read(tmp, 0, 1024);
                if (i < 0)
                    break;
                 System.out.print(new String(tmp, 0, i));
                rez = new String(tmp, 0, i);
            }
            if (channelexec.isClosed() || TIMEOUT <= 0) {
                System.out.println("exit-status: "+channelexec.getExitStatus());
                break;
            }
            try {
                Thread.sleep(5000);
            } catch (Exception e) {
                rez = e.toString();
            }
            TIMEOUT = TIMEOUT-5000;
        }
        channelexec.disconnect();
        session.disconnect();
    }

    catch (Exception e) {
        rez = e.toString();
    }
    return rez;

	}

	public boolean isFilePresent(String agentFile) {
		 SftpATTRS attrsJson = null;
		 boolean flag = false;
		 try {
			 attrsJson = getAttributes(agentFile);
			 if (attrsJson.getSize() > 0) {
				 flag = true;
			 }
		 } catch (Exception ex) {
			 return flag;
		 }
		return flag;
	}
	

}
*/