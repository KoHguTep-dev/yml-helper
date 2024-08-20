package utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLGenerator;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class YmlWriter {

    private final ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory()
            .disable(YAMLGenerator.Feature.WRITE_DOC_START_MARKER)
    );

    public void writeList(List<Map<Object, Object>> list, String subFolder) {

        File subDir = new File("./result/" + subFolder);
        if (!subDir.exists()) {
            subDir.mkdir();
            File datasets = new File(subDir, "datasets");
            datasets.mkdir();
        }

        for (var view : list) {
            String alias;
            alias = (String) view.get("alias");

            File file = new File("./result/" + subFolder + "/datasets/" + alias + ".yml");

            try {
                objectMapper.writerWithDefaultPrettyPrinter().writeValue(file, view);
                System.out.println("write " + file.getPath());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }

}
