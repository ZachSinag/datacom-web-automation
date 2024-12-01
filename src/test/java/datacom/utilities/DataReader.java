package datacom.utilities;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class DataReader {
    private final static String CSV_PATH = "src/test/resources/testdata/";

    public DataReader() {

    }

    public Map<String, DataModel> customerInput() throws IOException {
        List<DataModel> testData = this.convertCsvToList(CSV_PATH, "data.csv",
                DataModel.class);
        Map<String, DataModel> Data = new HashMap<>();
        for (DataModel data : testData) {
            //System.out.println(data);
            Data.put(data.getIdentifier(),data);
        }
        return Data;
    }

    private <T> List<T> convertCsvToList(String basePath, String fileName, Class<T> clazz) throws IOException {
        Reader reader = Files.newBufferedReader(Paths.get(basePath + fileName));

        CsvToBean<T> csvToBean = new CsvToBeanBuilder<T>(reader)
                .withType(clazz)
                .withIgnoreLeadingWhiteSpace(true)
                .build();

        List<T> list = csvToBean.parse();

        return list;
    }

}
