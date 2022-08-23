package JAXB;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import json.JavaToJson;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.logging.Logger;

public class JavaToXml {
    public static final Logger JavaToXmlLog = Logger.getLogger(JavaToXml.class.getName());

    public static void javaToXml(JAXBContext context) throws JAXBException, IOException {
        JavaToXmlLog.info("Сериализация списков объектов в XML начата");

        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        if (!Files.isDirectory(Path.of("src/main/resources/XmlFiles"))){
            Files.createDirectory(Path.of("src/main/resources/XmlFiles"));
        }

        File file = new File("src/main/resources/XmlFiles/exercise.xml" + "_" + LocalDate.now());

        Info info = new Info();

        marshaller.marshal(info, file);

        JavaToXmlLog.info("Сериализация списков объектов в XML завершена");
    }

}
