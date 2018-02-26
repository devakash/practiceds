package practice.arrays;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.internet.MimeMessage.RecipientType;

import com.sun.mail.smtp.SMTPMessage;

public class Email {
	static DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-YYYY");
	static Date date = new Date();

	public void SendEmail(String filePath, String messageBody)
			throws IOException, AddressException, MessagingException {
		System.out.println("Authentication in progress :");
		Session session = buildGoogleSession();

		Message simpleMessage = buildSimpleMessage(session);
		sendMessageToAddress(simpleMessage, "test@gmail.com");

		System.out.println("SendEmail.............End");
	}

	/**
	 * Build a Session object for an SMTP server that requires both TSL and
	 * authentication. This uses Gmail as an example of such a server
	 * 
	 * @return a Session for sending email
	 */
	public static Session buildGoogleSession() {
		Properties mailProps = new Properties();
		mailProps.setProperty("mail.smtp.host", "smtp.gmail.com");
		mailProps.put("mail.smtp.starttls.enable", "true");
		mailProps.setProperty("mail.smtp.auth", "true");
		final PasswordAuthentication usernamePassword = new PasswordAuthentication("emailusername", "password");
		Authenticator auth = new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return usernamePassword;
			}
		};
		Session session = Session.getInstance(mailProps, auth);
		return session;
	}

	/**
	 * Build a simple text message - no attachments.
	 * 
	 * @param session
	 * @return a multipart MIME message with only one part, a simple text
	 *         message.
	 * @throws MessagingException
	 */
	public static Message buildSimpleMessage(Session session) throws MessagingException {
		SMTPMessage m = new SMTPMessage(session);
		MimeMultipart content = new MimeMultipart();
		MimeBodyPart mainPart = new MimeBodyPart();
		mainPart.setText("Hello there! This is simple demo message");
		content.addBodyPart(mainPart);
		m.setContent(content);
		m.setSubject("Demo message");
		return m;
	}

	private static void addAttachment(Multipart multipart, String file) throws MessagingException, IOException {
		MimeBodyPart imagePart = new MimeBodyPart();
		imagePart.attachFile(file);
		multipart.addBodyPart(imagePart);
	}

	/**
	 * Build a text message with an image as an attachment.
	 * 
	 * @param session
	 * @return a multipart MIME message where the first part is a text message
	 *         and the second part is an image
	 * @throws MessagingException
	 * @throws IOException
	 */
	public Message buildMessageWithAttachment(Session session, String filePath, String bodyText)
			throws MessagingException, IOException {
		SMTPMessage m = new SMTPMessage(session);
		MimeMultipart content = new MimeMultipart("related");
		// HTML part
		MimeBodyPart textPart = new MimeBodyPart();
		textPart.setText(bodyText, "US-ASCII", "html");
		content.addBodyPart(textPart);
		// Image part
		addAttachment(content, filePath);
		m.setContent(content);
		m.setSubject("Demo Message with attachement");
		return m;
	}

	/**
	 * Send the message with Transport.send(Message)
	 * 
	 * @param message
	 * @param recipient
	 * @throws MessagingException
	 */
	public static void addressAndSendMessage(Message message, String recipient)
			throws AddressException, MessagingException {
		message.setRecipient(RecipientType.TO, new InternetAddress(recipient));
		Transport.send(message);
	}

	/**
	 * Send the message with Transport.send(Message, Address[])
	 * 
	 * @param message
	 * @param recipient
	 * @throws MessagingException
	 */
	public static void sendMessageToAddress(Message message, String recipient) throws MessagingException {
		InternetAddress[] recipients = { new InternetAddress(recipient) };
		Transport.send(message, recipients);
	}

	public static void main(String[] args) throws AddressException, IOException, MessagingException {

		new Email().SendEmail("C:\\Users\\ajain5\\Downloads\\MPLSuiteRunner.java", "hi");

	}
}