package com.github.rodolfoba;

import org.demoiselle.signer.core.extension.BasicCertificate;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.io.InputStream;
import java.util.logging.Logger;

@Path("/")
public class Resource {

    private static final Logger logger = Logger.getLogger(Resource.class.getName());

    @GET
    @Path("/test")
    public String hello() throws Exception {
        BasicCertificate certificate;
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("google.com.br.crt")) {
            certificate = new BasicCertificate(inputStream);
        }

        logger.info(certificate.toString());
        return "Certificate: " + certificate.getSerialNumber() + " - " + certificate.getName();
    }

}
