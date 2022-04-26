package finger.slave.service.collector;

import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.context.SpringBootTest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.*;
import static org.junit.jupiter.api.Assertions.*;

import finger.slave.domain.vo.*;

@SpringBootTest
public class FingerSlaveTest{
	
	@Autowired
	private FingerSlave fingerSlave;
	
	@Test
	public void FingerSlave_Test(){
		// given
		String uri = "https://dnd.ac";
		
		// when
		Site result = this.fingerSlave.work(uri);
		
		// then
		assertEquals(result.getUri(), uri);
	}
	
}