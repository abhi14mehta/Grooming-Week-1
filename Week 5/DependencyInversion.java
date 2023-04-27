import java.util.ArrayList;
import java.util.List;

class Data{
    // body for data
}

interface DataFetcher {
    List<Data> fetchData();
}

class ReportGenerator {
    private final DataFetcher dataFetcher;
    //private final DataFetcher datafeacher;

    public ReportGenerator(DataFetcher dataFetcher) {
        this.dataFetcher = dataFetcher;
        //dataFetcher = new DataFetcher();
    }

    public void generateReport() {
        List<Data> data = dataFetcher.fetchData();
        System.out.println(data);
    }
}

class DatabaseDataFetcher implements DataFetcher {
    public List<Data> fetchData() {
        // retrieve data from database
        List<Data> data = new ArrayList<>();
        return data;
    }
}

class FileDataFetcher implements DataFetcher {
    public List<Data> fetchData() {
        // retrieve data from file
        List<Data> data = new ArrayList<>();
        return data;
    }
}


public class DependencyInversion {
    public static void main(String[] args) {
        
    }
}
