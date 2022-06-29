package com.example.shosai.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.shosai.Dao.UsuarioRepository;
import com.example.shosai.domain.Usuario;
import com.example.shosai.servicioMail.EnvioEmail;

@Controller
public class ContactController {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private EnvioEmail envioEmail;

    @Autowired
    private UsuarioRepository usuarioRepositorio;

////////////////////////////////ENVIO DE CORREOS
//////////////////////////////// MASIVOS EMPLEADOS/////////////////////////////////////////////////
    @GetMapping("/contact")
    public String showContactClientsForm() {

        return "envioCorreoUser";
    }

    @PostMapping("/contact")
    public String submitContactC(HttpServletRequest request, RedirectAttributes redirectAttrs,
            @RequestParam("attachment") MultipartFile multipartFile)
            throws MessagingException, UnsupportedEncodingException {

        String fullname = request.getParameter("fullname");
        String email = request.getParameter("email");
        String subject = request.getParameter("subject");
        String content = request.getParameter("content");

        List<Usuario> listClients = usuarioRepositorio.findAll();

        String mailContent = "<p><b>Nombre del remitente: </b>" + fullname + "</p>";
        mailContent += "<p><b>Correo de contacto: </b>" + email + "</p>";
        mailContent += "<p><b>Asunto: </b>" + subject + "</p>";
        mailContent += "<p><b>Mensaje: </b>" + content + "</p>";
        mailContent += "<hr><img src='cid:logoImage' />";

        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());

        try {

            for (Usuario c : listClients) {

                try {
                    envioEmail.sendEmail(subject, mailContent, c.getCorreo(), fileName, multipartFile);

                } catch (Exception e) {
                    redirectAttrs.addFlashAttribute("mensaje", "No se pudo enviar los correos")
                            .addFlashAttribute("clase", "danger");
                    return "redirect:/contact";
                }

            }

            redirectAttrs.addFlashAttribute("mensaje", "Los correos se enviaron exitosamente")
                    .addFlashAttribute("clase", "warning");
            return "redirect:/contact";

        } catch (Exception e) {
            redirectAttrs.addFlashAttribute("mensaje", "No se pudo enviar todos los mensajes")
                    .addFlashAttribute("clase", "danger");
            return "redirect:/contact";
        }
    }

}
