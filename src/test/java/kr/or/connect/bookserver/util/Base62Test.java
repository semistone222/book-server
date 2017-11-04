package kr.or.connect.bookserver.util;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class Base62Test {

	@Test
	public void shouldConvert() throws Exception {
		long id = 12354123;
		String converted = Base62.base62(id);
		System.out.println("id : " + id + " -> converted : " + converted);
		long reConverted = Base62.base62(converted);
		assertThat(id, is(reConverted));
	}
 }
