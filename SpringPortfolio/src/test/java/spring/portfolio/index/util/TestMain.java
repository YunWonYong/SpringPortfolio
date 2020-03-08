package spring.portfolio.index.util;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.spring.portfolio.common.util.json.Json;

public class TestMain {

	public static void main(String[] args) throws Exception {
		long start = System.currentTimeMillis();
		String json = Json.parsing(Arrays.asList("1test1:1test1,1test2:1test2"));
		System.out.println(json);
		json=Json.parsing(Arrays.asList("2test1:2test1,2test2:2test2"));
		System.out.println(json);
		json =Json.parsing(Arrays.asList("3test1:3test1,3test2:3test2","4test1:4test1,4test2:4test2","5test1:5test1,5test2:5test2,5test3:5test3"));
		System.out.println(json);
		json = Json.parsing(Arrays.asList("6testFalse:false,6testTrue:true,6test:null"));
		System.out.println(json);
		long end = System.currentTimeMillis();
		System.out.print(Double.valueOf((end-start)/1000));
	}
}
