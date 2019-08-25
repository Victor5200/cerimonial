package br.com.podce.adm.config.spring;

import br.com.podce.exceptions.PodceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.List;

//Classe com error
@Component
public class EmailEnviador {

	/*private static final String CHARSET = "ISO-8859-1";

	private static final Logger LOGGER = LoggerFactory.getLogger(EmailEnviador.class);

	@Autowired
	private JavaMailSender javaMailSender;

	@Value("${mail.usuario}")
	private String EMAIL_FROM;

	public void enviarEmail(InternetAddress[] destinatario, InternetAddress[] copia, String assunto, String conteudo, List<byte[]> anexos) {
		MimeMessage email = javaMailSender.createMimeMessage();
		try {
			MimeMessageHelper helper = new MimeMessageHelper(email, false, CHARSET);
			helper.setTo(destinatario);
			if (copia!=null) {
				helper.setCc(copia);
			}
			helper.setSubject(assunto);
			helper.setFrom(EMAIL_FROM);
			helper.setText(conteudo, true);
			if (anexos!=null) {
				Integer indiceAnexo = 1;
				for (byte[] anexo : anexos) {
					helper.addAttachment("Anexo "+indiceAnexo++, new ByteArrayResource(anexo));
				}
			}
			javaMailSender.send(email);
		} catch (MessagingException e) {
			LOGGER.error("Exceção lançada: ".concat("Erro email enviador"), e);
		}
	}

	public void enviarEmail(String destinatario, String copia, String assunto, String conteudo, byte[] anexo, String responderPara) throws PodceException {
		MimeMessage email = javaMailSender.createMimeMessage();
		try {
			MimeMessageHelper helper = new MimeMessageHelper(email, true, CHARSET);
			helper.setTo(destinatario);
			if(copia != null){
				helper.setCc(copia);
			}
			if(responderPara != null){
				helper.setReplyTo(responderPara);
			}
			helper.setSubject(assunto);
			helper.setFrom(EMAIL_FROM);
			helper.setText(conteudo, true);
			if (anexo!=null) {
				Integer indiceAnexo = 1;
				helper.addAttachment("Anexo", new ByteArrayResource(anexo));
			}
			javaMailSender.send(email);
		} catch (MessagingException e) {
			LOGGER.error("Exceção lançada: ".concat("Erro email enviador"), e);
			throw new PodceException("Erro email enviador");
		}
	}
*/
}
