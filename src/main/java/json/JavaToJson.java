package json;

import JAXB.Info;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import org.eclipse.persistence.jaxb.MarshallerProperties;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;

public class JavaToJson {
    public static void javaToJson (JAXBContext context) throws JAXBException, IOException {
        Marshaller marshaller = context.createMarshaller();

        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.setProperty(MarshallerProperties.MEDIA_TYPE, "application/json");
        marshaller.setProperty(MarshallerProperties.JSON_INCLUDE_ROOT, true);

        if (!Files.isDirectory(Path.of("src/main/resources/JsonFiles"))){
            Files.createDirectory(Path.of("src/main/resources/JsonFiles"));
        }

        File file = new File("src/main/resources/JsonFiles/exercise.json" + "_" + LocalDate.now());

        Info info = new Info();

        marshaller.marshal(info, file);
    }

}
