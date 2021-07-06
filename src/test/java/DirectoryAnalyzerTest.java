import com.example.DirectoryAnalyzer;
import com.example.DirectoryReport;
import com.example.FileDetails;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class DirectoryAnalyzerTest {

  @Test
  public void moreCollectionsTest() {
    DirectoryAnalyzer directoryAnalyzer = new DirectoryAnalyzer();
    List<FileDetails> files = new ArrayList<>();
    for (int i = 1; i <= 10000; i++) {
      FileDetails file1 = new FileDetails(i * 1000L, "c"+i, "file" + i);
      files.add(file1);
    }
    directoryAnalyzer.add(files);
    DirectoryReport report = directoryAnalyzer.getReport(5);
    Assert.assertEquals(44328000L, report.getTotalSizeBytes().longValue());
    Assert.assertEquals(5, report.getTopDirectories().size());
    System.out.println(report);
  }

  @Test
  public void moreFilesTest() {
    DirectoryAnalyzer directoryAnalyzer = new DirectoryAnalyzer();
    List<FileDetails> files = new ArrayList<>();
    for (int i = 1; i <= 10000; i++) {
      FileDetails file1 = new FileDetails(i * 1000L, i % 2 == 0 ? "c1" : "c2", "file" + i);
      files.add(file1);
    }
    directoryAnalyzer.add(files);
    DirectoryReport report = directoryAnalyzer.getReport(5);
    Assert.assertEquals(50005000000L, report.getTotalSizeBytes().longValue());
    Assert.assertEquals(2, report.getTopDirectories().size());
    System.out.println(report);
  }

  @Test
  public void moreKThanFiles() {
    DirectoryAnalyzer directoryAnalyzer = new DirectoryAnalyzer();
    List<FileDetails> files = new ArrayList<>();
    FileDetails file1 = new FileDetails(300L, "c1", "file1");
    FileDetails file2 = new FileDetails(400L, "c2", "file2");
    FileDetails file3 = new FileDetails(800L, "c2", "file3");
    files.add(file1);
    files.add(file2);
    files.add(file3);
    directoryAnalyzer.add(files);
    DirectoryReport report = directoryAnalyzer.getReport(5);
    Assert.assertEquals(2, report.getTopDirectories().size());
    Assert.assertEquals(1500, report.getTotalSizeBytes().longValue());
    report.getTopDirectories();
    System.out.println(report);
  }

  @Test
  public void emptyReportTest() {
    DirectoryAnalyzer directoryAnalyzer = new DirectoryAnalyzer();
    DirectoryReport report = directoryAnalyzer.getReport(3);
    System.out.println(report);
    Assert.assertEquals(0L, report.getTotalSizeBytes().longValue());
    Assert.assertEquals(0, report.getTopDirectories().size());
  }

  @Test
  public void basicTest() {
    DirectoryAnalyzer directoryAnalyzer = new DirectoryAnalyzer();
    List<FileDetails> files = new ArrayList<>();
    FileDetails file1 = new FileDetails(100L, "c1", "file1");
    FileDetails file2 = new FileDetails(200L, "c2", "file2");
    FileDetails file3 = new FileDetails(400L, "c2", "file3");
    files.add(file1);
    files.add(file2);
    files.add(file3);
    directoryAnalyzer.add(files);
    DirectoryReport report = directoryAnalyzer.getReport(1);
    System.out.println(report);
    Assert.assertEquals(600L, report.getTotalSizeBytes().longValue());
    Assert.assertEquals(1, report.getTopDirectories().size());
  }
}
