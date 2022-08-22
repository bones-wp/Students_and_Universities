package JAXB;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;

public class JavaToXml {

    public static void javaToXml(JAXBContext context) throws JAXBException, IOException {
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        if (!Files.isDirectory(Path.of("src/main/resources/XmlFiles"))){
            Files.createDirectory(Path.of("src/main/resources/XmlFiles"));
        }

        File file = new File("src/main/resources/XmlFiles/exercise.xml" + "_" + LocalDate.now());

        Info info = new Info();

        marshaller.marshal(info, file);
    }

}
