package com.els.jewellery.manage.modular.utils;

import java.io.InputStream;
import java.net.URL;
import java.util.Properties;
import java.util.UUID;
import java.util.logging.Logger;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

public class SFtpUtil {
		private static Logger log = Logger.getLogger(SFtpUtil.class.getName());
	
		protected String host = "39.108.169.195";//sftp服务器ip
	    protected String username = "qqtadmin";//用户名
	    protected String password;//密码
	    protected String privateKey;//密钥文件路径
	    protected String passphrase = "wzy6235666";//密钥口令
	    protected int port = 22195;//默认的sftp端口号是22
	    private ChannelSftp sftp = null;
	    private Session sshSession = null;

	    /**
	     * 获取连接
	     * @return channel
	     */
	    public ChannelSftp connectSFTP() {
	    	
	    	ClassLoader classLoader = ImageHandleHelper.class.getClassLoader();  
	        URL resource = classLoader.getResource("gy.pub");
	        String path = resource.getPath();  
	        privateKey = path;
	        JSch jsch = new JSch();
	        Channel channel = null;
	        try {
	            if (privateKey != null && !"".equals(privateKey)) {
	            	 jsch.addIdentity(privateKey, passphrase);
	            }
	            sshSession = jsch.getSession(username, host, port);
	            if (password != null && !"".equals(password)) {
	            	sshSession.setPassword(password);
	            }
	            Properties sshConfig = new Properties();
	            sshConfig.put("StrictHostKeyChecking", "no");// do not verify host key
	            sshSession.setConfig(sshConfig);
	            // session.setTimeout(timeout);
	            sshSession.setServerAliveInterval(92000);
	            sshSession.connect();
	            //参数sftp指明要打开的连接是sftp连接
	            channel = sshSession.openChannel("sftp");
	            channel.connect();
	        } catch (JSchException e) {
	            e.printStackTrace();
	        }
	        return (ChannelSftp) channel;
	    }
	    
	    /**
	     * 上传文件
	     * 
	     * @param directory
	     *            上传的目录
	     * @param uploadFile
	     *            要上传的文件
	     * @param sftp
	     */
	    public String upload(String directory, InputStream  uploadFile, ChannelSftp sftp) {
	    		String name = UUID.randomUUID() + ".png";
	        try {
	            sftp.cd(directory);
	            sftp.put(uploadFile,name);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        disconnect();
	        return name;
	    }
		
	    public void disconnect()
	    {
	      if (this.sftp != null)
	      {
	        if (this.sftp.isConnected())
	        {
	          this.sftp.disconnect();
	         
	        }
	      }
	      if (this.sshSession != null)
	      {
	        if (this.sshSession.isConnected())
	        {
	          this.sshSession.disconnect();
	        }
	      }
	    }
	
	
}
