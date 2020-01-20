package junittest;

import java.io.*;
import org.junit.*;
import static org.junit.Assert.*;
import simulate.*;

public class jtestAES {
    Teststub ts;
	@Before	
	public void setUp()  {
		ts=new Teststub();
	}
	//@BeforeClass
	
	@Test
	public void testsimulate() throws IOException {
		try{
			//read test cases and expected output from text files
			FileReader fr=new FileReader("E:/Courses/SYSC5105/Sysc5105project/Sysc5105project/All test suites and expected output/AllEdgeSlower.txt");
            BufferedReader br=new BufferedReader(fr);
            FileReader frr=new FileReader("E:/Courses/SYSC5105/Sysc5105project/Sysc5105project/All test suites and expected output/AllEdgeSlowerOracle.txt");
            BufferedReader brr=new BufferedReader(frr);
            String line="";
            String expectedanswer="";
            String actualanswer="";
            while ((line=br.readLine())!=null) { //read test case one by one
                expectedanswer=brr.readLine();
                actualanswer=ts.testdriver(line);
                assertEquals(expectedanswer, actualanswer); //do comparison between reality output and expected output
            }
            br.close();
            fr.close();
            brr.close();
            frr.close();
		}catch (Exception e) {}
	}
}
