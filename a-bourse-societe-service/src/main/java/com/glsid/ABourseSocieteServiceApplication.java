package com.glsid;

import com.glsid.dao.SocieteRepository;
import com.glsid.entitites.Societe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.rest.RepositoryRestMvcAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;

import java.util.stream.Stream;

@SpringBootApplication
@EnableEurekaClient
public class ABourseSocieteServiceApplication implements CommandLineRunner {
    @Autowired
    private SocieteRepository societeRepository;

    public static void main(String[] args) {
        SpringApplication.run(ABourseSocieteServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Stream.of("Axa assuranmce","Societe generale","Banque populaire","Wafasalaf",
                "WafaAssurance","CocaCola","AttijariWafaBanque","Safran","Bnp Baribas",
                "Itissalat-Al-Maghreb","Inwi","Orange","El Doha","Allianze","Peugeot"
                ).forEach(s->societeRepository.save(new Societe(s)));
        societeRepository.findAll().forEach(s-> System.out.println(s.getNomSociete()));
    }
}

@Configuration
class MyConfig implements RepositoryRestConfigurer {

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        config.exposeIdsFor(Societe.class);
    }

}
